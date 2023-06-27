//JAVA Database Connectivity theory by telusko
/*
* 1. import -------------> jav.sql
* 2. load and register the driver  -------->  there multiple types of drivers depends upon which DB we are using (com.mysql.jdbc.Driver)
* 3. Create connection             ---------> Create object of Connection Interface
* 4. Create a statement            ---------> Create object of Statement Interface
* 5. Execute the query
* 6. Process the results
* 7. Close the connection
*
    *
    * DAO --> Whenever working with databases, have a DOA layer ( database access object)
*  */



import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");  //class forname telusko
        String url = "jdbc:mysql://localhost:3306/learningjdbc";
        String uname = "root";
        String pass = "Sidjais@9534";
        String query = "insert into student values('jaiswal', ' siddhant', 'informatica') ";
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        int rs =  st.executeUpdate(query);
        System.out.println("ROWS AFFECTED "+rs);
//        while(rs.next()) {
//
//            String name = rs.getString("FirstName");
//            String lastname = rs.getString("LastName");
//            System.out.println(name);
//        System.out.println(lastname);
////            rs.next();
//
//        }
//        System.out.println(name);
//        System.out.println(lastname);
        st.close();;
        con.close();


    }
}