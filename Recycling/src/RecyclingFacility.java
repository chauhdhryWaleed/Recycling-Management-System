public class RecyclingFacility {

    private final String NAME;
    private final double MAX_WEIGHT;
    private final double MIN_COST;
    private final Boolean HANDLES_DIRTY;
    private final Boolean HANDLES_FLAMMABLE;


    public RecyclingFacility(String name, double weight, double minCost, boolean handlesDirty, boolean handlesFlammable){
        this.NAME = name;
        this.MAX_WEIGHT = weight;
        this.MIN_COST = minCost;
        this.HANDLES_DIRTY = handlesDirty;
        this.HANDLES_FLAMMABLE = handlesFlammable;
    }
    public Boolean checkCanProcess(RecyclingItem item) { /*task 7.5 */
        // Boolean handles = true;
        // Check if the weight of the item is below the maximum weight of this facility
        if (item.getWeight() > MAX_WEIGHT) {
            return false;
        }
    
        // Check if the recycling cost of the item is over the minimum cost this facility will accept
        if (item.getRecyclingCost() < MIN_COST) {
            return false;
        }
    
        // Check if this facility can handle soiled items (if applicable to item)
        if (!HANDLES_DIRTY && item.getLevel() == Cleanliness.SOILED) {
            return false;
        }
    
        // Check if this facility is able to handle flammable items (if applicable to item)
        if (!HANDLES_FLAMMABLE && item.checkFlammable()) {
            return false;
        }
    
        // If all conditions are satisfied, return true
        return true;
    }
    

    public String getName() {
        return NAME;
    }

    public double getMaxWeight() {
        return MAX_WEIGHT;
    }

    public double getMinCost() {
        return MIN_COST;
    }

    public Boolean getHANDLES_DIRTY() {
        return HANDLES_DIRTY;
    }

}
