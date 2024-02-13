package com.model.dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Task;
import com.dto.UserInfo;

public class TaskDao {

	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("anand");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static Task createTask(String description) {
		Task task = new Task();
		task.setDescription(description);
		task.setStatus("assigned");
		return task;
	}

	public static Task persistTask(int employeeId, String description) {
		UserInfo employee = entityManager.find(UserInfo.class, employeeId);
		Task task = createTask(description);
		task.setUserInfo(employee);
		entityTransaction.begin();
		entityManager.persist(task);
		entityTransaction.commit();
		return task;
	}

	public static List<Task> showAllTask() {
		Query query = entityManager.createQuery("Select t from Task t");
		return query.getResultList();
	}
	
	public static void updateTask(int taskId) {
		Task task = entityManager.find(Task.class, taskId);
		task.setStatus("completed");
		entityTransaction.begin();
		entityManager.merge(task);
		entityTransaction.commit();
	}
	
	public static List<Task> showEmployeeSpecificTask(int employeeId) {
		UserInfo user = entityManager.find(UserInfo.class, employeeId);
		return user.getTasks();
	}
}
