package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.data.EnemyDAO;
import com.skilldistillery.eventtracker.entities.Enemy;


@RestController
@RequestMapping("api")
public class EnemyController {
	@Autowired
	EnemyDAO dao;
	
	@RequestMapping(path = "enemies", method = RequestMethod.GET)
	public List<Enemy> getAllEnemies() {
	  return dao.getAllEnemies();
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.GET)
	public Enemy getEnemy(@PathVariable int id) {
		return dao.getEnemy(id);
	}
	
	@RequestMapping(path = "enemies", method = RequestMethod.POST)
	public Enemy createEnemy(@RequestBody String json) {
		return dao.createEnemy(json);
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.PUT)
	public Enemy replaceEnemy(@PathVariable int id, @RequestBody String json) {
		return dao.replaceEnemy(id, json);
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.PATCH)
	public Enemy updateEnemy(@PathVariable int id, @RequestBody String json) {
		return dao.updateEnemy(id, json);
	}
	
	@RequestMapping(path = "enemies/{id}", method = RequestMethod.DELETE)
	public Boolean deleteEnemy(@PathVariable int id) {
		return dao.deleteEnemy(id);
	}
}
