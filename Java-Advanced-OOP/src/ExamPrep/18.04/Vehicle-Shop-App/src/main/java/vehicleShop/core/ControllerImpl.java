package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.*;
import java.util.stream.Collectors;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
private WorkerRepository workers;
private VehicleRepository vehicles;
private int counter;

    public ControllerImpl() {
        this.vehicles = new VehicleRepository();
        this.workers=new WorkerRepository();
        counter=0;
    }

    @Override
    public String addWorker(String type, String workerName) {
Worker worker;
    if (type.equals("FirstShift")){
        worker=new FirstShift(workerName);
    } else if (type.equals("SecondShift")) {
        worker = new SecondShift(workerName);
    } else {
        throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
    }
workers.add(worker);
    return String.format(String.format(ADDED_WORKER,type,workerName));
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
   Vehicle vehicle = new VehicleImpl(vehicleName,strengthRequired);
   vehicles.add(vehicle);
   return String.format(String.format(SUCCESSFULLY_ADDED_VEHICLE,vehicleName));
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
    Worker worker = workers.findByName(workerName);
    if (worker==null){
        throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
    }
    Tool tool = new ToolImpl(power);
    worker.addTool(tool);
    return String.format(String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER,power,workerName));
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Shop shop = new ShopImpl();
        Vehicle vehicle = vehicles.findByName(vehicleName);
        List<Worker> suitable = workers.getWorkers().stream()
                .filter(worker -> worker.getStrength()>70)
                .collect(Collectors.toList());
        int unfitTools =0;
        String output = "not done";
        if (suitable.isEmpty()) {
            throw new IllegalArgumentException(NO_WORKER_READY);
        }
        while (!suitable.isEmpty() &&!vehicle.reached()){
            Worker worker= suitable.get(0);

            while (!vehicle.reached() && worker.canWork() &&
            worker.getTools()
                    .stream()
                    .filter(t -> !t.isUnfit()).count()>0){
                shop.make(vehicle,worker);
            }
            if (vehicle.reached()){
                counter++;
                output="done";
            }
            unfitTools += worker.getTools()
                    .stream()
                    .filter(tool -> tool.isUnfit()).count();
            if (worker.getStrength()==0
                    || worker.getTools().stream()
                    .filter(tool -> !tool.isUnfit()).count()==0){
                suitable.remove(0);
            }
        }
StringBuilder sb = new StringBuilder();
        sb.append(String.format(VEHICLE_DONE,vehicleName,output));
        sb.append(String.format(COUNT_BROKEN_INSTRUMENTS,unfitTools));
        return sb.toString();

    }

    @Override
    public String statistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d vehicles are ready!",counter)).append(System.lineSeparator());
        sb.append("Info for workers:").append(System.lineSeparator());
        workers.getWorkers().forEach(worker -> sb.append(worker.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
