package DefiningClasses_Exercise.CarSalesman;


public class Car {
  private String model;
  private Engine engine;
  private int weight;
  private String color;

  public Car(String model, Engine engine, int weight, String color) {
    this.model = model;
    this.engine = engine;
    this.weight = weight;
    this.color = color;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.model).append(":").append(System.lineSeparator()); // model
    sb.append(this.engine.getModel()).append(":").append(System.lineSeparator()); //engine model
    sb.append("Power: ").append(this.engine.getEnginePower()).append(System.lineSeparator()); // engine model's power
    sb.append("Displacement: ");
    if (this.engine.getEngineDisplacement() == 0) {
      sb.append("n/a").append(System.lineSeparator());
    } else {
      sb.append(this.engine.getEngineDisplacement()).append(System.lineSeparator()); // engine model's displacement
    }
    sb.append("Efficiency: ");
    if (this.engine.getEngineEfficiency() == null) {
      sb.append("n/a").append(System.lineSeparator());
    } else {
      sb.append(this.engine.getEngineEfficiency()).append(System.lineSeparator()); // engine model's efficiency
    }
    sb.append("Weight: ");
    if (this.weight == 0) {
      sb.append("n/a").append(System.lineSeparator());
    } else {
      sb.append(this.weight).append(System.lineSeparator()); // car's weight
    }
    sb.append("Color: ");
    if (this.color == null) {
      sb.append("n/a").append(System.lineSeparator());
    } else {
      sb.append(this.color).append(System.lineSeparator()); // car's color
    }
    return sb.toString();
  }
}

