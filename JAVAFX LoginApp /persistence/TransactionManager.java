package org.academiadecodigo.myApp.persistence;

/**
 * Created by codecadet on 01/12/16.
 */
public interface TransactionManager {

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

}
