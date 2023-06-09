package com.tr;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class saveplayer {

	public static void main(String[] args) throws IOException{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Player player = new Player();
		player.setName("chetan");
		player.setGender("male");
		player.setAge(23);
		
		player.setDateofjoin(new Date());
		
		FileInputStream fileInputStream = new FileInputStream("src/main/java/20220220_0923430001.jpg");
		byte[] data = new byte[fileInputStream.available()];
		fileInputStream.read(data);
		player.setImage(data);
		
		entityTransaction.begin();
		entityManager.persist(player);
		entityTransaction.commit();
			
	}
}
