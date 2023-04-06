package christmasPastryShop;

import christmasPastryShop.core.ControllerImpl;
import christmasPastryShop.core.EngineImpl;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.io.ConsoleReader;
import christmasPastryShop.io.ConsoleWriter;
import christmasPastryShop.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        DelicacyRepository<Delicacy> delicacyRepository = new DelicacyRepositoryImpl<Delicacy>();
        CocktailRepository<Cocktail> cocktailRepository= new CocktailRepositoryImpl<Cocktail>();
        BoothRepository<Booth> boothRepository = new BoothRepositoryImpl<Booth>();

        Controller controller =  new ControllerImpl(delicacyRepository, cocktailRepository, boothRepository);

        // TODO:OPTIONAL

        ConsoleReader reader = new ConsoleReader();
      ConsoleWriter writer = new ConsoleWriter();
     EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
