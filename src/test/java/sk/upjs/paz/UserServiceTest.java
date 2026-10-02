package sk.upjs.paz;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        new User(1L,
                "Anca",
                "Sranda",
                User.Gender.FEMALE,
                LocalDate.of(2000, 4, 13),
                User.Role.STUDENT
                );
        new User(2L,
                "Serhii",
                "Avtomobilevich",
                User.Gender.MALE,
                LocalDate.of(2002, 5, 20),
                User.Role.STUDENT
        );
        new User(3L,
                "Koniuch",
                "Loshped",
                User.Gender.MALE,
                LocalDate.of(1984, 2, 3),
                User.Role.TEACHER
        );
    }

    @org.junit.jupiter.api.Test
    void computeGenderRatio() {
        var userservice = new UserService(Collections.emptyList());
        var got = userservice.computeGenderRatio();
        assertEquals(0.0, got.unknown());
        assertEquals(0.0, got.girls());
        assertEquals(0.0, got.boys());
    }
}