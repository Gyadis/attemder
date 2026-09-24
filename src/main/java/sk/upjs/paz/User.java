package sk.upjs.paz;

import java.time.LocalDate;

public record User (
    Long id,
    String name,
    String surname,
    Gender gender,
    LocalDate birthdate,
    Role role
) {
    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }
    public enum Role {
        UNKNOWN,
        GUEST,
        STUDENT,
        TEACHER,
        ATTENDANT
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String surname() {
        return surname;
    }

    @Override
    public Gender gender() {
        return gender;
    }

    @Override
    public LocalDate birthdate() {
        return birthdate;
    }

    @Override
    public Role role() {
        return role;
    }
}
