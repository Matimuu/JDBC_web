package com.admin.JDBC_try.dao;

import com.admin.JDBC_try.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 13:50
 */

/**
 * DB operator.
 */
public class DAOimpl implements DAO {
    //Constants
    public static final String PERSON_ID = "person_id";
    public static final String PERSON_NAME = "person_name";
    public static final String PERSON_SURNAME = "person_surname";
    public static final String PERSON_DATE_OF_BIRTH = "person_dateOfBirth";
    private JdbcTemplate jdbcTemplate;

    //Constructor
    public DAOimpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //Methods
    @Override
    public int save(Person p) {
        String sqlInsert = "INSERT INTO persons (person_name, person_surname, person_dateOfBirth) VALUES(?,?,?)";

        return jdbcTemplate.update(sqlInsert, p.getName(), p.getSurname(), p.getDateOfBirth());
    }

    @Override
    public int update(Person p) {
        String sqlUpdate = "UPDATE persons SET person_name=?, person_surname=?, person_dateOfBirth=? WHERE person_id=?";

        return jdbcTemplate.update(sqlUpdate, p.getName(), p.getSurname(), p.getDateOfBirth(), p.getId());
    }

    @Override
    public Person get(int id) {
        String sqlGet = "SELECT * FROM persons WHERE person_id = " + id;
        ResultSetExtractor<Person> extractor = rs -> {
            if (rs.next()) {
                String name = rs.getString(PERSON_NAME);
                String surname = rs.getString(PERSON_SURNAME);
                LocalDate dob = rs.getDate(PERSON_DATE_OF_BIRTH).toLocalDate();

                return new Person(id, name, surname, dob);
            }
            return null;
        };

        return jdbcTemplate.query(sqlGet, extractor);
    }

    @Override
    public int delete(int id) {
        String sqlDelete = "DELETE FROM persons WHERE person_id =" + id;

        return jdbcTemplate.update(sqlDelete);
    }

    @Override
    public List<Person> list() {
        String sqlList = "SELECT * FROM persons";
        RowMapper<Person> rowMapper = (rm, row) -> {
            int id = rm.getInt(PERSON_ID);
            String name = rm.getString(PERSON_NAME);
            String surname = rm.getString(PERSON_SURNAME);
            LocalDate dob = rm.getDate(PERSON_DATE_OF_BIRTH).toLocalDate();

            return new Person(id,name,surname,dob);
        };

        return jdbcTemplate.query(sqlList,rowMapper);
    }
}
