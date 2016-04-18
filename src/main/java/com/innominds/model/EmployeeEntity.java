package com.innominds.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Employee")
@Table(name = "employee_tbl")
@NamedQueries({ @NamedQuery(name = "employeeById", query = "SELECT e FROM Employee e WHERE e.id=:id"),
        @NamedQuery(name = "getRecentEmployee", query = "SELECT e FROM Employee e WHERE e.id=(SELECT max(emp.id) FROM Employee emp)"),
        @NamedQuery(name = "getEmployeeDTO", query = "SELECT NEW com.innominds.dto.Employee(e.id,e.name,e.salary,e.joinDate) FROM Employee e") })
public class EmployeeEntity {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

    @Column(precision = 10, scale = 2)
    private Double salary;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Employee [");
        if (id != null) {
            builder.append("id=");
            builder.append(id);
            builder.append(", ");
        }
        if (name != null) {
            builder.append("name=");
            builder.append(name);
            builder.append(", ");
        }
        if (salary != null) {
            builder.append("salary=");
            builder.append(salary);
            builder.append(", ");
        }
        if (joinDate != null) {
            builder.append("joinDate=");
            builder.append(joinDate);
        }
        builder.append("]");
        return builder.toString();
    }

}
