import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dto.Task;
import com.dto.UserInfo;

public class Demo {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("anand");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static void main(String[] args) {
		UserInfo e = entityManager.find(UserInfo.class, 2);
		List<Task> tasks = e.getTasks();
		for(Task task: tasks) {
			System.out.println(task);
		}
	}
}
