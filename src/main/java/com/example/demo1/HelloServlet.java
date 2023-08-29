package com.example.demo1;

import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Bienvenido a la base de datos Estudiantes";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        // Mostrar el formulario para insertar datos
        out.println("<form action=\"hello-servlet\" method=\"post\">");
        out.println("ID: <input type=\"text\" name=\"id\"><br>");
        out.println("Nombre: <input type=\"text\" name=\"nombre\"><br>");
        out.println("Edad: <input type=\"text\" name=\"edad\"><br>");
        out.println("Ciudad: <input type=\"text\" name=\"ciudad\"><br>");
        out.println("Cédula: <input type=\"text\" name=\"cedula\"><br>");
        out.println("<input type=\"submit\" value=\"Insertar\">");
        out.println("</form>");

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        try {
            Connection con = DatabaseConnection.initializeDatabase();

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String ciudad = request.getParameter("ciudad");
            int cedula = Integer.parseInt(request.getParameter("cedula"));

            String insertQuery = "INSERT INTO Estudiantes (ID, Nombre, edad, ciudad, cedula) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setInt(3, edad);
            preparedStatement.setString(4, ciudad);
            preparedStatement.setInt(5, cedula);
            preparedStatement.executeUpdate();

            out.println("<p>Datos insertados exitosamente</p>");

            preparedStatement.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error: No se pudo establecer la conexión a la base de datos</p>");
        }

        out.println("</body></html>");
    }
}