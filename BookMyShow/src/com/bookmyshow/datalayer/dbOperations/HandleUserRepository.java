package com.bookmyshow.datalayer.dbOperations;

import com.bookmyshow.dto.User;
import com.bookmyshow.utils.exceptions.FieldAlreadyExists;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HandleUserRepository {

    static HandleUserRepository instance;
    Connection connection;
    Statement statement;
    final String tableName = "users";
    private HandleUserRepository(){
        try {
            String url = "jdbc:mysql://localhost:3306/bookmyshow";
            this.connection = DriverManager.getConnection(url, "root", "passwd");
            this.statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static HandleUserRepository getInstance(){
        if(instance == null){
            instance = new HandleUserRepository();
        }
        return instance;
    }
    public User validateUser(String username, String password) throws Exception{
        ResultSet rs = executeQuery("select * from "+tableName+" where username='"+username+"' and password='"+password+"'");
        if(rs.next()){
            String uid = rs.getString("userid");
            String uname = rs.getString("username");
            String passwd = rs.getString("password");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            String dob = rs.getString("dob");
            return  new User(Integer.parseInt(uid), uname, passwd, phone, email, dob);
        }
        return null;
    }
    private ResultSet executeQuery(String query){
        try {
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    private int insertQuery(String userName, String password, String phoneNumber, String email, String dob){
        try {
            int rows = statement.executeUpdate("insert into "+tableName+" values("+userName.hashCode()+", '"+userName+"', '"+password+"', '"+phoneNumber+"', '"+email+"', '"+dob+"')");
            return rows;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public User createUser(String userName, String password, String phoneNumber, String email, String dob){
        insertQuery(userName, password, phoneNumber, email, dob);
        return new User(userName, password, phoneNumber, email, dob);
    }
    public boolean validateFields(String value, String field) {
        try {
            ResultSet res = statement.executeQuery("select * from "+tableName+" where "+field+"='"+value+"'");
            if(!res.next()){
                return true;
            }else {
                throw new FieldAlreadyExists(field);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
