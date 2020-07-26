package com.mycompany.blogserver;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ekcdr
 */
public class DatabaseManager {

//    private Connection dbConnection = null; // vt baglatisi icin connection nesnesi
    public Connection connectDB() throws ClassNotFoundException, SQLException {
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String JDBC_DATABASE_HOST = System.getenv("JAWS_JDBC_DATABASE_HOST");
        String JDBC_DATABASE_SCHEME = System.getenv("JAWS_JDBC_DATABASE_SCHEME");
        String JDBC_DATABASE_USERNAME = System.getenv("JAWS_JDBC_DATABASE_USERNAME");
        String JDBC_DATABASE_PASSWORD = System.getenv("JAWS_JDBC_DATABASE_PASSWORD");

        String JDBC_DATABASE_CONNECTION_STRING = "jdbc:mysql://";
        JDBC_DATABASE_CONNECTION_STRING += JDBC_DATABASE_HOST;
        JDBC_DATABASE_CONNECTION_STRING += "/";
        JDBC_DATABASE_CONNECTION_STRING += JDBC_DATABASE_SCHEME;
        JDBC_DATABASE_CONNECTION_STRING += "?reconnect=true&useUnicode=true&characterEncoding=UTF-8";

//        LoggerLib.Logger.print("JDBC_DATABASE_CONNECTION_STRING : " + JDBC_DATABASE_CONNECTION_STRING);
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(JDBC_DATABASE_CONNECTION_STRING, JDBC_DATABASE_USERNAME, JDBC_DATABASE_PASSWORD);

        LoggerLib.Logger.print("conn : " + conn);

        return conn;

//        if (conn == null) {
//            return false;
//        } else {
//            dbConnection = conn;
//            return true;
//        }
    }

    public void closeDB(Connection dbConnection) throws SQLException {
        LoggerLib.Logger.print("closeDB 1 : " + dbConnection.isClosed());

        if (!dbConnection.isClosed()) {
            dbConnection.close();
        }

        LoggerLib.Logger.print("closeDB 2 : " + dbConnection.isClosed());
    }

//    /**
//     * vt baglantisi var mi yok mu diye kontrol eder
//     *
//     * @return baglanti varsa true yoksa false doner
//     * @throws java.sql.SQLException
//     */
//    public boolean checkDBConnection() throws SQLException {
//        LoggerLib.Logger.print("db checkDBConnection");
//
//        if (dbConnection == null || dbConnection.isValid(3) == false || dbConnection.isClosed()) {
//            return false;
//        } else {
//            return true;
//        }
//    }
    public String getConstant(String key) throws SQLException, ClassNotFoundException {
        LoggerLib.Logger.print("getConstant : " + key);
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

        Connection dbConnection = connectDB();

        String query = "{CALL getconstant(?)}";
        CallableStatement stmt = dbConnection.prepareCall(query);
        stmt.setString(1, key);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        String value = "";
        if (rs.next()) {
            value = rs.getString(rsmd.getColumnName(1));
        }
        closeDB(dbConnection);
        return value;
    }

    public ArrayList<HashMap<String, String>> getArticles(String indicator) throws SQLException, ClassNotFoundException {
        LoggerLib.Logger.print("getArticles : " + indicator);
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

//        if (!checkDBConnection()) {
//            connectDB();
//        }
        Connection dbConnection = connectDB();

        String query = "{CALL getarticles(?)}";
        CallableStatement stmt = dbConnection.prepareCall(query);
        stmt.setString(1, indicator);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 1; i <= columnsNumber; i++) {
                LoggerLib.Logger.print("column name : " + rsmd.getColumnName(i) + " - value : " + rs.getString(rsmd.getColumnName(i)));
                map.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
            }
            dataArray.add(map);
        }
        closeDB(dbConnection);
        return dataArray;
    }

    public ArrayList<HashMap<String, String>> getMostReadArticles() throws SQLException, ClassNotFoundException {
        LoggerLib.Logger.print("getMostReadArticle");
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

//        if (!checkDBConnection()) {
//            connectDB();
//        }
        Connection dbConnection = connectDB();

        String query = "{CALL getmostreadarticles()}";
        CallableStatement stmt = dbConnection.prepareCall(query);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 1; i <= columnsNumber; i++) {
                LoggerLib.Logger.print("column name : " + rsmd.getColumnName(i) + " - value : " + rs.getString(rsmd.getColumnName(i)));
                map.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
            }
            dataArray.add(map);
        }
        closeDB(dbConnection);
        return dataArray;
    }

    public ArrayList<HashMap<String, String>> getArticle(String articleID) throws SQLException, ClassNotFoundException {
        LoggerLib.Logger.print("getArticle : " + articleID);
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

//        if (!checkDBConnection()) {
//            connectDB();
//        }
        Connection dbConnection = connectDB();

        String query = "{CALL getarticle(?)}";
        CallableStatement stmt = dbConnection.prepareCall(query);
        stmt.setString(1, articleID);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 1; i <= columnsNumber; i++) {
                LoggerLib.Logger.print("column name : " + rsmd.getColumnName(i) + " - value : " + rs.getString(rsmd.getColumnName(i)));
                map.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
            }
            dataArray.add(map);
        }
        closeDB(dbConnection);
        return dataArray;
    }

    public ArrayList<HashMap<String, String>> getCategoryArticles(String categroyName) throws SQLException, ClassNotFoundException {
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

//        if (!checkDBConnection()) {
//            connectDB();
//        }
        Connection dbConnection = connectDB();

        String query = "{CALL getcategoryarticles(?)}";
        CallableStatement stmt = dbConnection.prepareCall(query);
        stmt.setString(1, categroyName);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 1; i <= columnsNumber; i++) {
                LoggerLib.Logger.print("column name : " + rsmd.getColumnName(i) + " - value : " + rs.getString(rsmd.getColumnName(i)));
                map.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
            }
            dataArray.add(map);
        }
        closeDB(dbConnection);
        return dataArray;
    }

    public ArrayList<HashMap<String, String>> getCategories() throws SQLException, ClassNotFoundException {
        ArrayList<HashMap<String, String>> dataArray = new ArrayList<>();

//        if (!checkDBConnection()) {
//            connectDB();
//        }
        Connection dbConnection = connectDB();

        String query = "{CALL getcategories()}";
        CallableStatement stmt = dbConnection.prepareCall(query);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 1; i <= columnsNumber; i++) {
                LoggerLib.Logger.print("column name : " + rsmd.getColumnName(i) + " - value : " + rs.getString(rsmd.getColumnName(i)));
                map.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
            }
            dataArray.add(map);
        }
        closeDB(dbConnection);
        return dataArray;
    }

    public int getArticlesCount() throws SQLException, ClassNotFoundException {

//        if (!checkDBConnection()) {
//            connectDB();
//        }
        Connection dbConnection = connectDB();

        String query = "{CALL getarticlescount()}";
        CallableStatement stmt = dbConnection.prepareCall(query);

        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        int count = 0;
        if (rs.first()) {
            LoggerLib.Logger.print("column name : " + rsmd.getColumnName(1) + " - value : " + rs.getString(rsmd.getColumnName(1)));

            count = Integer.parseInt(rs.getString(rsmd.getColumnName(1)));
            closeDB(dbConnection);
        }
        closeDB(dbConnection);
        return count;
    }
}
