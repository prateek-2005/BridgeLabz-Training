package com.example.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.NoteLabel;

@Repository
public interface NoteLabelRepository extends JpaRepository<NoteLabel, Integer> {

    Optional<NoteLabel> findByNoteIdAndLabelIdAndOwnerId(int noteId, int labelId, int ownerId);

    void deleteByLabelIdAndOwnerId(int labelId, int ownerId);
}
