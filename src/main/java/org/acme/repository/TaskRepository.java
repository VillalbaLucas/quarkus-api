package org.acme.repository;

import java.util.UUID;

import org.acme.entity.Task;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskRepository implements PanacheRepositoryBase<Task, UUID> {
    
}
