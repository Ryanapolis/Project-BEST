/*
 * This class is representative of a node object, with ID, Carrier and range
 * (not sure if we need this)
 */

/**
 *
 * @author Ashley
 */
public class NodeLocation {
    private String nodeID;
    private String carrier;
    private int range;
    
    public NodeLocation (String carrier, String nodeID, int range){
        this.carrier = carrier;
        this.nodeID = nodeID;
        this.range = range;
    }
    public String getNodeID(){
        return nodeID;
    }
    public String getCarrier(){
        return carrier;
    }
    public int getRange(){
        return range;
    }
}
