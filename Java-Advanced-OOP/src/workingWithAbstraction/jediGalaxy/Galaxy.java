package workingWithAbstraction.jediGalaxy;

public class Galaxy {
  private Field field;
  private EvilForce evilForce;
  private  Player peter;

    public Galaxy(Field field, EvilForce evilForce, Player peter) {
        this.field = field;
        this.evilForce = evilForce;
        this.peter = peter;
    }
    public void moveEvil(){
        evilForce.move(this.field);
    }
    public void movePlayer(){
        peter.move(this.field);
    }
}
