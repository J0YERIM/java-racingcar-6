package racingcar.exception;

public class InvalidAttemptCountException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "시도할 회수는 양의 정수여야 합니다.";

    public InvalidAttemptCountException() {
        super(DEFAULT_MESSAGE);
    }

    public InvalidAttemptCountException(String message) {
        super(message);
    }

    public static int parseAttemptCount(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new InvalidAttemptCountException("");
        }
    }

    public static void validate(int attemptCount) {
        if (attemptCount <= 0) {
            throw new InvalidAttemptCountException(DEFAULT_MESSAGE);
        }
    }
}
