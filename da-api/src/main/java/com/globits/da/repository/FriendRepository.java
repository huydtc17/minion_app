package com.globits.da.repository;

import com.globits.da.domain.Friend;
import com.globits.da.dto.FriendDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FriendRepository extends JpaRepository<Friend, UUID> {

    @Query("select new com.globits.da.dto.FriendDto(ed,true) from Friend ed where ed.userApp.id=?1")
    List<FriendDto> getFriends(UUID id);


}
