package domains.farmer;

import problem.State;
import java.util.stream.Stream;

/**
 * @author Mei
 */
public class FarmerState implements State {
    
    /**
     * intializes the strings
     * @param farmer
     * @param wolf
     * @param goat
     * @param cabbage 
     */
    public FarmerState(String farmer, String wolf, String goat, String cabbage){
        this.farmer = farmer;
        this.wolf = wolf;
        this.goat = goat;
        this.cabbage = cabbage;
    }
    
    /**
     * creates a string of the state
     * @return return a completed string
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
    
        sb.append("   |  |   \n");
        
        if(farmer.equals("West")){
            sb.append(" F |  |   \n");
        }
        else{
            sb.append("   |  | F \n");
        }
        
        if(wolf.equals("West")){
            sb.append(" W |  |   \n");
        }
        else{
            sb.append("   |  | W \n");
        }
        
        if(goat.equals("West")){
            sb.append(" G |  |   \n");
        }
        else{
            sb.append("   |  | G \n");
        }
        
        if(cabbage.equals("West")){
            sb.append(" C |  |   \n");
        }
        else{
            sb.append("   |  | C \n");
        }
        
        sb.append("   |  |   ");
        return sb.toString();
    }
    
    /**
     * compare two states to find out if they are the same or equal
     * @param other type of object
     * @return returns a boolean value. False if the objects are equal and true if they are
     */
    @Override
    public boolean equals(Object other){
        FarmerState otherFarmer = (FarmerState) other;
        if(otherFarmer != null){
        if((this.farmer.equals(otherFarmer.farmer))&& (this.wolf.equals(otherFarmer.wolf))){
            if((this.goat.equals(otherFarmer.goat)) && (this.cabbage.equals(otherFarmer.cabbage))){
                return true;
            }}
        }
        return false;
    }
    
    public String getFarmerState(){
        return farmer;
    }
    
    public String getWolfState(){
        return wolf;
    }
    
    public String getGoatState(){
        return goat;
    }
    
    public String getCabbageState(){
        return cabbage;
    }
    
    
    
    private final String farmer;
    private final String wolf;
    private final String goat;
    private final String cabbage;
}
