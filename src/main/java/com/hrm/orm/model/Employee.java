package com.hrm.orm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employees")
public class Employee extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2693405803581842323L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	@Column(name="EMPLOYEE_ID")
	private String id;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
	@Column(name="FIRST_NAME")
	@NotNull(message = "First name is a required field")
	@Size(min = 1, max = 60,message = "First name should be at least 1 characters")
	private String first_name;
	
	@Column(name="LAST_NAME")
	@NotNull
	private String last_name;
	
	@Column(name="EMAIL", unique=true)
	@NotNull
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message="Invalid Email")
	private String email;
	
	@Column(name="PHONE_NUMBER", unique=true)
	@NotNull
	@Pattern(regexp="\\d{10}",message="Invalid phonenumber")
	private String phone_number;
	
	@Column(name="HIRE_DATE")
	@NotNull
	private String hire_date;
	
	@Column(name="SALARY")
	@Size(min=1)
	@NotNull
	private String salary;
	
	@Column(name="COMMISSION_PCT")
	private String commission_pct;
	
	@Column(name="MANAGER_ID")
	private String manager_id;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Department department;
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
	public String getFirst_name() {		
		return first_name;	
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getCommission_pct() {
		return commission_pct;
	}
	public void setCommission_pct(String commission_pct) {
		this.commission_pct = commission_pct;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
	 