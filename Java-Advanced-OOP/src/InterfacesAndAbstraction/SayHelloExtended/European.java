package InterfacesAndAbstraction.SayHelloExtended;
public class European extends BasePerson {

    protected European(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Hola";
    }
}
