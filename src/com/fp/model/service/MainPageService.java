package com.fp.model.service;

import com.fp.model.repository.MainPageRepository;

import java.sql.SQLException;

public class MainPageService {
    //singleton class
    private static final MainPageService mainPageService= new MainPageService();
    public static MainPageService getInstance(){return mainPageService;}
    private MainPageService(){}

    public String getRole() throws SQLException {
        MainPageRepository repository = new MainPageRepository();
        return repository.getRole();
    }
    public String getUserName() throws SQLException {
        MainPageRepository repository = new MainPageRepository();
        return repository.getUserName();
    }


    public void sendComment(int user_id, String string) throws SQLException {
        MainPageRepository repository = new MainPageRepository();
        repository.sendCommentRepo(user_id, string);
    }
}
