package WildFarm;

import java.util.*;

public abstract class Food {
  private Integer quantity;

    public Food(Integer quantity) {
        this.quantity =quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }


}
