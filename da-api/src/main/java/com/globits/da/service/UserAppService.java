package com.globits.da.service;

import com.globits.da.dto.DistrictDto;
import com.globits.da.dto.Response;
import com.globits.da.dto.UserAppDto;
import com.globits.security.domain.User;
import com.globits.security.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserAppService {
    List<UserAppDto> findAll();

    UserAppDto findById(UUID uuid);

    Response<UserAppDto> save(UserAppDto userAppDto);

    Response<UserAppDto> update(UserAppDto userAppDto, UUID uuid);
    UserDto getCurrentUser();

}
