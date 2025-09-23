package school.sorokin.javacore;

import java.util.Arrays;
import java.util.Optional;

public enum Group {
    FAMILY("1"),
    WORK("2"),
    FRIENDS("3");

    private String id;

    Group(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Optional<Group> getGroupFromId(String id) {
        return Arrays.stream(values())
                .filter(g -> g.getId().equals(id))
                .findFirst();
    }
}
