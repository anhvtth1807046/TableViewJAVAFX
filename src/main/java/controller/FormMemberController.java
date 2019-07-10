package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FormMemberController implements Initializable {
    public JFXTextField txtUsername;
    public JFXPasswordField pwdPassword;
    public JFXPasswordField txtFullName;
    public JFXTextField txtAvatar;
    public JFXTextField txtAvatar1;
    public JFXButton btnAdd;
    public JFXButton btnBack;


    public void initialize(URL location, ResourceBundle resources) {

    }


    public void addMember(MouseEvent mouseEvent) {

    }

    public void backTableView(MouseEvent event) {
        Parent tableViewParent = null;
        try {
            tableViewParent = FXMLLoader.load(getClass().getResource("/TableViewMember.fxml"));
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
