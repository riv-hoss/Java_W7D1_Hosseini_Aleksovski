package Andrey;


import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class A3 {
    public static void main(String[] args) throws SQLException {
        Scanner scan;
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "";
        Statement statement = null;
        Connection connection = DriverManager.getConnection(url, user, password);
        ResultSet resultSet = null;

        String menu = "1. Find an employee by reg_ex first name\n2. Find employee by ID\3. ";

        boolean toContinue = true;

        String first_name = "";
        String last_name= "";
        int employee_id =0;
        Date hire_date = null;


        while (toContinue) {
            System.out.println("Please enter a command");
            System.out.println(menu);
            scan = new Scanner(System.in);
            int enteredValue = scan.nextInt();

            switch (enteredValue) {
                case 1:
                    System.out.println("PLease enter the name of the employee");
                    scan = new Scanner(System.in);
                    first_name = scan.nextLine();

                    try {
                        statement = connection.createStatement();
                        try {
                            String sql = "SELECT * FROM employees WHERE first_name LIKE '%" + first_name + "%' ORDER BY last_name";
                            resultSet = statement.executeQuery(sql);
                            System.out.println("emp_no    |   first_name    |    last_name   |    hire_date");
                            System.out.println("-------------------------------------");
                            while (resultSet.next()) {
                                int emp_no= resultSet.getInt("emp_no");
                                hire_date = resultSet.getDate("hire_date");
                                first_name = resultSet.getString("first_name");
                                last_name = resultSet.getString("last_name");

                                System.out.print(emp_no + "     |  ");
                                System.out.print(first_name + "     |  ");
                                System.out.print(last_name + "     |  ");
                                System.out.println(hire_date + "    |");
                            }

                        }finally {
                            if (resultSet != null) resultSet.close();
                        }
                    } finally {
                        if (statement != null) statement.close();
                    }
                    break;
                case 2:
                    System.out.println("PLease enter the ID of the employee you wanna search for");
                    scan = new Scanner(System.in);
                    employee_id = scan.nextInt();

                    try {
                        statement = connection.createStatement();
                        try {
                            String sql = "SELECT * FROM employees WHERE emp_no = " + employee_id ;
                            resultSet = statement.executeQuery(sql);
                            System.out.println("emp_no    |   first_name    |    last_name   |    hire_date");
                            System.out.println("-------------------------------------");
                            while (resultSet.next()) {
                                int emp_no= resultSet.getInt("emp_no");
                                hire_date = resultSet.getDate("hire_date");
                                first_name = resultSet.getString("first_name");
                                last_name = resultSet.getString("last_name");

                                System.out.print(emp_no + "     |  ");
                                System.out.print(first_name + "     |  ");
                                System.out.print(last_name + "     |  ");
                                System.out.println(hire_date + "    |");
                            }

                        }finally {
                            if (resultSet != null) resultSet.close();
                        }
                    } finally {
                        if (statement != null) statement.close();
                    }
                    break;

                    }



            }
        }



    }