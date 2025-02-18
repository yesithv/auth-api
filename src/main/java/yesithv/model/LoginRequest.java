package yesithv.model;

public record LoginRequest(
        String email,
        String password
) {
}
