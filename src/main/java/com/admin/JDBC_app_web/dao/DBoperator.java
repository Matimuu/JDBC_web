package com.admin.JDBC_app_web.dao;

import com.admin.JDBC_app_web.bean.Person;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/07 21:10
 */
public class DBoperator {
    /*
    Class to make operations with DB.
     */

    //Variables.
    private Connection connection;

    private PreparedStatement preparedStatement;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private int check = 0;

    //Constructors.
    public DBoperator(DBconnector connection) {
        this.connection = connection.getConnection();
    }

    //Methods.
    public String addPerson(Person person) throws SQLException {
        String insert = "INSERT INTO persons (person_name, person_surname, person_dateOfBirth) VALUES(?,?,?)";

        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getSurname());
        preparedStatement.setDate(3, Date.valueOf(LocalDate.parse(person.getDateOfBirth().toString(), dateTimeFormatter)));

        check = preparedStatement.executeUpdate();
        preparedStatement.clearParameters();
        return check > 0 ? "The person was added." : "The person wasn't added";
    }public String addPerson(String name, String surname, String dateOfBirth) throws SQLException {
        String insert = "INSERT INTO persons (person_name, person_surname, person_dateOfBirth) VALUES(?,?,?)";

        preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        preparedStatement.setDate(3, Date.valueOf(LocalDate.parse(dateOfBirth, dateTimeFormatter)));

        check = preparedStatement.executeUpdate();
        preparedStatement.clearParameters();
        return check > 0 ? "The person was added." : "The person wasn't added";
    }

    public Collection<Person> showAll() throws SQLException {
        Collection<Person> personsList = new ArrayList<>();
        String showAll = "SELECT * FROM persons";

        preparedStatement = connection.prepareStatement(showAll);
        ResultSet resultSet = preparedStatement.executeQuery();

        showLoopPersons(resultSet, personsList);
        preparedStatement.clearParameters();
        return personsList;
    }

    public String showByID(int id) throws SQLException {
        Collection<Person> personsList = new ArrayList<>();
        String showByID = "SELECT * FROM persons WHERE person_id = ?";

        preparedStatement = connection.prepareStatement(showByID);
        preparedStatement.setInt(1, id);

        showLoopPersons(preparedStatement.executeQuery(), personsList);
        preparedStatement.clearParameters();
        return personsList.toString();
    }

    private void showLoopPersons(ResultSet resultSet, Collection<Person> dbList) throws SQLException {
        while (resultSet.next()) {
            Person person = new Person();

            person.setId(resultSet.getInt("person_id"));
            person.setName(resultSet.getString("person_name"));
            person.setSurname(resultSet.getString("person_surname"));
            person.setDateOfBirth(resultSet.getDate("person_dateOfBirth").toLocalDate());

            dbList.add(person);
        }
    }


    public String deleteAll() throws SQLException {
        String deleteSQL = "DELETE FROM persons";

        preparedStatement = connection.prepareStatement(deleteSQL);
        check = preparedStatement.executeUpdate();
        preparedStatement.clearParameters();

        return check > 0 ? "DB is clear." : "DB still contain information.";
    }

    public String deleteByID(int id) throws SQLException {
        String deleteByID = "DELETE FROM persons WHERE person_id = ?";
        String deletedPerson = showByID(id);

        preparedStatement = connection.prepareStatement(deleteByID);
        preparedStatement.setInt(1, id);

        check = preparedStatement.executeUpdate();
        preparedStatement.clearParameters();

        return check > 0 ? "Person " +deletedPerson+ " was deleted" : "Person wasn't deleted";
    }


    public String updateByID(int id, String newName, String newSurname, String newDateOfBirth) throws SQLException {
        String updateSQL = "UPDATE persons SET person_name=?, person_surname=?, person_dateOfBirth=? WHERE person_id=?";
        preparedStatement = connection.prepareStatement(updateSQL);

        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, newSurname);
        preparedStatement.setDate(3, Date.valueOf(LocalDate.parse(newDateOfBirth, dateTimeFormatter)));
        preparedStatement.setInt(4, id);

        check = preparedStatement.executeUpdate();
        preparedStatement.clearParameters();

        return check > 0 ? "Person was updated. "+showByID(id) : "Person wasn't updated. "+showByID(id);
    }
    public String updatePerson(Person person) throws SQLException {
        String updateSQL = "UPDATE persons SET person_name=?, person_surname=?, person_dateOfBirth=? WHERE person_id=?";
        preparedStatement = connection.prepareStatement(updateSQL);

        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getSurname());
        preparedStatement.setDate(3, Date.valueOf(LocalDate.parse(person.getDateOfBirth().toString(), dateTimeFormatter)));
        preparedStatement.setInt(4, person.getId());

        check = preparedStatement.executeUpdate();
        preparedStatement.clearParameters();

        return check > 0 ? "Person was updated. "+person : "Person wasn't updated. "+person;
    }
    public Person getByID(int id) throws SQLException {
        Person person = null;
        String selectUserSQL = "SELECT person_name, person_surname, person_dateOfBirth FROM persons WHERE person_id = ?";

        preparedStatement = connection.prepareStatement(selectUserSQL);
        preparedStatement.setInt(1, id); // Set the parameter for the ID

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            String name = resultSet.getString("person_name");
            String surname = resultSet.getString("person_surname");
            LocalDate dateOfBirth = resultSet.getDate("person_dateOfBirth").toLocalDate();

            person = new Person(name, surname, dateOfBirth);
        }
        return person;
    }
}
