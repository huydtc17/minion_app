package com.globits.da.rest;


import com.globits.da.dto.FriendDto;
import com.globits.da.dto.ProvinceDto;
import com.globits.da.dto.Response;
import com.globits.da.service.FriendService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/friend")
public class RestFriendController {
    private final FriendService friendService;

    public RestFriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("")
    public List<FriendDto> findAll() {
        return friendService.findAll();
    }

    @GetMapping("/add_friend")
    public Response<Boolean> addFriend(@RequestParam(name = "id")UUID id) {
        return friendService.addFriend(id);
    }
}
