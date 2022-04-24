package com.frontbackend.springboot.users;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class SaveTopUsersRequest {
    private List<String> usernames;
}
