package com.globits.da.service;

import com.globits.da.dto.ProvinceDto;
import com.globits.da.dto.Response;

import java.util.List;
import java.util.UUID;

public interface ProvinceService {

    List<ProvinceDto> findAll();

    ProvinceDto findById(UUID uuid);

    Response<ProvinceDto> save(ProvinceDto theProvince);

    Response<ProvinceDto> update(ProvinceDto theProvince, UUID uuid);

    void deleteById(UUID uuid);

}
