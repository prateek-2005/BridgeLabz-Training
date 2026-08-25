package com.example.app.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;

import org.springframework.batch.core.configuration.annotation.StepScope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.app.entity.Note;
import com.example.app.entity.User;
import com.example.app.repository.NoteRepository;
import com.example.app.repository.UserRepository;

import org.springframework.batch.item.Chunk;

@Configuration
public class NoteBatchConfig {

	@Bean
	@StepScope
	public ExcelNoteReader excelNoteReader(@Value("#{jobParameters['filePath']}") String filePath) throws Exception {

		return new ExcelNoteReader(filePath);
	}

	@Bean
	@StepScope
	public ItemProcessor<ExcelNoteItem, Note> noteProcessor(UserRepository userRepository,
			@Value("#{jobParameters['userId']}") Long userId) {

		return item -> {

			User owner = userRepository.findById(userId.intValue())
					.orElseThrow(() -> new IllegalArgumentException("User not found"));

			Note note = new Note();

			note.setTitle(item.getTitle());
			note.setContent(item.getContent());
			note.setOwner(owner);

			return note;
		};
	}

	@Bean
	public ItemWriter<Note> noteWriter(NoteRepository noteRepository) {

		return chunk -> {

			for (Note note : chunk) {
				noteRepository.save(note);
			}
		};
	}

	@Bean
	public Step importNotesStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			ExcelNoteReader excelNoteReader, ItemProcessor<ExcelNoteItem, Note> noteProcessor,
			ItemWriter<Note> noteWriter) {

		return new StepBuilder("importNotesStep", jobRepository).<ExcelNoteItem, Note>chunk(10)
				.transactionManager(transactionManager).reader(excelNoteReader).processor(noteProcessor)
				.writer(noteWriter).build();
	}

	@Bean
	public Job importNotesJob(JobRepository jobRepository, Step importNotesStep) {

		return new JobBuilder("importNotesJob", jobRepository).start(importNotesStep).build();
	}
}