package com.objectify.erp.api.dto;

import com.objectify.erp.domain.model.Project;
import org.immutables.value.Value;

@Value.Immutable
public abstract class ProjectDto {

    public abstract String getName();

    public static ProjectDto from(Project project) {
        return ImmutableProjectDto
                .builder()
                .name(project.getName())
                .build();
    }
}
