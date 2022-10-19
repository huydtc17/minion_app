package com.globits.da.service.impl;

import com.globits.da.domain.UserApp;
import com.globits.da.dto.Response;
import com.globits.da.dto.UserAppDto;
import com.globits.da.repository.UserAppRepository;
import com.globits.da.service.UserAppService;
import com.globits.security.domain.User;
import com.globits.security.dto.UserDto;
import com.globits.security.repository.UserRepository;
import com.globits.security.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserAppServiceImpl implements UserAppService {
    private final UserAppRepository userAppRepository;
    private final UserRepository userRepository;

    private final UserService userService;

    public UserAppServiceImpl(UserAppRepository userAppRepository, UserRepository userRepository, UserService userService) {
        this.userAppRepository = userAppRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @Override
    public List<UserAppDto> findAll() {
        return userAppRepository.getAllUserApp();
    }

    @Override
    public UserAppDto findById(UUID uuid) {
        return null;
    }

    @Override
    public Response<UserAppDto> save(UserAppDto userAppDto) {
        UserApp userApp=new UserApp();
        if (userAppDto.getUser()==null) return new Response<>("User not null");
        User user=userService.saveUser(userAppDto.getUser());
        if (user==null) return new Response<>("save user fail!");
        userApp.setUser(user);
        userApp=userAppRepository.save(userApp);
        return new Response<UserAppDto>(new UserAppDto(userApp,true));
    }

    @Override
    public Response<UserAppDto> update(UserAppDto userAppDto, UUID uuid) {
        UserApp userApp;
        userApp=userAppRepository.getOne(uuid);
        if (userApp==null)
            return new Response<>("Can not find user by id");
        if (userAppDto.getUser()==null) return new Response<>("User not null");
        User user=userService.saveUser(userAppDto.getUser());
        if (user==null) return new Response<>("save user fail!");
        userApp.setUser(user);
        userApp=userAppRepository.save(userApp);
        return new Response<UserAppDto>(new UserAppDto(userApp,true));
    }
    @Override
    @Transactional(readOnly = true)
    public UserDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName;
        User user = null;
        if (authentication != null && authentication.getPrincipal() != null) {
            if (authentication.getPrincipal() instanceof String) {
                userName = (String) authentication.getPrincipal();
                user = userRepository.findByUsername(userName);
            } else {
                user = (User) authentication.getPrincipal();
                if (user != null) {
                    userName = user.getUsername();
                    user = userRepository.findByUsername(userName);
                }
            }
        }
        if (user != null && user.getUsername() != null) {
            User entity = userRepository.findByUsernameAndPerson(user.getUsername());

            if (entity != null)
                return new UserDto(entity);
        }

        return null;
    }

}
