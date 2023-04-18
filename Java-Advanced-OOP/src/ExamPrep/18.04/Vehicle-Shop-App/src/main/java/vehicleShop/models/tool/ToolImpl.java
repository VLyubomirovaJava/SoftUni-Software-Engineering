package vehicleShop.models.tool;

import java.util.*;

import static vehicleShop.common.ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO;

public class ToolImpl implements Tool {
private int power;

    public ToolImpl(int power) {
setPower(power);    }

    protected void setPower(int power) {
        if (power<0){
            throw new IllegalArgumentException(TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        if (this.power-5 < 0){
            this.power =0;
        } else {
            this.power -= 5;

        }
    }



    @Override
    public boolean isUnfit() {
        return this.power==0;
    }
}
