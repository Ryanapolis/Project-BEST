/*
 * This class is representative of a node object, with ID, Carrier and range
 * (not sure if we need this)
 */

/**
 *
 * @author Ashley
 */

/*
 *Class NodeLocation contains variables associated with nodes
 * and provides setters and getters for each member
 * NOTE: carrierName is never initialized in the constructor..(may take out)
 */
public class NodeLocation {
   
    private String carrierName;
    public void setCarrier(String name)
    {
        this.carrierName = name;
    }
    public String getCarrier()
    {
        return this.carrierName;
    }
    private String node;
    public void setNode(String node)
    {
        this.node = node;
    }
    public String getNode()
    {
        return this.node;
    }
    private String range;
    public void setRange(String range)
    {
        this.range = range;
    }
    public String getRange()
    {
        return this.range;
    }
    private String lat;
    public void setLat(String lat)
    {
        this.lat = lat;
    }
    public String getLat()
    {
        return this.lat;
    }
    private String lon;
    public void setLon(String lon)
    {
        this.lon = lon;
    }
    public String getLon()
    {
        return this.lon;
    }
    
    /*Constructor for the NodeLocation object
    * used for the query functions
    */
    public NodeLocation(String node, String range, String lat, String lon)
    {
        this.node = node;
        this.range = range;
        this.lat = lat;
        this.lon = lon;
    }
 }

