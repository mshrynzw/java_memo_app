package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    // JDBC URL, ユーザー名、パスワードを設定
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/memo_app";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    
    static {
        try {
            // JDBCドライバの登録
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBCドライバの読み込みに失敗しました", e);
        }
    }
    
    // データベース接続を取得するメソッド
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }
    
    // リソースを解放するメソッド
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}