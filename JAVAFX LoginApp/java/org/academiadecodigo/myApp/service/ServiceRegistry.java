package org.academiadecodigo.myApp.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codecadet on 28/11/16.
 */
public class ServiceRegistry {

    private Map<String,Service> services = new HashMap<>();

    private static ServiceRegistry ourInstance = new ServiceRegistry();

    public static ServiceRegistry getInstance() {
        return ourInstance;
    }

    private ServiceRegistry() {
    }

    public void addService(String serviceName, Service service){
        services.put(serviceName,service);
        System.out.println("Service Size is: " + services.size());
    }

    public Service getService(String serviceName){

        return services.get(serviceName);
    }
}
