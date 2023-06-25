package com.example.loginproject;

import entity.UsersEntity;
import jakarta.persistence.*;

import java.util.List;

/**
 * @version 25/06/2023
 * @author Ariel Dobkin
 */
public class Check {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
    public void tryLogin(String user_name,String password){
        Query insert_try_login=entityManager.createQuery("");
    }

    /**
     * @param user_name The username provided as input in the login form
     * @param password The password provided as input in the login form
     * @param user An instance that represents an entity of the user class,
     *            if it exists in the database the properties will be inserted into it
     * @return true if the user it exists in the database, otherwise false.
     */
    public boolean isValid(String user_name,String password,UsersEntity user){
        boolean flag=false;
        try {
            transaction.begin();
            Query selectDetails=entityManager.createQuery("SELECT e from UsersEntity e" +
                    " WHERE userName=:u and password=:p");
            selectDetails.setParameter("u",user_name);
            selectDetails.setParameter("p",password);
            List<UsersEntity> users=selectDetails.getResultList();
            if (users.size()==0){
                flag=false;
            }
            else{
                //Enter details to user instance.
                user=new UsersEntity();
                user.setUserName(users.get(0).getUserName());
                user.setPassword(users.get(0).getPassword());
                flag=true;
            }
            transaction.commit();
        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return flag;
    }
}
