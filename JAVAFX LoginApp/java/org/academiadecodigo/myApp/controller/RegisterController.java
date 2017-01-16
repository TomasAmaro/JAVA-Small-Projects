package org.academiadecodigo.myApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import org.academiadecodigo.myApp.model.User;
import org.academiadecodigo.myApp.service.ServiceRegistry;
import org.academiadecodigo.myApp.service.user.UserService;
import org.academiadecodigo.myApp.view.Navigation;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //userService = (UserService) ServiceRegistry.getInstance().getService("UserService");
    }


    private UserService userService;
    private Navigation navigation;


    @FXML
    private AnchorPane anchorPaneBackground;

    @FXML
    private GridPane contentGrid;

    @FXML
    private Rectangle boxBackground;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Rectangle facebook;

    @FXML
    private Rectangle mail;

    @FXML
    private Rectangle twitter;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label nameLabel;

    @FXML
    void openfacebook(MouseEvent event) {

        try {
            Desktop.getDesktop().browse(new URI("https://www.facebook.com/academiadecodigo/"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    void opentwitter(MouseEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://twitter.com/academia_codigo"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    void registerButtonPressed(ActionEvent event) throws SQLException {
        System.out.println(userService);
        userService.addUser(new User(nameTextField.getText(), userNameTextField.getText(), passwordField.getText()));
        System.out.println("Tou aqui register mode");

        navigation.getInstance().loadScreen("login");

    }

    @FXML
    void sendemail(MouseEvent event) throws URISyntaxException, IOException {

        Desktop.getDesktop().browse(new URI("mailto:tomascorreiamaro@gmail.com?Subject=Problem%20with%20User%20on%20myApp"));

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }
}
