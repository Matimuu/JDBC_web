package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.User;

import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/06/02 00:28
 */
public interface DAO_User {
    int addUser(User u);

    int updateUser(User u);

    int deleteUser(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}