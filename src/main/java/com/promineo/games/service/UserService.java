/**
 * 
 */
package com.promineo.games.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineo.games.dao.IUserDao;
import com.promineo.games.entity.AnswerEntity;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UserService implements IUserService {

  /*
   * ===============================================================================================
   * FETCH OPERATIONS
   * ===============================================================================================
   */
  @Autowired
  private IUserDao iUserDao;

  @Override
  public List<UserEntity> fetchAllUsers() {
    log.debug("Service: fetch all games");

    return iUserDao.fetchUsers(null);
  }

  @Override
  public Optional<UserEntity> fetchUserById(Long userId) {
    log.debug("Service: fetch user with id: {}", userId);
    List<UserEntity> users = iUserDao.fetchUsers(userId);

    if (users.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.ofNullable(users.get(0));
    }
  }
  
  @Override
  public Map<Long, String> fetchGamesForUserById(Long userId) {
    log.debug("Service: fetch games that user with id={} has joined", userId);
    Map<Long, String> games = new HashMap<>();
    
    List<GameEntity> gameEntities = iUserDao.fetchGamesForUserById(userId);

    for (GameEntity game : gameEntities) {
      games.put(game.getGamePk(), game.getGameName());
    }
    return games;
  }  
  
  @Override
  public Map<Long, String> fetchUsersForGameById(Long gameId) {
    log.debug("Service: fetch users that have joined game with id={}", gameId);
    Map<Long, String> users = new HashMap<>();
    
    List<UserEntity> userEntities = iUserDao.fetchUsersForGameById(gameId);

    for (UserEntity user : userEntities) {
      users.put(user.getUserPk(), user.getFirstName() + " " + user.getLastName() + " : " + user.getUsername());
    }
    return users;
  } 
  
  
  
  /*
   * ===============================================================================================
   * UPDATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public UserEntity updateUser(UserEntity user, Long userId) {
    log.debug("Service: update User with id: {}", userId);
    UserEntity oldUser = iUserDao.fetchUsers(userId).get(0);
    
    user.setUserPk(oldUser.getUserPk());
    
    if (iUserDao.updateUser(user, userId)) {
      //successful. Can add error trapping here
    } 
    
    UserEntity newUser = iUserDao.fetchUsers(userId).get(0);
    
    return newUser;
  }
  
  
  /*
   * ===============================================================================================
   * CREATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public UserEntity addUser(UserEntity user) {
    log.debug("Service: create user: {}", user);

    return iUserDao.createUser(user);
  }

  @Override
  public void joinUserToGame(Long userId, Long gameId) {
    log.debug("Service: add user with id={} to game with id={}", userId, gameId);

    iUserDao.joinUserToGame(userId, gameId);
  }
  
  /*
   * ===============================================================================================
   * DELETE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public void removeUserFromGame(Long userId, Long gameId) {
    log.debug("Service: remove user with id={} from game with id={}", userId, gameId);

    iUserDao.removeUserFromGame(userId, gameId);
  }

  @Override
  public void deleteUser(Long userId) {
    log.debug("Service: delete user with id={}", userId);

    iUserDao.deleteUser(userId);
  }

}
