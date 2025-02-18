package yesithv.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import yesithv.model.LoginRequest;
import yesithv.model.RegisterRequest;
import yesithv.model.Token;
import yesithv.model.TokenResponse;
import yesithv.model.User;
import yesithv.repository.TokenRepository;
import yesithv.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;

    public TokenResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.name())
                .email(request.email())
                // .password(request.password()) Se deberá encriptar
                .password(passwordEncoder.encode(request.password()))
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(user, jwtToken);
        return new TokenResponse(jwtToken, refreshToken);
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(Token.TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    public TokenResponse login(LoginRequest request) {
        return null;
    }

    public TokenResponse refreshToken(String authHeader) {
        return null;
    }

}
