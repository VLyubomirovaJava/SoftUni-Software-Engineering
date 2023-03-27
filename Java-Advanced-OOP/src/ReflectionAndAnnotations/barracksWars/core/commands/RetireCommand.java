package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;

public class RetireCommand extends Command {

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        String unitType = getData()[1];
        try {
            try {
                getRepository().removeUnit(getData()[1]);
            } catch (ExecutionControl.NotImplementedException e) {
                throw new RuntimeException(e);
            }
            return String.format("%s retired!", unitType);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
}