package glacialExpedition.models.explorers;

import java.util.*;

public class NaturalExplorer extends BaseExplorer {
private  static final double  ENERGY_NATURAL = 60;
    public NaturalExplorer(String name) {
        super(name, ENERGY_NATURAL);
    }

    @Override
    public void search() {
       if (getEnergy()-7<0) {
           setEnergy(0);
       } else {
           setEnergy(getEnergy()-7);
       }
    }
}
