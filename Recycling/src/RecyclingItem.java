/**
 * A class for recycling items?
 
 */
public abstract class RecyclingItem {  /* task 7.2 changed to abstract class */

    //Attributes

    private final double WEIGHT;
    private final double VOLUME;
    private final Cleanliness LEVEL;
    private final double COST_PER_UNIT;

    //Constructor
   

    
    public RecyclingItem(double weight, double volume, Cleanliness level, double cost) {

        if (isValidVolOrWeight(weight)){
            this.WEIGHT = weight;
        } else {
            throw new IllegalArgumentException("Weight (" + weight + ") is outside allowable parameters (0 -- 10000)");
        }
        if (isValidVolOrWeight(volume)){
            this.VOLUME = volume;
        } else {
            throw new IllegalArgumentException("Volume (" + volume + ") is outside allowable parameters (0 -- 10000)");
        }


        this.LEVEL = level;
        this.COST_PER_UNIT = cost;
    }

    //Accessor methods
    public double getWeight() {
        return this.WEIGHT;
    }

    public double getVolume() {
        return VOLUME;
    }

    public Cleanliness getLevel() {
        return LEVEL;
    }

    public double getCostPerUnit() {
        return COST_PER_UNIT;
    }

    //Mutator methods
    

    //Overriden methods

    @Override
    public String toString() {  /* task 7.2 changed the implementation of this fun */
        return "RecyclingItem{" +
                "WEIGHT=" + WEIGHT +
                ", VOLUME=" + VOLUME +
                ", LEVEL=" + LEVEL +
                ", COST_PER_UNIT=" + COST_PER_UNIT +
                '}';
    }


    //Other methods?
    

    /**
     * Method to validate input for volume and weight
     */
    public boolean isValidVolOrWeight(double value) {
        return ((value > 0) && (value < 10000));
    }

    public double getRecyclingCost(){
        return WEIGHT/VOLUME*COST_PER_UNIT;
    }

    public abstract Boolean checkFlammable();
}
