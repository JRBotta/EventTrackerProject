package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Enemy;

public interface EnemyService {

	List<Enemy> index();

	Enemy create(Enemy enemy);

	Enemy show(int id);

	Enemy replace(int id, Enemy enemy);

	Enemy update(int id, Enemy enemy);

	Boolean delete(int id);

	Double getAverage();

	Enemy hit(int id);
}
