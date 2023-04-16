package magicGame.models.magics;

import java.util.*;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicImpl implements Magic {
   private String name;
   private int bulletsCount;
//ch
    public MagicImpl(String name, int bulletsCount) {
        setName(name);
       setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return name;
    }
//checked x2
    protected void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new NullPointerException(INVALID_MAGIC_NAME);
        }
        this.name = name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }
//checked
    protected void setBulletsCount(int bulletsCount) {
        if (bulletsCount<0){
            throw new IllegalArgumentException(INVALID_MAGIC_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

}
