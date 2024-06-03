package org.acme.dto;

import java.util.UUID;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public record EmployeeDto(UUID id, String name, Long dni) {
}
