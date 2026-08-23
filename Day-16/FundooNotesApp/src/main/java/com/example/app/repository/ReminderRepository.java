package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Reminder;
import com.example.app.entity.User;

@Repository
public interface ReminderRepository
        extends JpaRepository<Reminder, Integer> {

    List<Reminder> findByOwner(User owner);
}
