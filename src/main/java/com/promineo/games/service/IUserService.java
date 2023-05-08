/**
 * 
 */
package com.promineo.games.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.promineo.games.entity.UserEntity;

/**
 * @author Adam
 *
 */
public interface IUserService {
  public List<UserEntity> fetchAllUsers();
  public Optional<UserEntity> fetchUserById(Long userId);
  public Map<Long, String> fetchGamesForUserById(Long userId);
  public Map<Long, String> fetchUsersForGameById(Long userId);
  
  public UserEntity addUser(UserEntity user);
  public void joinUserToGame(Long userId, Long gameId);
  
  public UserEntity updateUser(UserEntity user, Long userId);
  
  public void removeUserFromGame(Long userId, Long gameId);
  public void deleteUser(Long userId);

}
