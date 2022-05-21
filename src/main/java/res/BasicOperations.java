package res;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BasicOperations {
    Statement statement;

    public BasicOperations() throws SQLException {
        MySQLConnection();
        testDB();

        System.out.println("\n- testSelect()...");
        testSelect();

        /*System.out.println("\n- testUpdate()...");
        testUpdate();

        System.out.println("\n- testSelect()...");
        testSelect();

        System.out.println("\n- testScrollable()...");
        testScrollable();

        System.out.println("\n- testUpdateable()...");
        testUpdateable();

        System.out.println("\n- testSelect()...");
        testSelect();

        System.out.println("\n- testSensitive()...");
        testSensitive();*/
    }
    public void MySQLConnection() throws SQLException {
        DBManager.setConnection(
                DBManager.JDBC_Driver_MySQL,
                DBManager.JDBC_URL_MySQL);
        statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
    }

    public void testDB() throws SQLException {
        try {
            /*
             * Simple query for testing that everything is OK. If an exception raised, the
             * db is deleted and created from scratch. For testing only!
             */
            statement.executeQuery("SELECT * FROM tbprova LIMIT 1");
        } catch (SQLException e) {
            statement.executeUpdate("DROP TABLE IF EXISTS tbprova");
            //statement.executeUpdate("CREATE TABLE tbprova (id INTEGER PRIMARY KEY, title VARCHAR(30), author VARCHAR(30), pages INTEGER)");
            statement.executeUpdate(
                    "INSERT INTO tbprova (id, title, author, pages) VALUES(1, 'The Lord of the Rings', 'Tolkien', 241)");
            statement.executeUpdate(
                    "INSERT INTO tbprova (id, title, author, pages) VALUES(2, 'Fight Club', 'Palahniuk', 212)");
            statement.executeUpdate(
                    "INSERT INTO tbprova (id, title, author, pages) VALUES(3, 'Computer Networks', 'Tanenbaum', 313)");
            statement.executeUpdate(
                    "INSERT INTO tbprova (id, title, author, pages) VALUES(4, 'Affective Computing', 'Picard', 127)");
        }
    }

    /**
     * Reads the content of the person table Results are limited using "LIMIT
     * 100" This is useful for very large tables
     */
    public void testSelect() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM tbprova LIMIT 100");
        while (rs.next()) {
            System.out.println(rowToString(rs));
        }
    }

    /**
     * Update the content of the book table
     */
    public void testUpdate() throws SQLException {
        /*statement.executeUpdate(
                "UPDATE book SET pages=176 WHERE id=1");*/
    }

    /**
     * Test Scrollable ResultSet
     */
    public void testScrollable() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM tbprova LIMIT 100 OFFSET 0");
        // Third record
        rs.absolute(2);
        System.out.println(rowToString(rs));

        // Previous record
        rs.previous();
        System.out.println(rowToString(rs));

        // +2 records from current position
        rs.relative(2);
        System.out.println(rowToString(rs));
    }

    /**
     * Test Updateable ResultSet Increment pages of one element
     */
    public void testUpdateable() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM tbprova LIMIT 100 OFFSET 0");
        while (rs.next()) {
            int pages = rs.getInt("pages");
            rs.updateInt("pages", pages + 10);
            rs.updateRow();
        }
    }

    /**
     * Test Sensitive ResultSet
     */
    public void testSensitive() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM tbprova LIMIT 100 OFFSET 0");
        for (int retry = 0; retry < 10; retry++) {
            System.out.printf("\n[%d] awaiting for external changes 10s...\n", retry);
            rs.beforeFirst();
            while (rs.next()) {
                rs.refreshRow();
                System.out.println(rowToString(rs));
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException ignored) {}
        }
    }

    /**
     * Prints the current ResultSet row
     */
    public String rowToString(ResultSet rs) throws SQLException {
        return String.format("id=%d, p1=%s, p2=%s",
                rs.getInt("id"),
                rs.getString("p1"),
                rs.getString("p2"));
    }

    public static void main(String[] args) {
        try {
            new BasicOperations();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
