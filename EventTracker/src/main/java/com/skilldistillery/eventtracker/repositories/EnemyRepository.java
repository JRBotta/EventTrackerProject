package com.skilldistillery.eventtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skilldistillery.eventtracker.entities.Enemy;

public interface EnemyRepository extends JpaRepository<Enemy, Integer> {
	
	@Query("SELECT avg(e.hp) FROM Enemy e")
	public Double getAverage();

}
