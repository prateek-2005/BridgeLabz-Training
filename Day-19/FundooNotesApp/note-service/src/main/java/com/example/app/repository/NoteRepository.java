package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    List<Note> findByOwnerId(int ownerId);

    Optional<Note> findByNoteIdAndOwnerId(
            int noteId,
            int ownerId);

    List<Note> findByOwnerIdAndPinnedTrue(
            int ownerId);

    List<Note> findByOwnerIdAndArchivedTrue(
            int ownerId);

    List<Note> findByOwnerIdAndTrashedTrue(
            int ownerId);

    List<Note> findByOwnerIdAndTrashedFalseAndArchivedFalse(
            int ownerId);

    List<Note> findByOwnerIdAndTitleContainingIgnoreCaseOrOwnerIdAndContentContainingIgnoreCase(
            int ownerId1,
            String title,
            int ownerId2,
            String content);

}
