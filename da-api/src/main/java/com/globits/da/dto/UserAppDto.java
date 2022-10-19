package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.Friend;
import com.globits.da.domain.UserApp;
import com.globits.security.dto.UserDto;
import org.springframework.util.ObjectUtils;

import java.util.HashSet;
import java.util.Set;

public class UserAppDto extends BaseObjectDto {
    private UserDto user;
    private Set<FriendDto> friends;

    public UserAppDto() {
    }

    public UserAppDto(UserApp entity, boolean cage) {
        this.id=entity.getId();
        if (entity.getUser() != null)
            this.user = new UserDto(entity.getUser());
        if (cage && !ObjectUtils.isEmpty(entity.getListFriends())) {
            friends = new HashSet<>();
            for (Friend item : entity.getListFriends()) {
                friends.add(new FriendDto(item, false));
            }
        }
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Set<FriendDto> getFriends() {
        return friends;
    }

    public void setFriends(Set<FriendDto> friends) {
        this.friends = friends;
    }
}
