package com.globits.da.service;

import com.globits.da.dto.Response;
import com.globits.da.dto.WardDto;

import java.util.List;
import java.util.UUID;

public interface WardService {
    List<WardDto> findAll();

    WardDto findById(UUID uuid);

    Response<WardDto> save(WardDto theWard);

    Response<WardDto> update(WardDto theWard, UUID uuid);

    void deleteById(UUID uuid);

    List<WardDto> findAllWardByDistrictId(UUID uuid);
}
