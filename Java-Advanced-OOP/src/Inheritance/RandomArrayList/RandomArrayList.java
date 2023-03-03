package Inheritance.RandomArrayList;

import java.util.*;
import java.util.ArrayList;

public class RandomArrayList extends ArrayList {
    private Random rnd;

    public Object getRandomElement() {
        int index = this.rnd.nextInt(super.size());
        Object element = super.get(index);
        super.remove(index);
        return element;
    }


}
