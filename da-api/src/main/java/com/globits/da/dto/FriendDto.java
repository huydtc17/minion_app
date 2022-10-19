package com.globits.da.dto;

import com.globits.core.dto.BaseObjectDto;
import com.globits.da.domain.Friend;

public class FriendDto extends BaseObjectDto {
    private UserAppDto userApp;
    private UserAppDto userAppFriend;
    private Boolean isAccept;

    public FriendDto(){}
    public FriendDto(Friend entity,boolean cage){
        this.id=entity.getId();
        this.isAccept=entity.getAccept();
        if (entity.getUserApp()!=null){
            this.userApp=new UserAppDto(entity.getUserApp(),cage);
        }
        if (entity.getUserAppFriend()!=null){
            this.userAppFriend=new UserAppDto(entity.getUserAppFriend(),cage);
        }
    }

    public UserAppDto getUserApp() {
        return userApp;
    }

    public void setUserApp(UserAppDto userApp) {
        this.userApp = userApp;
    }

    public UserAppDto getUserAppFriend() {
        return userAppFriend;
    }

    public void setUserAppFriend(UserAppDto userAppFriend) {
        this.userAppFriend = userAppFriend;
    }

    public Boolean getAccept() {
        return isAccept;
    }

    public void setAccept(Boolean accept) {
        isAccept = accept;
    }
}
