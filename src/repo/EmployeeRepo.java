package repo;

import main.Employee;

import java.sql.*;

public class EmployeeRepo {
    String url = "jdbc:mysql://localhost:3306/ems";
    String dbUsername = "root";
    String dbPassword = "My@23sql";

    public Employee getEmployee(int id){
        Connection connection = null ;
        PreparedStatement preparedStatement = null ;
        Employee employee = new Employee() ;

        try {

            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "SELECT * FROM employee where id = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                employee.id = resultSet.getInt(1);
                employee.firstname = resultSet.getString(2);
                employee.lastname = resultSet.getString(3);
                employee.gender = resultSet.getString(4);
                employee.phone = resultSet.getString(5);
                employee.position = resultSet.getString(6);
                employee.salary = resultSet.getInt(7);
                employee.isEmployee = resultSet.getInt(8);
            }


        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return employee;
        }finally {
            try {
                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();
                return employee;
            }catch (Exception e){
                e.printStackTrace();
                return employee;
            }
        }
    }

    public int checking(String username, String password) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int id = 0;
        try {


            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String query = "select id from login_info where username = ? AND password = ? ;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
                return id;
            } catch (SQLException e) {
                e.printStackTrace();
                return id;
            }
        }
    }

    public int insertEmployee(Employee employee){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int h = 0 ;
        try {

            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "INSERT INTO employee (first_name , last_name , gender , phone , position) VALUES (?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1 , employee.firstname);
            preparedStatement.setString(2 , employee.lastname);
            preparedStatement.setString(3 , employee.gender);
            preparedStatement.setString(4 , employee.phone);
            preparedStatement.setString(5 , employee.position);

            h = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in database connection");
            return h;
        }finally {
            try{
                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();
                return h;
            }catch (Exception e){
                e.printStackTrace();
                return h ;
            }

        }
    }

    public int updateEmployee(Employee employee){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowEffected = 0 ;
        try {

            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "UPDATE employee SET first_name = ? , last_name = ? , gender = ? , phone = ? , Position = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1 , employee.firstname);
            preparedStatement.setString(2 , employee.lastname);
            preparedStatement.setString(3 , employee.gender);
            preparedStatement.setString(4 , employee.phone);
            preparedStatement.setString(5 , employee.position);
            preparedStatement.setInt(6 , employee.id);
            rowEffected =  preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return rowEffected;
        }finally {
            try {
                if(connection != null)
                    connection.close();
                if(preparedStatement != null)
                    preparedStatement.close();
                return rowEffected;
            }catch (Exception e){
                e.printStackTrace();
                return rowEffected;
            }
        }
    }

    public int updateEmployeeSalary(Employee employee){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowEffected = 0 ;
        try {

            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "UPDATE employee SET salary = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , employee.salary);
            preparedStatement.setInt(2 , employee.id);
            rowEffected =  preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return rowEffected;
        }finally {
            try {
                if(connection != null)
                    connection.close();
                if(preparedStatement != null)
                    preparedStatement.close();
                return rowEffected;
            }catch (Exception e){
                e.printStackTrace();
                return rowEffected;
            }
        }
    }

    public int deleteEmployee(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowEffected = 0 ;
        try{

            connection = DriverManager.getConnection(url ,dbUsername ,dbPassword);
            String query = "DELETE FROM employee WHERE id = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            rowEffected = preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return rowEffected;
        }finally {
            try {
                if(connection != null)
                    connection.close();
                if(preparedStatement != null)
                    preparedStatement.close();
                return rowEffected;
            }catch (Exception e){
                e.printStackTrace();
                return rowEffected;
            }
        }
    }

    public int insertTOLoginInfo(String username , String password , int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int effectedRows = 0 ;
        try{

            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "INSERT INTO login_info (id , username , password) VALUES (?,?,?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , id);
            preparedStatement.setString(2 , username);
            preparedStatement.setString(3 , password);

            effectedRows = preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return effectedRows;
        }finally {
            try {
                if(connection != null)
                    connection.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                return effectedRows;
            }catch (Exception e){
                e.printStackTrace();
                return effectedRows;
            }
        }
    }

    public int getLoginInfo(int id){
        Connection connection = null ;
        PreparedStatement preparedStatement = null ;
        int i = 0 ;
        try {

            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "SELECT * FROM login_info where id = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                i = resultSet.getInt(1);
            }

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return i;
        }finally {
            try {
                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();
                return i;
            }catch (Exception e){
                e.printStackTrace();
                return i;
            }
        }
    }

    public int setOnline(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowEffected = 0 ;
        try {

            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "UPDATE employee SET online = 1 WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , id);
            rowEffected =  preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return rowEffected;
        }finally {
            try {
                if (connection != null)
                    connection.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                return rowEffected;
            } catch (Exception e) {
                e.printStackTrace();
                return rowEffected;
            }
        }
    }

    public int setOffline(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowEffected = 0 ;
        try {
            connection = DriverManager.getConnection(url , dbUsername , dbPassword);
            String query = "UPDATE employee SET online = 0 WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , id);
            rowEffected =  preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return rowEffected;
        }finally {
            try {
                if (connection != null)
                    connection.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                return rowEffected;
            } catch (Exception e) {
                e.printStackTrace();
                return rowEffected;
            }
        }
    }

    public int deleteLoginInfo(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowEffected = 0 ;
        try{

            connection = DriverManager.getConnection(url ,dbUsername ,dbPassword);
            String query = "DELETE FROM login_info WHERE id = ?;";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            rowEffected = preparedStatement.executeUpdate();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            return rowEffected;
        }finally {
            try {
                if(connection != null)
                    connection.close();
                if(preparedStatement != null)
                    preparedStatement.close();
                return rowEffected;
            }catch (Exception e){
                e.printStackTrace();
                return rowEffected;
            }
        }

    }



    public Object[][] getData() {
        Connection connection = null;
        Object[][] data = new Object[50][6];
        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String query = "select * from employee where is_employee = 1;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int j = 0 ;
            while (resultSet.next()) {
                for (int i = 0; i < 6; i++) {
                    data[j][i] = resultSet.getString(i + 1);

                }
                j++;
            }
            if(statement != null )
                statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return data;
    }

    public Object[][] getSalaryData() {
        Connection connection = null;
        Object[][] data = new Object[50][5];
        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String query = "select * from employee where is_employee = 1;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int j = 0 ;
            while (resultSet.next()) {
                data[j][0] = resultSet.getString(1);
                data[j][1] = resultSet.getString(2);
                data[j][2] = resultSet.getString(3);
                data[j][3] = resultSet.getString(6);
                data[j][4] = resultSet.getString(7);
                j++;
            }
            if(statement != null )
                statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return data;
    }

    public Object[][] getHomeData(){
        Connection connection = null;
        Object[][] data = new Object[50][8];
        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String query = "select * from employee where is_employee = 1;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int j = 0 ;
            while (resultSet.next()) {
                for (int i = 0; i < 7; i++) {
                    data[j][i] = resultSet.getString(i + 1);
                }
                data[j][7] = resultSet.getString(9);
                j++;
            }
            if(statement != null )
                statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return data;
    }

    public Object[][] getLoginInfo(){
        Connection connection = null;
        Object[][] data = new Object[50][8];
        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
            String query = "select id , username from login_info where id <> 29;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int j = 0 ;
            while (resultSet.next()) {
                for (int i = 0; i < 2; i++) {
                    data[j][i] = resultSet.getString(i + 1);
                }
                j++;
            }
            if(statement != null )
                statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return data;
    }
}
