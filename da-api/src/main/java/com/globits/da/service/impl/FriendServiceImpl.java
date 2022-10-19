package com.globits.da.service.impl;

import com.globits.da.domain.Friend;
import com.globits.da.domain.UserApp;
import com.globits.da.dto.FriendDto;
import com.globits.da.dto.Response;
import com.globits.da.repository.FriendRepository;
import com.globits.da.repository.UserAppRepository;
import com.globits.da.service.FriendService;
import com.globits.da.service.UserAppService;
import com.globits.security.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FriendServiceImpl implements FriendService {
    private final FriendRepository friendRepository;
    private final UserAppRepository userAppRepository;
    private final UserAppService userAppService;

    public FriendServiceImpl(FriendRepository friendRepository, UserAppRepository userAppRepository, UserAppService userAppService) {
        this.friendRepository = friendRepository;
        this.userAppRepository = userAppRepository;
        this.userAppService = userAppService;
    }


    @Override
    public List<FriendDto> findAll() {
        UserDto userCurrent = userAppService.getCurrentUser();
        if (userCurrent == null) return null;
        UserApp userAppCurrent = userAppRepository.getByUserId(userCurrent.getId());
        if (userAppCurrent == null) return null;
        List<FriendDto> list = friendRepository.getFriends(userAppCurrent.getId());
        return friendRepository.getFriends(userAppCurrent.getId());
    }

    @Override
    public FriendDto findById(UUID uuid) {
        return null;
    }

    @Override
    public Response<FriendDto> save(FriendDto friendDto) {
        return null;
    }

    @Override
    public Response<Boolean> addFriend(UUID uuid) {
        UserApp userApp = userAppRepository.getOne(uuid);
        if (userApp == null) return new Response<>("can not find friend");
        UserDto userCurrent = userAppService.getCurrentUser();
        if (userCurrent == null) return new Response<>("can not find user");
        UserApp userAppCurrent = userAppRepository.getByUserId(userCurrent.getId());
        if (userAppCurrent == null) return new Response<>("can not find user");
        Friend friend = new Friend();
        friend.setUserApp(userAppCurrent);
        friend.setUserAppFriend(userApp);
        friendRepository.save(friend);
        Friend friend1 = new Friend();
        friend1.setUserApp(userApp);
        friend1.setUserAppFriend(userAppCurrent);
        friendRepository.save(friend1);
        return new Response<>(true);
    }

    @Override
    public Response<FriendDto> update(FriendDto friendDto, UUID uuid) {
        return null;
    }
}
