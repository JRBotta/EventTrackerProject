package com.skilldistillery.eventtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Enemy;
import com.skilldistillery.eventtracker.repositories.EnemyRepository;

@Service
public class EnemyServiceImpl implements EnemyService {

	@Autowired
	EnemyRepository erepo;

	@Override
	public List<Enemy> index() {
		return erepo.findAll();
	}

	@Override
	public Enemy create(Enemy enemy) {
		if (enemy.getName() == null) {
			enemy.setName("Unnamed");
		}
		return erepo.saveAndFlush(enemy);
	}

	@Override
	public Enemy show(int id) {
		return erepo.findById(id).get();
	}

	@Override
	public Enemy replace(int id, Enemy enemy) {
		return erepo.saveAndFlush(enemy);
	}

	@Override
	public Enemy update(int id, Enemy enemy) {
		Enemy old = erepo.findById(id).get();
		if (enemy.getName() == null) {
			enemy.setName(old.getName());
		}

		if (enemy.getHp() == 0) {
			enemy.setHp(old.getHp());
		}
		return enemy;
	}

	@Override
	public Boolean delete(int id) {
		try {
			erepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Double getAverage() {
		return erepo.getAverage();
	}

	@Override
	public Enemy hit(int id) {
		Enemy old = erepo.findById(id).get();
		old.setHp(old.getHp() - 5);
		return erepo.saveAndFlush(old);
	}

}
