package com.globits.da.domain;

import com.globits.core.domain.BaseObject;
import com.globits.security.domain.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_user_app")
public class UserApp extends BaseObject {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userApp")
    private Set<Friend> listFriends;

    public Set<Friend> getListFriends() {
        return listFriends;
    }

    public void setListFriends(Set<Friend> listFriends) {
        this.listFriends = listFriends;
    }
}
