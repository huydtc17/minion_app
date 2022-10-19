package com.globits.da.service;

import com.globits.da.dto.DistrictDto;
import com.globits.da.dto.FriendDto;
import com.globits.da.dto.Response;

import java.util.List;
import java.util.UUID;

public interface FriendService {
    List<FriendDto> findAll();

    FriendDto findById(UUID uuid);

    Response<FriendDto> save(FriendDto friendDto);
    Response<Boolean> addFriend(UUID uuid);


    Response<FriendDto> update(FriendDto friendDto, UUID uuid);


}
