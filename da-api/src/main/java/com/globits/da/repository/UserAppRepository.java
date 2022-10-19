package com.globits.da.repository;

import com.globits.da.domain.UserApp;
import com.globits.da.dto.UserAppDto;
import com.globits.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, UUID>{

	@Query("select new com.globits.da.dto.UserAppDto(ed,true) from UserApp ed")
	List<UserAppDto> getAllUserApp();
	@Query("select ed from UserApp ed where ed.user.id=?1")
	UserApp getByUserId(Long id);


}
