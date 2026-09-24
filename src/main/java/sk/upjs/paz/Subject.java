package sk.upjs.paz;

import java.util.List;
import java.util.Set;

public record Subject (
        Long id,
        String name,
        int year,
        List<User> students
) {

}


