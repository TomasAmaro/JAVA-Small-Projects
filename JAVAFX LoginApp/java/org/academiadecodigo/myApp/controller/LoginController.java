package org.academiadecodigo.myApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.academiadecodigo.myApp.service.ServiceRegistry;
import org.academiadecodigo.myApp.service.user.UserService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import org.academiadecodigo.myApp.view.Navigation;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private UserService userService;
    private Navigation navigation;


    @FXML
    private AnchorPane anchorPaneBackground;

    @FXML
    private GridPane contentGrid;

    @FXML
    private Rectangle boxBackground;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Rectangle facebook;

    @FXML
    private Rectangle google;

    @FXML
    private Rectangle twitter;

    @FXML
    private Label signInLabel;

    @FXML
    private Label register;

    @FXML
    void buttonPressed(ActionEvent event) throws IOException {

        System.out.println("Tou aqui bro");

        //TODO finalize the register mode
        System.out.println(userNameTextField.getText() + " : " + passwordField.getText());
        if (!userService.authenticate(userNameTextField.getText(), passwordField.getText())) {
            userNameTextField.setText("TRY AGAIN");
            passwordField.setText("");
        }
        System.out.println("Autentication: " + userService.authenticate(userNameTextField.getText(), passwordField.getText()));
        System.out.println("Tou aqui myApp mode");


    }

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
    void registeruser(MouseEvent event) {

        navigation.getInstance().loadScreen("register");

    }

    @FXML
    void sendemail(MouseEvent event) throws URISyntaxException, IOException {



            Desktop.getDesktop().browse(new URI("mailto:tomascorreiamaro@gmail.com?Subject=Problem%20with%20User%20on%20myApp"));


        // getHostServices().showDocument("mailto:"+textField.getText());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I'm comming first");
       // userService = (UserService) ServiceRegistry.getInstance().getService("UserService");
    }

    public void onLogin() {


    }

    public void onRegister() {


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

