package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Label;
import com.example.app.entity.Note;
import com.example.app.entity.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    List<Note> findByOwner(User owner);

    Optional<Note> findByNoteIdAndOwner(
            int noteId,
            User owner);

    List<Note> findByOwnerAndPinnedTrue(
            User owner);

    List<Note> findByOwnerAndArchivedTrue(
            User owner);

    List<Note> findByOwnerAndTrashedTrue(
            User owner);

    List<Note> findByOwnerAndTrashedFalseAndArchivedFalse(
            User owner);

    List<Note> findByOwnerAndTitleContainingIgnoreCaseOrOwnerAndContentContainingIgnoreCase(
            User owner1,
            String title,
            User owner2,
            String content);

    List<Note> findByOwnerAndLabelsContaining(
            User owner,
            Label label);
}