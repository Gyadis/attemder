package sk.upjs.paz;//package sk.upjs.paz;

import sk.upjs.paz.Subject;
import sk.upjs.paz.User;

import java.time.*;
import java.util.List;

public record Attendance1(
        Long id,
        LocalDate date,
        Subject subject,
        List<User> attendees
) {
}

/*public static void main(String[] args) {
    System.out.println("LocalDate: " + LocalDate.now());

    System.out.println("LocalDateTime: " + LocalDateTime.now());

    System.out.println("Instant: " + Instant.now());
    System.out.println("ZonedDateTime: " + ZonedDateTime.now());
    System.out.println("OffsetDateTime: " + OffsetDateTime.now());

}*/