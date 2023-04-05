package catHouse.entities.houses;

public class ShortHouse extends BaseHouse {
   private final static int CAPACITY_SHORTHOUSE =15;
   private String name;


    public ShortHouse(String name) {
        super(name, CAPACITY_SHORTHOUSE);
    }
}
