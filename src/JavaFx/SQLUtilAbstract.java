package JavaFx;

/**
 * Created by coolm_000 on 3/19/2016.
 */
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class SQLUtilAbstract
{
    public static final boolean PREPARED = true;
    public static final boolean CALLABLE = false;

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet rset;

    private boolean mode = PREPARED;

    public SQLUtilAbstract() throws SQLException
    {
        reset();
    }

    public abstract Connection getConnection() throws SQLException;

    public abstract void freeConnection( Connection conn ) throws SQLException;

    public void setInt( int index, int value ) throws SQLException
    {
        prep.setInt( index, value );
    }

    public int getInt( int index ) throws SQLException
    {
        return ((CallableStatement)prep).getInt( index );
    }

    public void setString( int index, String value ) throws SQLException
    {
        prep.setString( index, value );
    }

    public String getString( int index ) throws SQLException
    {
        return ((CallableStatement)prep).getString( index );
    }

    public void setBoolean( int index, boolean value ) throws SQLException
    {
        prep.setBoolean( index, value );
    }

    public boolean getBoolean( int index ) throws SQLException
    {
        return ((CallableStatement)prep).getBoolean( index );
    }

    public void setNull( int index, int type ) throws SQLException
    {
        prep.setNull( index, type );
    }

    public void setTimestamp( int index, java.sql.Timestamp time ) throws SQLException
    {
        prep.setTimestamp( index, time );
    }

    public Timestamp getTimestamp( int index ) throws SQLException
    {
        return ((CallableStatement)prep).getTimestamp( index );
    }

    public void registerOutParameter( int index, int type ) throws SQLException
    {
        ((CallableStatement)prep).registerOutParameter( index, type );
    }

    public ResultSet executeQuery() throws SQLException
    {
        rset = prep.executeQuery();
        return( rset );
    }

    public int executeUpdate() throws SQLException
    {
        return( prep.executeUpdate() );
    }

    public boolean execute() throws SQLException
    {
        return( prep.execute() );
    }

    public void setMode( boolean mode )
    {
        this.mode = mode;
    }

    public void reset()
    {
        subclose();
        setMode( PREPARED );
    }

    public void setSQL( String sql ) throws SQLException
    {
        if( conn == null )
        {
            conn = getConnection();
        }

        if( mode == PREPARED )
        {
            prep = conn.prepareStatement( sql );
        }
        else
        {
            prep = conn.prepareCall( sql );
        }
    }

    public void subclose()
    {
        if( rset != null )
        {
            try
            {
                rset.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
        if( prep != null )
        {
            try
            {
                prep.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }

    public void close()
    {
        subclose();

        if( conn != null )
        {
            try
            {
                freeConnection( conn );
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
