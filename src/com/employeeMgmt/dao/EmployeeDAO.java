package com.employeeMgmt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.employeeMgmt.Model.Employee;

@Transactional
public class EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Employee getEmployeeDetails(Integer employeeId) {
		Employee emp = new Employee();
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, employeeId);
	}

	public Employee updateEmployeeDetails(Integer employeeId, String department) {
		Employee emp = getEmployeeDetails(employeeId);
		if (emp != null) {
			emp.setDepartment(department);
			return (Employee) sessionFactory.getCurrentSession().merge(emp);
		}
		return emp;
	}

	public void deleteEmployeeDetails(Integer employeeId) {
		Employee emp = getEmployeeDetails(employeeId);
		Session session = sessionFactory.getCurrentSession();
		session.delete(emp);

	}
	
	public void addEmployee(Employee emp) {
		if(emp != null){
			Session session = sessionFactory.getCurrentSession();
			session.save(emp);
		}
	}
	
}
