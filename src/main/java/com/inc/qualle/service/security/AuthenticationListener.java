package com.inc.qualle.service.security;

import com.inc.qualle.model.entity.Session;
import com.inc.qualle.model.entity.User;
import com.inc.qualle.repository.SessionRepository;
import com.inc.qualle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthenticationListener {

    private final SessionRepository repository;
    private final UserRepository userRepository;

    @EventListener
    public void onAuthenticationSuccessEvent(AuthenticationSuccessEvent event) {
        send(SessionUtil.getUserLogin(event.getAuthentication()), true);
    }

    @EventListener
    public void onAuthenticationSuccessEvent(AbstractAuthenticationFailureEvent event) {
        send(SessionUtil.getUserLogin(event.getAuthentication()), false);
    }

    private void send(String login, boolean success) {
        Optional<User> optionalUser = userRepository.findWithCredentialsByLogin(login);

        if(optionalUser.isEmpty()) {
            return;

        }
        User user = optionalUser.get();

        Session session = Session.builder()
                .createdAt(LocalDateTime.now())
                .success(success)
                .user(user)
                .build();

        if (user.getSessions() == null) {
            user.setSessions(new HashSet<>());
        }

        user.getSessions().add(session);

        log.info("User {} tried to authenticate, result is {} ", login, success ? "success" : "fail");
        repository.save(session);
    }
}