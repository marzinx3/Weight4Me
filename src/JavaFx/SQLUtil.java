package JavaFx;

/**
 * Created by coolm_000 on 3/19/2016.
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLUtil extends SQLUtilAbstract
{
    static private final String URL = "jdbc:mysql://localhost/appft";
    static private final String DBDRIVER = "com.mysql.jdbc.Driver";
    static private final String DBUSER = "root";
    static private final String DBPASS = "";

    static {
        try {
            Class.forName(DBDRIVER).newInstance();
        } catch( InstantiationException e ) {
            e.printStackTrace();
        } catch( ClassNotFoundException e ) {
            e.printStackTrace();
        } catch( IllegalAccessException e ) {
            e.printStackTrace();
        }
    }

    public SQLUtil() throws SQLException {
        super();
    }

    public Connection getConnection() throws SQLException {
        return( DriverManager.getConnection( URL, DBUSER, DBPASS ) );
    }

    public void freeConnection( Connection conn ) throws SQLException {
        conn.close();
    }
}
