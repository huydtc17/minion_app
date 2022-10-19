package com.globits.da.domain;

import com.globits.core.domain.BaseObject;

import javax.persistence.*;

@Entity
@Table(name = "tbl_friend")
public class Friend extends BaseObject {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_app_id", referencedColumnName = "id")
    private UserApp userApp;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_app_friend_id", referencedColumnName = "id")
    private UserApp userAppFriend;
    private Boolean isAccept;

    public Boolean getAccept() {
        return isAccept;
    }

    public void setAccept(Boolean accept) {
        isAccept = accept;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }



    public void setUserAppFriend(UserApp userAppFriend) {
        this.userAppFriend = userAppFriend;
    }

    public UserApp getUserAppFriend() {
        return userAppFriend;
    }

}
