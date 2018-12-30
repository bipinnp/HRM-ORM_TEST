package com.hrm.orm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "departments")
public class Department extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1168200564688321604L;

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	@Column(name="DEPARTMENT_ID")
	private String id; 
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
	@Column(name="DEPARTMENT_NAME", unique=true, nullable=false, length=50)
	private String department_name;
	
	@Column(name="MANAGER_ID")
	private String manager_id;
	
	@OneToMany(targetEntity=Employee.class, cascade=CascadeType.ALL, 
			   fetch = FetchType.LAZY, mappedBy="department")
	private Set<Employee>  employees = new HashSet<>();
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "location_id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private Location location;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDepartment_name() {
		return department_name;
	}
	
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
//	public Location getLocation() {
//		return location;
//	}
//	public void setLocation(Location location) {
//		this.location = location;
//	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
