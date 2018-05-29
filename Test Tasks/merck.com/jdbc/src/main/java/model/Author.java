package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import controller.SQLite;

/**
 * Test task Bookshelf from merck.com
 * Class Author provides operation with the relevant table
 *
 * @author Sergey Iryupin
 * @version dated May 28, 2018
 */

public class Author {
    Connection connection;
    Statement stmt;

    public Author() {
        connection = SQLite.getConnection();
    }

    /**
     * Adding one record into table
     *
     * @param  {int}    id
     * @param  {String} name
     * @return  void
     **/
    public void add(int id, String name) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS " +
                    this.getClass().getSimpleName() +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " NAME TEXT NOT NULL);");
            stmt.executeUpdate(
                    "INSERT INTO " +
                    this.getClass().getSimpleName() +
                    " (ID, NAME) VALUES (" + id + ", '" + name + "');");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String get(int id) {
        try (Statement stmt = connection.createStatement();
             PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT * FROM " +
                    this.getClass().getSimpleName() +
                    " WHERE id=?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                return rs.getString("NAME");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}