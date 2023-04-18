package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.*;
import java.util.stream.Collectors;

public class ShopImpl implements Shop {

    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Collection<Tool> tools = worker.getTools().stream().filter(i -> !i.isUnfit()).collect(Collectors.toList());

        while (worker.canWork() && tools.iterator().hasNext()&&!vehicle.reached()) {
            Tool current = tools.iterator().next();
            while (!current.isUnfit()  && !vehicle.reached() && worker.canWork()) {
                worker.working();
                current.decreasesPower();
                vehicle.making();
            }
            tools.remove(current);
        }

    }
}

