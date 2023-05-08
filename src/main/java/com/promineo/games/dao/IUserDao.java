/**
 * 
 */
package com.promineo.games.dao;

import java.util.List;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.UserEntity;

/**
 * @author Adam
 *
 */
public interface IUserDao {
  public List<UserEntity> fetchUsers(Long userId);
  public List<GameEntity> fetchGamesForUserById(Long userId);
  public List<UserEntity> fetchUsersForGameById(Long userId);
  
  public boolean updateUser(UserEntity user, Long userId);
  
  public UserEntity createUser(UserEntity userEntity);
  public boolean joinUserToGame(Long userId, Long gameId);
  
  public boolean removeUserFromGame (Long userId, Long gameId);
  public boolean deleteUser(Long userId);
  
}

