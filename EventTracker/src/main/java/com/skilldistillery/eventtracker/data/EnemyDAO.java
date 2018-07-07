package com.skilldistillery.eventtracker.data;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Enemy;

public interface EnemyDAO {

	List<Enemy> getAllEnemies();

	Enemy createEnemy(String json);

	Enemy getEnemy(int id);

	Enemy replaceEnemy(int id, String json);

	Enemy updateEnemy(int id, String json);

	Boolean deleteEnemy(int id);

}
