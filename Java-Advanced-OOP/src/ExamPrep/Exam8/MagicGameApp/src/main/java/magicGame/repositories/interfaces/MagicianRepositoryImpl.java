package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.*;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl  implements MagicianRepository<Magician> {
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        this.data.add(model);
    }

    @Override
    public Magician findByUsername(String name) {
        return data.stream()
                .filter(m -> name.equals(m.getUsername()))
                .findFirst()
                .orElse(null);
    }


    @Override
    public boolean removeMagician(Magician model) {
        return data.remove(model);
    }
}




