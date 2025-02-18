package yesithv.controller;

public record LoginRequest(
        String email,
        String password
) {
}
