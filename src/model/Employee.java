package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal commissionPct;
	private BigDecimal departmentId;
	private String email;
	private BigDecimal employeeId;
	private String firstName;
	private Date hireDate;
	private String jobId;
	private String lastName;
	private BigDecimal managerId;
	private String phoneNumber;
	private BigDecimal salary;

	public Employee() {
	}


	@Column(name="COMMISSION_PCT", precision=2, scale=2)
	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}


	@Column(name="DEPARTMENT_ID", precision=4)
	public BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}


	@Column(nullable=false, length=25)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="EMPLOYEE_ID", precision=6)
	public BigDecimal getEmployeeId() {
		return this.employeeId;
	}


	public void setEmployeeId(BigDecimal employeeId) {
		this.employeeId = employeeId;
	}


	@Column(name="FIRST_NAME", length=20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE", nullable=false)
	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	@Column(name="JOB_ID", nullable=false, length=10)
	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	@Column(name="LAST_NAME", nullable=false, length=25)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="MANAGER_ID", precision=6)
	public BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}


	@Column(name="PHONE_NUMBER", length=20)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Column(precision=8, scale=2)
	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}