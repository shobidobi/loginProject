package com.example.loginproject;

import entity.PasswordsEntity;
import entity.TryLoginEntity;
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

    /**
     * @param user_name The username provided as input in the login form.
     * @param password The password provided as input in the login form.
     * The function inserts a record into the table TryLogin.
     */
    public void tryLogin(String user_name,String password){
        TryLoginEntity tryLogin=new TryLoginEntity(user_name,password);
        entityManager.persist(tryLogin);
    }

    /**
     * @param user_name The username provided as input in the login form.
     * @param password The password provided as input in the login form.
     * @return true if the user it exists in the database, otherwise false.
     */
    public boolean isValid(String user_name, String password){
        boolean flag=false;
        try {
            transaction.begin();
            //check user table
            Query selectDetails_user=entityManager.createQuery("select id from UsersEntity " +
                    "where userName=:u");
            selectDetails_user.setParameter("u",user_name);
            List<Integer> users=selectDetails_user.getResultList();
            if (users.size()==0){
                System.out.println("The user does not exist in the system");
                return false;
            }
            //check password table
            int user_id=users.get(0);
            Query selectDetails_password=entityManager.createQuery("select password from PasswordsEntity" +
                    " where password=:p and userId=:ui");
            selectDetails_password.setParameter("ui",user_id);
            selectDetails_password.setParameter("p",password);
            List<String> passwords=selectDetails_password.getResultList();
            if (passwords.size()==0){
                flag=false;
                System.out.println("the password are not valid");
            }
            else{
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

    /**
     * @param user_name The username provided as input in the login form.
     * @param password The password provided as input in the login form.
     * @return true if the conditions of the registration were passed successfully and false otherwise
     */
    public boolean newUser(String user_name,String password){
        if (checkUser(user_name, password)&&!(isUser(user_name))){
            try {
                transaction.begin();
                UsersEntity n_usersEntity = new UsersEntity(user_name);
                entityManager.persist(n_usersEntity);
                transaction.commit();
                transaction.begin();
                PasswordsEntity passwords = new PasswordsEntity(password, n_usersEntity.getId());
                entityManager.persist(passwords);
                transaction.commit();

            } finally {
                if (transaction.isActive()){
                    transaction.rollback();
                }
                entityManager.close();
                entityManagerFactory.close();
            }

            System.out.println("The user has successfully registered");
            return true;
        }
        return false;
    }

    /**
     * @param user_name User for search.
     * @return True if the user is in the system. otherwise false.
     */
    private boolean isUser(String user_name){
        Query selectId=entityManager.createQuery("select id from UsersEntity where userName=:u");
        selectId.setParameter("u",user_name);
        List<Integer> id=selectId.getResultList();
        if (id.size()>1){
            System.out.println("The user exists in the system");
            return true;
        }
        return false;
    }

    /**
     * @param user_name Username of new user to test
     * @param password Password of new user to test
     * @return true if the conditions of the registration were passed successfully and false otherwise
     */
    private boolean checkUser(String user_name, String password){
        /*check user_name */
        if (user_name.length()<6||user_name.length()>12){
            System.out.println("the user name are not good");
            return false;
        }
        for (int i = 0; i < user_name.length(); i++) {
            if (!((user_name.charAt(i)>=32)&&
                    (user_name.charAt(i)<=127))){
                System.out.println("The user name contains invalid characters");
                return false;
            }

        }
        /*check password*/
        if (password.length()<6||password.length()>12){
            System.out.println("the password are not good");
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            if (!(password.charAt(i)>=32&&
                    password.charAt(i)<=127)){
                System.out.println("Password contains invalid characters");
                return false;
            }
        }

        return true;
    }

}
