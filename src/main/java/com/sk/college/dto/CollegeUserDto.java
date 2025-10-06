package com.sk.college.dto;

import com.sk.college.entity.CollegeRole;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CollegeUserDto {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Setter
    private Set<CollegeRole> roles;
    public Set<String> getRoles() {
        return roles.stream().map(CollegeRole::getRole).collect(Collectors.toSet());
    }

    @Setter
    private UUID externalId;
    public UUID getId()  {
        return externalId;
    }
    public void setId(UUID id) {
        this.externalId = id;
    }
}
