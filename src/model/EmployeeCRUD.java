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
		if (employeeExists(employee.getEmployeeId())) {
			System.out.println("Pracownik ju¿ istnieje \n");
		} else {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}

	public void readEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, new BigDecimal(id));
		if (employee != null) {
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
	}

	public void updateSalary(int id) {
		if (employeeExists(new BigDecimal(id))) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Employee employee = entityManager.find(Employee.class, new BigDecimal(id));
			entityManager.getTransaction().begin();
			employee.setSalary(employee.getSalary().multiply(new BigDecimal(1.1)));
			System.out.println(employee.getSalary());
			entityManager.getTransaction().commit();
			entityManager.close();
		} else
			System.out.println("Pracownik o podanym id nie istnieje. Nie mo¿na podnieœæ jego pensji. \n");
	}

	public void deleteEmployee(int id) {
		if (employeeExists(new BigDecimal(id))) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Employee employee = entityManager.find(Employee.class, new BigDecimal(id));
			entityManager.getTransaction().begin();
			entityManager.remove(employee);
			entityManager.getTransaction().commit();
			entityManager.close();
		} else
			System.out.println("Pracownik o podanym id nie istnieje. Nie mo¿na go usun¹æ \n");
	}

	public boolean employeeExists(BigDecimal id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, id);
		if (employee == null)
			return false;
		else
			return true;
	}

	@Override
	public void finalize() {
		entityManagerFactory.close();
	}

}
