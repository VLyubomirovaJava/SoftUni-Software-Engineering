package automappingobjectsexercise.service.impl;

import automappingobjectsexercise.models.dto.AllGamesDto;
import automappingobjectsexercise.models.dto.DetailGameDto;
import automappingobjectsexercise.models.dto.GameAddDto;
import automappingobjectsexercise.models.entity.Game;
import automappingobjectsexercise.repository.GameRepository;
import automappingobjectsexercise.service.GameService;
import automappingobjectsexercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper mapper;
    private final ValidationUtil validationUtil;
    private final UserServiceImpl userService;

    public GameServiceImpl(GameRepository gameRepository, ModelMapper mapper, ValidationUtil validationUtil, UserServiceImpl userService) {
        this.gameRepository = gameRepository;
        this.mapper = mapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (!isValidEntity(gameAddDto)) return;
        Game game = mapper.map(gameAddDto, Game.class);
        gameRepository.save(game);

    }


    @Override
    public void editGame(long id, BigDecimal price, double size) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            System.out.println("There is no game with this ID.");
            return;
        }
        if (size < 0 && price.compareTo(BigDecimal.ZERO) != 0) {
            System.out.println("Enter positive price and size");
            return;

        }
        game.get().setPrice(price);
        game.get().setSize(size);
        gameRepository.save(game.get());
        System.out.println("Edited " + game.get().getTitle());

    }

    @Override
    public void deleteGame(long id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isEmpty()) {
            System.out.println("There is no game with this ID.");
            return;
        }
        gameRepository.delete(game.get());
    }

    @Override
    public List<AllGamesDto> allGames() {
        return gameRepository.findAll().stream()
                .map(g -> mapper.map(g, AllGamesDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public DetailGameDto detailGame(String title) {
        Game game = gameRepository.findGameByTitle(title);
        DetailGameDto detailGameDto = null;
        if (game != null) {
            detailGameDto = mapper.map(game, DetailGameDto.class);
        }
        return detailGameDto;
    }


    private <E> boolean isValidEntity(E entity) {
        Set<ConstraintViolation<E>> violations = validationUtil.violation(entity);
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return false;
        }
        return true;
    }

}