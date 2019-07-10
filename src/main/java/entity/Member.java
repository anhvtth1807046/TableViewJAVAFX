package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String username;
    private String password;
    private String fullName;
    private String avatar;
    private long remainTime;
    private int stauts;

    public Member() {
    }

    public Member(String username, String password, String fullName, String avatar, long remainTime, int stauts) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.remainTime = remainTime;
        this.stauts = 1;
    }

    public boolean add(){
        try {
            String sql = "INSERT into `members` (`username`, `password`, `fullName`, `avatar`, `remainTime`, `status`)";
            ConnectionHelper.getConnection().prepareStatement(sql).execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ObservableList<Member> findAll(){
        ObservableList<Member> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from `members`";
            ResultSet resultSet = ConnectionHelper.getConnection().prepareStatement(sql).executeQuery();
            while (resultSet.next()){
                list.add(new Member(resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("fullName"),
                        resultSet.getString("avatar"),
                        resultSet.getLong("remainTime"),
                        resultSet.getInt("stauts")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(long remainTime) {
        this.remainTime = remainTime;
    }

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }
}
