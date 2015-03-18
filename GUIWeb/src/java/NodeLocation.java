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

public class NodeLocation {
    protected ResultSetMetaData metaData     = null;
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
}