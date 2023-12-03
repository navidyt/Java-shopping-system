package com.fp.comment;

import javafx.scene.Group;
import javafx.scene.Scene;

import java.sql.SQLException;

public class CommentPage {
    //singleton class
    private static final CommentPage commentPage = new CommentPage();
    public static CommentPage getInstance(){return commentPage;}
    private CommentPage(){}

        public Scene getCommentPage() throws SQLException {
            CommentPageView commentPageView = new CommentPageView();
            Group root = commentPageView.getRoot();
            return new Scene(root);
        }

}
