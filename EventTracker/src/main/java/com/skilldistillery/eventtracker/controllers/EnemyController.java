package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Enemy;
import com.skilldistillery.eventtracker.services.EnemyService;


@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4200"})
public class EnemyController {
	
	@Autowired
	EnemyService enemyService;
	
	@RequestMapping(path = "enemies", method = RequestMethod.GET)
	public List<Enemy> getAllEnemies() {
	  return enemyService.index();
	}
	@RequestMapping(path = "enemies/avg", method = RequestMethod.GET)
	public Double getEnemyAverageHealth() {
		return enemyService.getAverage();
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.GET)
	public Enemy getEnemy(@PathVariable int id) {
		return enemyService.show(id);
	}
	
	@RequestMapping(path = "enemies", method = RequestMethod.POST)
	public Enemy createEnemy(@RequestBody Enemy enemy) {
		return enemyService.create(enemy);
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.PUT)
	public Enemy replaceEnemy(@PathVariable int id, @RequestBody Enemy enemy) {
		return enemyService.replace(id, enemy);
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.PATCH)
	public Enemy updateEnemy(@PathVariable int id, @RequestBody Enemy enemy) {
		return enemyService.update(id, enemy);
	}
	@RequestMapping(path = "enemies/{id}/hit", method = RequestMethod.PATCH)
	public Enemy hitEnemy(@PathVariable int id) {
		return enemyService.hit(id);
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.DELETE)
	public Boolean deleteEnemy(@PathVariable int id) {
		return enemyService.delete(id);
	}
}
