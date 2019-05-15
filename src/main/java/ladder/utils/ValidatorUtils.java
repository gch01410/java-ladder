package ladder.utils;

import java.util.List;

public class ValidatorUtils {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MIN_HEIGHT = 1;

    public static void checkNames(List<String> names) {
        checkBlank(names);

        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkBlank(List<String> names) {
        if (names.size() < 1) {
            System.err.println("이름을 제대로 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    private static void checkNameLength(String name) {
        if (name.trim().length() > MAX_NAME_LENGTH || name.trim().length() < MIN_NAME_LENGTH) {
            System.err.println("이름은 1~5자만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void checkHeight(int height) {
        if (height < MIN_HEIGHT) {
            System.err.println("높이는 자연수만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
}