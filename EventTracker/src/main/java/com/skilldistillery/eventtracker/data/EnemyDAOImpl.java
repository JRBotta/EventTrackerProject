package com.skilldistillery.eventtracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.eventtracker.entities.Enemy;

@Transactional
@Service
public class EnemyDAOImpl implements EnemyDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Enemy> getAllEnemies() {
		String query = "SELECT e FROM Enemy e";
		return em.createQuery(query, Enemy.class).getResultList();
	}

	@Override
	public Enemy createEnemy(String json) {
		Enemy enemy = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			enemy = mapper.readValue(json, Enemy.class);
			em.persist(enemy);
			em.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return enemy;
	}

	@Override
	public Enemy getEnemy(int id) {
		return em.find(Enemy.class, id);
	}

	@Override
	public Enemy replaceEnemy(int id, String json) {
		Enemy enemy = em.find(Enemy.class, id);
		Enemy newEnemy = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			newEnemy = mapper.readValue(json, Enemy.class);
			enemy.setName(newEnemy.getName());
			enemy.setHp(newEnemy.getHp());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return enemy;
	}

	@Override
	public Enemy updateEnemy(int id, String json) {
		Enemy enemy = em.find(Enemy.class, id);
		Enemy newEnemy = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			newEnemy = mapper.readValue(json, Enemy.class);
			if (newEnemy.getName() != null && newEnemy.getName() != "") {
				enemy.setName(newEnemy.getName());
			}
			enemy.setHp(newEnemy.getHp());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return enemy;
	}

	@Override
	public Boolean deleteEnemy(int id) {
		try {
			em.remove(em.find(Enemy.class, 1));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Double getEnemyAverage() {
		String query = "SELECT avg(e.hp) FROM Enemy e";
		return em.createQuery(query, Double.class).getSingleResult();
	}

}
