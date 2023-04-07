package football.entities.player;

public class Men extends BasePlayer {

        private final static double KG_MEN=85.50;

        public Men(String name, String nationality, int strength) {
            super(name, nationality, strength);
            setKg(KG_MEN);
        }

        @Override
        public void stimulation() {
            setStrength(getStrength()+145);
        }
    }