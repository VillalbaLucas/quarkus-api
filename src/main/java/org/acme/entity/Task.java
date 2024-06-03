package org.acme.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name ="tasks")
public class Task extends BaseEntity {

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "emplyee_id")
    @JsonIgnore
    private Employee employee;
}
