package com.frontbackend.springboot.users;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<String> findUsernames(String filter) {
        if (StringUtils.hasText(filter)) {
            return toUsernames(userRepository.findByUsernameStartsWith(filter));
        }
        return toUsernames(userRepository.findAll());
    }

    private List<String> toUsernames(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(UserEntity::getUsername)
                .collect(Collectors.toList());
    }

    @Transactional
    public void saveTopUsers(List<String> topUsernames) {
        userRepository.findAll()
                .forEach(user -> user.setTop(topUsernames.contains(user.getUsername())));
    }

    public List<String> getTopUsernames() {
        return userRepository.findAllByTopIsTrue()
                .stream()
                .map(UserEntity::getUsername)
                .collect(Collectors.toList());
    }
}
