package model;

import java.math.BigDecimal;
import java.util.Date;

public class CRUD {

	public static void main(String[] args) {

		EmployeeCRUD employeeCRUD = new EmployeeCRUD();

		Employee employee = new Employee();
		employee.setCommissionPct(new BigDecimal(0.1));
		employee.setDepartmentId(new BigDecimal(90));
		employee.setEmail("MPARSZ");
		employee.setFirstName("M");
		employee.setHireDate(new Date());
		employee.setJobId("SA_REP");
		employee.setLastName("Parszewski");
		employee.setManagerId(new BigDecimal(172));
		employee.setPhoneNumber("789456123");
		employee.setSalary(new BigDecimal(50000));
		employee.setEmployeeId(new BigDecimal(500));

		employeeCRUD.createEmployee(employee);
		employeeCRUD.readEmployee(195);
		employeeCRUD.updateSalary(195);
		employeeCRUD.deleteEmployee(501);

		employeeCRUD.finalize();
	}

}
