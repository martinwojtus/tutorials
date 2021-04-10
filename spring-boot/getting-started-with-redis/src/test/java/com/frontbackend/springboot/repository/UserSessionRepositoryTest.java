package com.frontbackend.springboot.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.frontbackend.springboot.model.UserSession;

@SpringBootTest
public class UserSessionRepositoryTest {

    @Autowired
    private UserSessionRepository userSessionRepository;

    @BeforeEach
    public void setUp() {
        userSessionRepository.deleteAll();
    }

    @Test
    public void shouldSaveUserSession() {
        UserSession userSession = new UserSession(UUID.randomUUID()
                                                      .toString(),
                "USERNAME", new Date(), "Chrome");

        UserSession saved = userSessionRepository.save(userSession);

        assertThat(saved).isNotNull();
        assertThat(userSessionRepository.count()).isEqualTo(1);
    }

    @Test
    public void shouldGetSavedUserSession() {
        String id = UUID.randomUUID()
                        .toString();
        Date loginTime = new Date();

        UserSession userSession = new UserSession(id, "USERNAME", loginTime, "Chrome");

        userSession.setLoginTime(loginTime);

        userSessionRepository.save(userSession);
        Optional<UserSession> userSessionOptional = userSessionRepository.findById(id);

        assertThat(userSessionOptional).isPresent();

        UserSession saved = userSessionOptional.get();

        assertThat(saved).isNotNull();
        assertThat(saved.getBrowser()).isEqualTo("Chrome");
        assertThat(saved.getUsername()).isEqualTo("USERNAME");
        assertThat(saved.getLoginTime()).isEqualTo(loginTime);
    }

    @Test
    public void shouldUpdateSavedUserSession() {
        String id = UUID.randomUUID()
                        .toString();
        UserSession userSession = new UserSession(id, "USERNAME", new Date(), "Chrome");

        UserSession saved = userSessionRepository.save(userSession);
        saved.setBrowser("IE");
        userSessionRepository.save(saved);

        Optional<UserSession> userSessionOptional = userSessionRepository.findById(id);

        assertThat(userSessionOptional).isPresent();

        UserSession updated = userSessionOptional.get();

        assertThat(updated).isNotNull();
        assertThat(updated.getBrowser()).isEqualTo("IE");
        assertThat(updated.getUsername()).isEqualTo("USERNAME");
    }

    @Test
    public void shouldDeleteUserSession() {
        String id = UUID.randomUUID()
                        .toString();
        UserSession userSession = new UserSession(id, "USERNAME", new Date(), "Chrome");

        userSessionRepository.save(userSession);
        userSessionRepository.deleteById(id);

        assertThat(userSessionRepository.count()).isEqualTo(0);
    }

    @Test
    public void shouldFindAllUserSessionObjects() {
        UserSession userSession1 = new UserSession(UUID.randomUUID()
                                                       .toString(),
                "USERNAME", new Date(), "Chrome");

        UserSession userSession2 = new UserSession(UUID.randomUUID()
                                                       .toString(),
                "USERNAME2", new Date(), "IE");

        userSessionRepository.save(userSession1);
        userSessionRepository.save(userSession2);

        Spliterator<UserSession> spliterator = userSessionRepository.findAll()
                                                                    .spliterator();

        List<UserSession> all = StreamSupport.stream(spliterator, false)
                                             .collect(Collectors.toList());

        assertThat(all.size()).isEqualTo(2);
        assertThat(all).extracting("username", "browser")
                       .containsOnly(tuple("USERNAME", "Chrome"), tuple("USERNAME2", "IE"));
    }
}
