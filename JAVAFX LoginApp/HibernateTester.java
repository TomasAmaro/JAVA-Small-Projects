package org.academiadecodigo.myApp;

import org.academiadecodigo.myApp.model.User;
import org.academiadecodigo.myApp.service.user.UserService;
import org.academiadecodigo.myApp.service.user.UserServiceHibernate;

import java.sql.SQLException;

/**
 * Created by codecadet on 01/12/16.
 */
public class HibernateTester {
    public static void main(String[] args) throws SQLException {
        UserService service = new UserServiceHibernate();


        User userino = new User("Tomas","tomas.amaro@destinatio.com.br","teste");
        service.addUser(userino);

        System.out.println(service.count());
        System.out.println(service.findByName("tomas.amaro@destinatio.com.br"));

    }
}
