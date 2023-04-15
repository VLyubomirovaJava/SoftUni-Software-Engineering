package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO;
import static glacialExpedition.common.ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
     setName(name);
       setEnergy(energy);
        this.suitcase =new Carton();
    }

    @Override
    public String getName() {
        return name;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    public void setSuitcase(Suitcase suitcase) {
        this.suitcase = suitcase;
    }

    @Override
    public void search() {
        if (getEnergy()-15<0) {
            setEnergy(0);
        } else {
            setEnergy(getEnergy()-15);
        }
    }

    @Override
    public boolean canSearch() {
        return getEnergy() > 0;
    }



    @Override
    public String toString() {
StringBuilder output = new StringBuilder();
    String suitcaseReport = suitcase.getExhibits().isEmpty()
            ? "None"
            :suitcase.getExhibits().stream()
            .collect(Collectors.joining(", "));

        output.append( String.format(FINAL_EXPLORER_NAME, name)).append(System.lineSeparator());
        output.append( String.format(FINAL_EXPLORER_ENERGY, energy)).append(System.lineSeparator());
        output.append( String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, suitcaseReport)).append(System.lineSeparator());
        return output.toString().trim();
    }
}

