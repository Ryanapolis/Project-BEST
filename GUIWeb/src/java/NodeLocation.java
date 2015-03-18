/*
 * This class is representative of a node object, with ID, Carrier and range
 * (not sure if we need this)
 */

/**
 *
 * @author Ashley
 */


public class NodeLocation {
   
    protected String carrierName;
    String getCarrier()
    {
        return carrierName;
    }
    protected String node;
    String getNode()
    {
        return node;
    }
    protected int range;
    int getRange()
    {
        return range;
    }
    protected long lat;
    long getLat()
    {
        return lat;
    }
    protected long lon;
    long getLon()
    {
        return lon;
    }
    
    public NodeLocation(String node, int range, long lat, long lon)
    {
        this.node = node;
        this.range = range;
        this.lat = lat;
        this.lon = lon;
    }

 }

