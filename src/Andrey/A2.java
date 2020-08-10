package Andrey;


import java.sql.*;

public class A2 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";
        String password = "";
        Statement statement = null;
        Connection connection = DriverManager.getConnection(url, user, password);
        ResultSet resultSet = null;

        try{
            statement = connection.createStatement();
            ResultSet result = null;
            try{
                String sql = "SELECT * FROM students ORDER BY name";
                resultSet = statement.executeQuery(sql);
                System.out.println("Students name        |    Address");
                System.out.println("-------------------------------------");
                while(resultSet.next()) {

                    String name = resultSet.getString("name");
                    String address  = resultSet.getString("address");

                    System.out.print(name + "     |  ");
                    System.out.println(address);
                }

                sql = "SELECT students.name, courses.name FROM students INNER JOIN enrollments ON students.id = enrollments.fk_students_id INNER JOIN courses ON enrollments.fk_courses_id=courses.id ORDER BY students.name";
                resultSet = statement.executeQuery(sql);
                System.out.println("\n\nStudent        |    Courses");
                while(resultSet.next()) {

                    String name = resultSet.getString("students.name");
                    String address  = resultSet.getString("courses.name");

                    System.out.print(name + "     |  ");
                    System.out.println(address);
                }

            } finally {
                if(resultSet != null) resultSet.close();
            }
        } finally {
            if(statement != null) statement.close();
        }
    }
}