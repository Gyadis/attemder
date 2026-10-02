package sk.upjs.paz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class UserService {

    private final List<User> database;

    public UserService(List<User> database) {
        this.database = database;
    }

    public GenderRatio computeGenderRatio() {
        if (this.database == null || this.database.size() == 0) {
            return new GenderRatio(0.0, 0.0, 0.0);
        }
        int b = 0;
        int g = 0;
        int u = 0;
        for (User user : database) {
            if (user.gender() == User.Gender.UNKNOWN) {
                u++;
            }
            else if ((user.gender() == User.Gender.FEMALE)) {
                g++;
            }
            else {
                b++;
            }
        }
        int sum = b+g+u;
        double mal = (b/sum);
        double fem = (g/sum);
        double unk = (u/sum);
        return new GenderRatio(mal, fem, unk);
    }

    public static List<User> loadFromCsv() throws IOException {
        final String path = "C:/Users/Tim/IdeaProjects/attender_cv/src/main/resources/sk/upjs/paz/testdata/users.csv";
        try (var stream = UserService.class.getResourceAsStream(path)) {
            var reader = new BufferedReader(new InputStreamReader(stream));
            var users = reader.lines().skip(1).map(line -> {
                var split = line.split(",", -1);
                return new User(Long.decode(split[0]),
                        //split[1],
                        split[2],
                        split[3],
                        User.Gender.valueOf(split[4]),
                        LocalDate.parse(split[5]),
                        User.Role.valueOf(split[6])
                );
            }
            );
            return users.toList();
        }
    }

}
