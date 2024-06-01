package com.admin.dao;

import com.admin.model.Person;
import com.admin.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 13:50
 */
public class DAOimplSec implements DAO {
    public static final String USER_ID = "user_id";
    public static final String USER_USERNAME = "username";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String USER_CREATED_AT = "created_at";
    public static final String USER_TOTAL_ORDERS = "total_orders";
    private JdbcTemplate jdbcTemplate;

    public DAOimplSec(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public int save(User u) {
        String sqlInsert = "INSERT INTO User (username, email, password) VALUES(?,?,?)";

        return jdbcTemplate.update(sqlInsert, u.getUsername(), u.getEmail(), u.getPassword());
    }



    @Override
    public int update(User u) {
        String sqlUpdate = "UPDATE User SET username=?, email=?, password=? WHERE user_id=?";

        return jdbcTemplate.update(sqlUpdate, u.getUsername(), u.getEmail(), u.getPassword(), u.getUser_id());
    }

    @Override
    public User get(int id) {
        String sqlGet = "SELECT * FROM User WHERE user_id = " + id;
        ResultSetExtractor<User> extractor = rs -> {
            if (rs.next()) {
                String username = rs.getString(USER_USERNAME);
                String email = rs.getString(USER_EMAIL);
                String password = rs.getString(USER_PASSWORD);
                Timestamp created_at = rs.getTimestamp(USER_CREATED_AT);
                Integer total_orders = rs.getInt(USER_TOTAL_ORDERS);

                return new User(id, username, email, password, created_at, total_orders);
            }
            return null;
        };

        return jdbcTemplate.query(sqlGet, extractor);
    }

    @Override
    public int delete(int id) {
        String sqlDelete = "DELETE FROM User WHERE person_id =" + id;

        return jdbcTemplate.update(sqlDelete);
    }

    @Override
    public List<User> list() {
        String sqlList = "SELECT * FROM User";
        RowMapper<User> rowMapper = (rm, row) -> {
            int id = rm.getInt(USER_ID);
            String username = rm.getString(USER_USERNAME);
            String email = rm.getString(USER_EMAIL);
            String password = rm.getString(USER_PASSWORD);
            Timestamp created_at = rm.getTimestamp(USER_CREATED_AT);
            Integer total_orders = rm.getInt(USER_TOTAL_ORDERS);

            return new User(id,username,email,password,created_at,total_orders);
        };

        return jdbcTemplate.query(sqlList,rowMapper);
    }
    @Override
    public int save(Person p) {
        return 0;
    }
    @Override
    public int update(Person p) {
        return 0;
    }
}
