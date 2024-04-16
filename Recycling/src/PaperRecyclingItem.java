public class PaperRecyclingItem extends RecyclingItem {

    private boolean printed;
    private int materialDensity;

    public PaperRecyclingItem(double weight, double volume, Cleanliness level, double recyclingCostPerUnit,
                              boolean printed, int materialDensity) {
        super(weight, volume, level, recyclingCostPerUnit);
        setPrinted(printed);
        setMaterialDensity(materialDensity);
    }

    public boolean isPrinted() {
        return printed;
    }

    public void setPrinted(boolean printed) {
        this.printed = printed;
    }

    public int getMaterialDensity() {
        return materialDensity;
    }

    public void setMaterialDensity(int materialDensity) {
        if (materialDensity < 0 || materialDensity > 50) {
            throw new IllegalArgumentException("Material density is out of range!");
        }
        this.materialDensity = materialDensity;
    }

    @Override
    public String toString() {  /*task 7.2*/
        return "PlasticRecyclingItem : " +
                "weight=" + getWeight() +
                ", volume=" + getVolume() +
                ", cleanliness=" + getLevel() +
                ", recycling_cost_unit=" + getRecyclingCost() +
                ", printed=" + isPrinted() +
                ", material density=" + getMaterialDensity() 
                ;
    }

    public Boolean checkFlammable() {
        if(materialDensity<=20){
            return true;
        } else {
            return false; /* task 7.2 semi colon was missing*/
        }
    }

}
