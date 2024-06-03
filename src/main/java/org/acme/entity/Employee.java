package org.acme.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    
    String name;
    Long dni;
    @OneToMany(mappedBy="employee", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @CreationTimestamp
    private LocalDateTime createDate;
    
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
