package app.application.dto.member;

import app.domain.model.enums.Role;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateMemberDto {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank
    private LocalDateTime createdDate;

    @NotBlank
    private String createdMemberId;
}