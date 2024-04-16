public class CardboardRecyclingItem extends RecyclingItem{
    public CardboardRecyclingItem(double weight, double volume, Cleanliness level, double cost) {
        super(weight, volume, level, cost);
    }

    @Override
    public Boolean checkFlammable() {
        return null;
    }
}
