/*
 * This class is representative of a node object, with ID, Carrier and range
 * (not sure if we need this)
 */

/**
 *
 * @author Ashley
 */


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONWriter;

public class NodeLocation {
    protected ResultSetMetaData metaData     = null;
    protected JSONWriter        jsw          = null;
    protected ResultSet         rs           = null;
    protected int               columnCount  = 0;
    protected String            propertyName = null;
    protected String carrierName;
    String getCarrier() {
            return carrierName;
            }
    protected String node;
    protected int range;
    
    public NodeLocation(String carrier, String node, int range)
    {
        this.carrierName = carrier;
        this.node = node;
        this.range = range;
    }
    
    
    public void process(String __propertyName, ResultSet __rs, JSONWriter __jsw) throws JSONException, SQLException {

        this.propertyName = __propertyName;

        this.jsw = __jsw;

        this.rs = __rs;

        this.metaData = __rs.getMetaData();

        this.columnCount = metaData.getColumnCount();

        jsw.key(propertyName);

        jsw.array();

        while (rs.next()) {

            jsw.object();

            processRow();

            jsw.endObject();

        }

        jsw.endArray();

    }
     protected void processRow() throws SQLException {

        for (int column = 1; column <= columnCount; column++) {
            try {
                String columnName = metaData.getColumnName(column);

                jsw.key(columnName);

                jsw.value(rs.getString(column));
            } catch (JSONException ex) {
                Logger.getLogger(NodeLocation.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
