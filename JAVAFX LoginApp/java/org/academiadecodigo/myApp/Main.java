package org.academiadecodigo.myApp;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.academiadecodigo.myApp.service.ServiceRegistry;
import org.academiadecodigo.myApp.service.user.UserService;
import org.academiadecodigo.myApp.view.Navigation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main extends Application {



    public static void main(String[] args) {
        launch(args);
    }
    //ConnectionManager connectionManager = new ConnectionManager("jdbc:mysql://localhost:3306/myApp_db?useSSL=false","root","","");

    ServiceRegistry serviceRegistry = ServiceRegistry.getInstance();
    private UserService userService;



    @Override
    public void init() throws Exception {
        /* super.init();
       userService = new UserServiceImpl(new HibernateUserDao(),new HibernateTransactionManager(new HibernateSessionManager()));
        serviceRegistry.addService("UserService",new UserServiceHibernate());*/

    }

    @Override
    public void start(Stage primaryStage) {

       StackPane root = new StackPane();
        primaryStage.getIcons().add(new Image("background.jpg"));
        primaryStage.setTitle("myApp");
/*        primaryStage.setScene(new Scene(root,640,480));
        primaryStage.show();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("Spring/spring-config.xml");
        Navigation navigation = context.getBean("navigation", Navigation.class);
        System.out.println("I'm comming in second");
        System.out.println(navigation.getControllers().get("LoginController"));

       // UserService userService = (UserService) serviceRegistry.getService("UserService");
        navigation.getInstance().setStage(primaryStage);
        navigation.getInstance().loadScreen("login");

    }

    @Override
    public void stop() throws Exception {
        //session.close();
        super.stop();
    }
}