package com.admin.dao;

import com.admin.model.Person;
import com.admin.model.User;

import java.util.List;


/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 13:46
 */
public interface DAO {
    public int save(Person p);

    public int save(User u);

    public int update(Person p);

    int update(User u);

    public User get(int id);
    public int delete(int id);
    public List<User> list();
}
