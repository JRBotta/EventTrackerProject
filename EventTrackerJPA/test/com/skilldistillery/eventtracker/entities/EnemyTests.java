package com.skilldistillery.eventtracker.entities;


import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class enemyTests {
	
	private static EntityManagerFactory emf;

	private EntityManager em;
	
	
	@BeforeAll
	public static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventTracker");
	}
	@BeforeEach
	  public void setUp() throws Exception {
	    em = emf.createEntityManager();
	  }
		
	
	@Test
	void test_get_enemy_name() {
		assertEquals("Goblin", em.find(Enemy.class, 1).getName());
	}
	
	
	@AfterEach
	public void tearDown() throws Exception {
		em.close();
	}
	@AfterAll
	public static void tearDownAll() throws Exception {
		emf.close();
	}
}
