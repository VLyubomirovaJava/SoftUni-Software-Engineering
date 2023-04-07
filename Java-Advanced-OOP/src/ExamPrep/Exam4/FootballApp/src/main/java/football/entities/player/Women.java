package football.entities.player;

public class Women extends BasePlayer {
   private final static double KG_WOMEN=60.0;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(KG_WOMEN);
    }

    @Override
    public void stimulation() {
      setStrength(getStrength()+115);
    }
}
