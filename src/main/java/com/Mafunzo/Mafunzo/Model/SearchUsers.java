package com.Mafunzo.Mafunzo.Model;

import java.util.List;

public class SearchUsers {
    private List<User> searchUsers;

    public SearchUsers(List<User> users){
        searchUsers = users;
    }

    public List<User> getUserList() {
        return searchUsers;
    }

    public void setSearchUsers(List<User> searchUsers) {
        this.searchUsers = searchUsers;
    }
}
