package com.example.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Reminder;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Integer> {

	List<Reminder> findByOwnerId(int ownerId);

	List<Reminder> findByReminderTimeLessThanEqualAndProcessedFalseAndCompletedFalse(LocalDateTime time);
}
