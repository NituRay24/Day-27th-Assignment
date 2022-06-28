import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class EmployeePayroll {
    public void demoJDBCConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/Project1";
        String user = "root";
        String pwd = "  ";
//Step 2: Establish the connection (path)
        Connection con = DriverManager.getConnection(url,user,pwd);

// Step3: Create a statement object
        Statement st = con.createStatement();

// Step 4: Execute query to get ResultSet
        String sql = "SELECT * FROM Employee";
        ResultSet rs = st.executeQuery(sql);

// Step 5: Iterate
        while(rs.next()){
            System.out.println( " Emp id: "+ rs.getString(1)+
                    "FirstName: " + rs.getString(2)+
                    "LastName: " + rs.getString(3) +
                    " Salary: " + rs.getDouble(4)+
                    " City: "+ rs.getString(5)+
                    " Emp_contact: "+ rs.getString(6)+
                    " EmailId "+ rs.getString(7)
            );
        }
// Step 6: Close the connection object
        con.close();
    }

    public static void main(String[] args) throws Exception {
// step 1: load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        EmployeePayroll epr = new EmployeePayroll();
        epr.demoJDBCConnection();
    }
}
