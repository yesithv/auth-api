package yesithv.controller;

public record RegisterRequest(
        String email,
        String password,
        String name
) {
}
