package controller;

import entity.Member;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewMemberController implements Initializable {
    public TableView<Member> tableView;
    public TableColumn<Member, String> usernameColumn;
    public TableColumn<Member, ImageView> avatarColumn;
    public TableColumn<Member, Integer> remainTimeColumn;

    public void initialize(URL location, ResourceBundle resources) {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("Tai khoan"));
        avatarColumn.setCellValueFactory(new PropertyValueFactory<Member, ImageView>("Anh dai dien"));
        remainTimeColumn.setCellValueFactory(new PropertyValueFactory<Member, Integer>("Thoi gian con lai"));

        tableView.setItems(getMember());

        tableView.setEditable(true);

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    private ObservableList<Member> getMember() {
        Member m = new Member();
        return m.findAll();
    }

    public void changeScreenButtonPushed(ActionEvent actionEvent) {
    }

    public void newAccount(ActionEvent event) {
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("/NetCafeView.fxml.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
