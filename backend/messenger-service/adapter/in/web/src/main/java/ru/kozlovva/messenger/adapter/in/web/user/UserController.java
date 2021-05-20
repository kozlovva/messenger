package ru.kozlovva.messenger.adapter.in.web.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.kozlovva.messenger.core.common.UseCaseExecutor;
import ru.kozlovva.messenger.core.domain.user.usecase.findById.FindUserById;
import ru.kozlovva.messenger.core.domain.user.usecase.signIn.SignIn;
import ru.kozlovva.messenger.core.domain.user.usecase.signUp.SignUp;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Component
public class UserController implements UserResource {

    private final UseCaseExecutor useCaseExecutor;
    private final SignUp signUpUseCase;
    private final SignIn singInUseCase;
    private final FindUserById findUserById;

    @Override
    public CompletableFuture<ResponseEntity<?>> signUp(SignUpRequest request) {
        return useCaseExecutor.execute(
                signUpUseCase,
                request.toCommand(),
                o -> ResponseEntity.ok()
                        .body(null)
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<User>> findById(String id) {
        return useCaseExecutor.execute(
                findUserById,
                id,
                o -> ResponseEntity.ok(User.from(o))
        );
    }

    @Override
    public CompletableFuture<ResponseEntity<TokenPairDTO>> signIn(SingInRequest request) {
        return useCaseExecutor.execute(
                singInUseCase,
                request.toCommand(),
                o -> ResponseEntity.ok(TokenPairDTO.from(o))
        );
    }
}
