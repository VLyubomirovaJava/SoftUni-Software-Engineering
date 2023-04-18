package vehicleShop.models.worker;

import vehicleShop.models.tool.Tool;

import java.util.*;

import static vehicleShop.common.ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY;
import static vehicleShop.common.ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO;

public abstract class BaseWorker implements  Worker {
private String name;
private int strength;
private Collection<Tool> tools;

    public BaseWorker(String name, int strength) {
        setName(name);
        setStrength(strength);
        this.tools=new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(String.format(WORKER_NAME_NULL_OR_EMPTY));
        }
        this.name = name;
    }

    protected void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools = tools;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return tools;
    }

    @Override
    public void working() {
        if (this.strength - 10 < 0) {
            this.strength = 0;
        } else {
            this.strength -= 10;
        }
    }
    @Override
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.strength>0;
    }

    @Override
    public String toString() {
long count = tools.stream()
        .filter(tool -> tool.getPower() > 0).count();
    return String.format("Name: %s, Strength: %d%nTools: %d fit left",name,strength,count);
    }
}

