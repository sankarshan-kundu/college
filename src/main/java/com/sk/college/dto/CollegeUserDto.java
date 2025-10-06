package com.sk.college.dto;

import com.sk.college.model.CollegeRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
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
