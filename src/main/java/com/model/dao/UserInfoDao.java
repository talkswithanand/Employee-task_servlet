package com.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Task;
import com.dto.UserInfo;

public class UserInfoDao {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("anand");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static UserInfo createUserInfo(String userName, String password, String email, String role,
			String designation, double salary) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(userName);
		userInfo.setPassword(password);
		userInfo.setEmail(email);
		userInfo.setRole(role);
		userInfo.setDesignation(designation);
		userInfo.setSalary(salary);
		return userInfo;
	}

	public static void persistUserInfo(String userName, String password, String email, String role, String designation,
			double salary) {
		UserInfo userInfo = createUserInfo(userName, password, email, role, designation, salary);
		entityTransaction.begin();
		entityManager.persist(userInfo);
		entityTransaction.commit();
	}

	public static int findUserByUserName(String userName, String password) {
		Query query = entityManager.createQuery("Select u from UserInfo u where u.name=?1 and u.password=?2");
		query.setParameter(1, userName);
		query.setParameter(2, password);
		List<UserInfo> users = query.getResultList();
		if (users.size() == 1) {
			return users.get(0).getId();
		}
		return -1;
	}
	
	public static List<UserInfo> showAllEmployees() {
		Query query = entityManager.createQuery("Select u from UserInfo u where u.role=?1");
		query.setParameter(1, "Employee");
		 return query.getResultList();
	}
	
	public static void updateListOfTasks(int employeeId, List<Task> tasks) {
		UserInfo employee = entityManager.find(UserInfo.class, employeeId);
		employee.setTasks(tasks);
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
	}
	
}
