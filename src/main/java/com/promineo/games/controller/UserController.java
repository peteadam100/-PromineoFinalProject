/**
 * 
 */
package com.promineo.games.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.games.entity.UserEntity;
import com.promineo.games.service.IUserService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class UserController implements IUserController {
  
  @Autowired
  private IUserService iUserService;
  
  /*
   * ===============================================================================================
   * CREATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public UserEntity addUser(UserEntity user) {
    log.debug("Controller: add user: {}", user);
    return iUserService.addUser(user);
  }

  @Override
  public void joinGame(Long userId, Long gameId) {
    log.debug("Controller: added user with id={} to game with id={}", userId, gameId);
    iUserService.joinUserToGame(userId, gameId);
  }


  /*
   * ===============================================================================================
   * FETCH OPERATIONS
   * ===============================================================================================
   */
  @Override
  public List<UserEntity> getAllUsers() {
    log.debug("Controller: Request for list of all existing users");
    return iUserService.fetchAllUsers();
  }

  @Override
  public UserEntity getUser(Long userId) {
    log.debug("Controller: Request for user id: {}", userId);
    return iUserService.fetchUserById(userId)
        .orElseThrow(() -> new NoSuchElementException("Game with ID=" + userId + " was not found"));
  }
  
  @Override
  public Map<Long, String> getGamesForUser(Long userId) {
    log.debug("Controller: Request for all games for user id: {}", userId);
    return iUserService.fetchGamesForUserById(userId);
  }
  
  @Override
  public Map<Long, String> getUsersForGame(Long gameId) {
    log.debug("Controller: Request for all games for user id: {}", gameId);
    return iUserService.fetchUsersForGameById(gameId);
  }

  /*
   * ===============================================================================================
   * UPDATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public UserEntity updateUser(UserEntity userEntity, Long userId) {
    log.debug("Controller: Update user with id={}", userId);
    return iUserService.updateUser(userEntity, userId);
  }


  /*
   * ===============================================================================================
   * DELETE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public void leaveGame(Long userId, Long gameId) {
    log.debug("Controller: remove user with id={} from game with id={}", userId, gameId);
    iUserService.removeUserFromGame(userId, gameId);
  }

  @Override
  public void deleteUser(Long userId) {
    log.debug("Controller: remove user with id={}", userId);
    iUserService.deleteUser(userId);
  }



}
