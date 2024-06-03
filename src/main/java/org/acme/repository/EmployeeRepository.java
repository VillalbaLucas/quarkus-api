package org.acme.repository;

import java.util.UUID;

import org.acme.entity.Employee;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepositoryBase<Employee, UUID> {
    
}
