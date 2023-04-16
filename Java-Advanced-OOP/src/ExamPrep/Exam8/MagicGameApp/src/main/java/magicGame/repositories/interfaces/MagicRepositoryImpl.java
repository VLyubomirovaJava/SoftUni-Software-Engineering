package magicGame.repositories.interfaces;

import magicGame.models.magics.Magic;

import java.util.*;

import static magicGame.common.ExceptionMessages.INVALID_MAGIC_NAME;

public class MagicRepositoryImpl implements MagicRepository<Magic> {
 Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return data;
    }

    @Override
    public void addMagic(Magic model) {
if (model==null){
    throw new NullPointerException(INVALID_MAGIC_NAME);
}
this.data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {

        return data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return data.stream()
                .filter(magic -> name.equals(magic.getName()))
                .findFirst()
                .orElse(null);
    }
}
