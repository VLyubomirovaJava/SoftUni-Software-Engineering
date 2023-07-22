package automappingobjectsexercise.service;

import automappingobjectsexercise.models.dto.AllGamesDto;
import automappingobjectsexercise.models.dto.DetailGameDto;
import automappingobjectsexercise.models.dto.GameAddDto;
import automappingobjectsexercise.models.entity.Game;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(long id, BigDecimal price, double size);

    void deleteGame(long id);

    List<AllGamesDto> allGames();

    DetailGameDto detailGame(String title);


}