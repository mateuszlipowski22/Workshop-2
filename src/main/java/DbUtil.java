import java.sql.*;

public class DbUtil {

    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";
    private static final String DB_PARAMS = "?useSSL=false&serverTimezone=UTC&characterEncoding=utf8&allowPublicKeyRetrieval=true";
    private static final String DB_SERVER_URL = "jdbc:mysql://localhost:3306/workshop2"+DB_PARAMS;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_PASS);
    }

}

