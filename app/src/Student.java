import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Student {

    public int id;
    public String name;
    public String loginId;
    public Map<Integer, String> classroom;

    public static List<Student> getAll() {

        String query = "SELECT * FROM facilitators_students;";
        List<Student> students = new ArrayList<Student>();
        
        try {
            DatabaseConnector db_con = new DatabaseConnector();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = db_con.getConnection();
            ResultSet rs = db_con.getData(con, query);

            System.out.println(123);
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return students;
    }
}