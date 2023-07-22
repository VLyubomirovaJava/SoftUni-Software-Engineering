package automappingobjectsexercise.service;

import automappingobjectsexercise.models.dto.OwnedGamesDto;
import automappingobjectsexercise.models.dto.UserLoginDto;
import automappingobjectsexercise.models.dto.UserRegisterDto;
import automappingobjectsexercise.models.entity.User;

import java.util.List;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logoutUser();
    List<OwnedGamesDto> printOwnedGames(User loggedInUser);
}
