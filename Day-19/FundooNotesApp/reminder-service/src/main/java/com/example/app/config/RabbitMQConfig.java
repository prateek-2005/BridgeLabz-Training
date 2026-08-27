package com.example.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	public static final String REMINDER_QUEUE = "fundoo.reminders";
	public static final String REMINDER_EXCHANGE = "fundoo.exchange";
	public static final String REMINDER_ROUTING_KEY = "reminder.created";

	@Bean
	public Queue reminderQueue() {
		return new Queue(REMINDER_QUEUE, true);
	}

	@Bean
	public DirectExchange reminderExchange() {
		return new DirectExchange(REMINDER_EXCHANGE);
	}

	@Bean
	public Binding reminderBinding(Queue reminderQueue, DirectExchange reminderExchange) {

		return BindingBuilder.bind(reminderQueue).to(reminderExchange).with(REMINDER_ROUTING_KEY);
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter converter) {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter);
		return rabbitTemplate;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
			Jackson2JsonMessageConverter converter) {

		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(converter);

		return factory;
	}
}