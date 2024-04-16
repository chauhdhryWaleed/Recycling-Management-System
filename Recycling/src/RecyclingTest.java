/**
 * Just a test class
 */
public class RecyclingTest {

    public static void main(String[] args) {
        PlasticRecyclingItem pot = new PlasticRecyclingItem(5, 350,Cleanliness.CLEAN, /* task 7.3 weight was negative in the constructor */
                0.05,250,true);

        System.out.println(pot);
    }
}
