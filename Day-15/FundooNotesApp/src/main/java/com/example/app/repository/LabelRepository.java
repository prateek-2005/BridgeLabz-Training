package com.example.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.entity.Label;
import com.example.app.entity.User;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {

	List<Label> findByOwner(User owner);

	Optional<Label> findByLabelIdAndOwner(int labelId, User owner);

	Optional<Label> findByNameAndOwner(String name, User owner);
}