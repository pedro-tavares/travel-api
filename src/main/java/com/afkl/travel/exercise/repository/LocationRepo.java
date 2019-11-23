package com.afkl.travel.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afkl.travel.exercise.model.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {
}
