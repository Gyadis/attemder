package sk.upjs.paz;

import java.util.List;

public class UserService {

    private final List<User> database;

    public UserService(List<User> database) {
        this.database = database;
    }

    public GenderRatio computeGenderRatio() {
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

}
