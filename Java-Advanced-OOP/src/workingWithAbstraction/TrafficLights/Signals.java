package workingWithAbstraction.TrafficLights;

public enum Signals {
    RED,
    GREEN,
    YELLOW;
    private static Signals[] values =values();

  public  Signals next(){
      return values[(this.ordinal() + 1) % values.length];
  }
      public static Signals parse(String string){
              return Signals.valueOf(string);
      }
    }

