package com.globits.da.rest;


import com.globits.da.dto.ProvinceDto;
import com.globits.da.dto.Response;
import com.globits.da.dto.UserAppDto;
import com.globits.da.service.UserAppService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class RestUserAppController {
    final private UserAppService userAppService;

    public RestUserAppController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }


    @GetMapping("")
    public List<UserAppDto> findAll() {
        return userAppService.findAll();
    }
    @PostMapping("")
    public Response<UserAppDto> create(@RequestBody UserAppDto dto) {
        return userAppService.save(dto);
    }
    @PutMapping("/{id}")
    public Response<UserAppDto> update(@RequestBody UserAppDto dto,@PathVariable(name = "id")UUID id) {
        return userAppService.update(dto,id);
    }
}
