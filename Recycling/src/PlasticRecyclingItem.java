/**
 * Subclass of Recycling Item
 
 */
public class PlasticRecyclingItem extends RecyclingItem{

    //Attributes

    private double meltingPoint;
    private boolean foodSafe;

    //Constructor(s)

    public PlasticRecyclingItem(double weight, double volume, Cleanliness level, double cost,
                                double meltingPoint, boolean foodSafe) {
        super(weight, volume, level, cost);
        this.meltingPoint = meltingPoint;
        this.foodSafe = foodSafe;
    }

    //Mutator methods
   

    public void setMeltingPoint(double meltingPoint) {
        if (isValidMeltingPoint(meltingPoint)){
            this.meltingPoint = meltingPoint;
        } else {
            throw new IllegalArgumentException("Melting point (" + meltingPoint +
                    ") is outside allowable parameters (0 -- 800)");
        }
    }

    public void setFoodSafe(boolean foodSafe) {
        this.foodSafe = foodSafe;
    }

    //Accessor methods

    public double getMeltingPoint() {
        return this.meltingPoint;
    }

    public boolean isFoodSafe(){
        return this.foodSafe;
    }

    //Overriden methods
    @Override
    public String toString() {  /*task 7.2*/
        return "PlasticRecyclingItem : " +
                "weight=" + getWeight() +
                ", volume=" + getVolume() +
                ", cleanliness=" + getLevel() +
                ", recycling_cost_unit=" + getRecyclingCost() +
                ", meltingPoint=" + getMeltingPoint() +
                ", foodSafe=" + isFoodSafe() 
                ;
    }

    //Other methods

    /**
     * Method to validate input for melting point
     */
    public boolean isValidMeltingPoint(double value) {
        return ((value > 0) && (value < 800));
    }

    @Override
    public double getRecyclingCost(){
        double cost = super.getRecyclingCost();
        if(foodSafe){
            return 2*cost;
        } else {
            return cost;
        }
    }

    public Boolean checkFlammable() {
        return true;
    }
}
