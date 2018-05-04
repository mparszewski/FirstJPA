package model;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeCRUD {
	private EntityManagerFactory entityManagerFactory;

	EmployeeCRUD() {
		entityManagerFactory = Persistence.createEntityManagerFactory("FirstJPA");
	}

	public void createEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void readEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, new BigDecimal(id));
		System.out.println("Employee id: " + employee.getEmployeeId());
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("Last name: " + employee.getLastName());
		System.out.println("Email: " + employee.getEmail());
		System.out.println("Phone number: " + employee.getPhoneNumber());
		System.out.println("Hire Date: " + employee.getHireDate());
		System.out.println("Job id: " + employee.getJobId());
		System.out.println("Salary: " + employee.getSalary());
		System.out.println("Commission PCT: " + employee.getCommissionPct());
		System.out.println("Manager id: " + employee.getManagerId());
		System.out.println("Department id: " + employee.getDepartmentId() + "\n");
	}

	public void updateSalary(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, new BigDecimal(id));
		entityManager.getTransaction().begin();
		employee.setSalary(employee.getSalary().multiply(new BigDecimal(1.1)));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void deleteEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, new BigDecimal(id));
		entityManager.getTransaction().begin();
		entityManager.remove(employee);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void finalize() {
		entityManagerFactory.close();
	}

}
