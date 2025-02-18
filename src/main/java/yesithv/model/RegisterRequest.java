package yesithv.model;

public record RegisterRequest(
        String email,
        String password,
        String name
) {
}
