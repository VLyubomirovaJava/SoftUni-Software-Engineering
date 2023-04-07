package football.entities.field;

import java.util.*;

public class ArtificialTurf extends BaseField {
private final static int CAPACITY_ARTIFICIAL = 150;
    public ArtificialTurf(String name) {
        super(name, CAPACITY_ARTIFICIAL);
    }
}
