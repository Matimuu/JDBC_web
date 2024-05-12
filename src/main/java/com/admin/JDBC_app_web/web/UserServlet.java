//package com.admin.JDBC_app_web.web;
///**
// * @author Mendoza Perez Omar Enrique
// * @date 2024/05/08 18:29
// */
//
//import com.admin.JDBC_app_web.model.Person;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Collection;
//
//@WebServlet("/")
//public class UserServlet extends HttpServlet {
//    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    private Logger log = LogManager.getLogger("mainLog");
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        String action = request.getServletPath();
//        try {
//            switch (action) {
//                case "/new":
//                    showNewForm(request, response);
//                    break;
//                case "/insert":
//                    insertPerson(request, response);
//                    break;
//                case "/update":
//                    updatePerson(request, response);
//                    break;
//                case "/delete":
//                    deletePerson(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
//                default:
//                    listPerson(request, response);
//                    break;
//            }
//        } catch (SQLException | ServletException | IOException e) {
//            log.error("Error in handling request: " + e.getMessage());
//            e.printStackTrace(); // Log stack trace for debugging
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    // New Person
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("person-form.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    // Insert Person
//    private void insertPerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"), dateTimeFormatter);
//
//        Person newPerson = new Person(name, surname, dateOfBirth);
//        dBoperator.addPerson(newPerson);
//        response.sendRedirect("list");
//    }
//
//    // Delete Person
//    private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        dBoperator.deleteByID(id);
//        response.sendRedirect("list");
//    }
//
//    // Edit Person
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Person existPerson = dBoperator.getByID(id);
//
//        jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("person-form.jsp");
//        request.setAttribute("person", existPerson);
//
//        dispatcher.forward(request, response);
//    }
//
//    // Update Person
//    private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"), dateTimeFormatter);
//
//        Person updatedPerson = new Person(id, name, surname, dateOfBirth);
//
//        dBoperator.updatePerson(updatedPerson);
//        response.sendRedirect("list");
//    }
//
//    // Default
//    private void listPerson(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        Collection<Person> listPerson = dBoperator.showAll();
//        request.setAttribute("listPerson", listPerson);
//
//        jakarta.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("person-list.jsp");
//        dispatcher.forward(request, response);
//    }
//}