package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {

	List<Label> findByOwnerId(int ownerId);

	Optional<Label> findByLabelIdAndOwnerId(int labelId, int ownerId);

	Optional<Label> findByNameAndOwnerId(String name, int ownerId);
}
