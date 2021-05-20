package ru.kozlovva.messenger.adapter.in.web.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
public interface UserResource {

    @PostMapping("/sign-in")
    CompletableFuture<ResponseEntity<TokenPairDTO>> signIn(@RequestBody SingInRequest request);

    @PostMapping("/sign-up")
    CompletableFuture<ResponseEntity<?>> signUp(@RequestBody SignUpRequest request);

    @GetMapping("/users/{id}")
    CompletableFuture<ResponseEntity<User>> findById(@PathVariable String id);

}
