package com.innominds.dto;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5439802495858865506L;

    public Employee() {
    }

    public Employee(Long id, String name, Double salary, Date joinDate) {

        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    private Long id;

    private String name;

    private Double salary;

    private Date joinDate;

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
