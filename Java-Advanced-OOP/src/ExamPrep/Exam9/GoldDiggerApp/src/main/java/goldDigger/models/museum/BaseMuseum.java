package goldDigger.models.museum;

import java.util.*;

public abstract class BaseMuseum implements Museum{
private Collection<String> exhibits;

    public BaseMuseum() {
        this.exhibits=new ArrayList<>();
    }
}
