/**
 * 
 */
package com.promineo.games.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineo.games.dao.GamesDao.GameRowMapper;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class UserDao implements IUserDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;


  /*
   * ===============================================================================================
   * FETCH OPERATIONS
   * ===============================================================================================
   */
  @Override
  public List<UserEntity> fetchUsers(Long userId) {
    // log.debug("DAO: fetch all games");

    String sql = "SELECT * FROM users WHERE "; // WHERE game_pk = 2";
    Map<String, Long> params = new HashMap<>();


    if (userId == null) {
      sql += "1=1";
    } else {
      sql += "user_pk = :userId ";
      params.put("userId", userId);
    }

    List<UserEntity> users = jdbcTemplate.query(sql, params, new UserRowMapper());

    // log.debug("games returned: " + games.toString());

    return users;
  }
  
  @Override
  public List<GameEntity> fetchGamesForUserById(Long userId) {
    // log.debug("DAO: fetch all games");

    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM user_games ug "
        +   "LEFT JOIN games g ON ug.game_pk = g.game_pk "
        + "WHERE user_pk = :userPk"
        ;
    
    //@formatter:on
    
    Map<String, Long> params = new HashMap<>();
    params.put("userPk", userId);

    List<GameEntity> games = jdbcTemplate.query(sql, params, new UsersForGameRowMapper());

//    log.debug("games returned: " + games.toString());

    return games;
  }
  
  @Override
  public List<UserEntity> fetchUsersForGameById(Long gameId) {
    // log.debug("DAO: fetch all games");

    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM user_games ug "
        +   "LEFT JOIN users u ON ug.user_pk = u.user_pk "
        + "WHERE game_pk = :gamePk"
        ;
    
    //@formatter:on
    
    Map<String, Long> params = new HashMap<>();
    params.put("gamePk", gameId);

    List<UserEntity> users = jdbcTemplate.query(sql, params, new GamesForUserRowMapper());

//    log.debug("games returned: " + games.toString());

    return users;
  }


  /*
   * ===============================================================================================
   * UPDATE OPERATIONS
   * ===============================================================================================
   */
  public boolean updateUser(UserEntity user, Long userId) {
  //@formatter:off
    String sql = ""
        + "UPDATE users "
        + "SET "
        +   "first_name = :firstName, "
        +   "last_name = :lastName, "
        +   "username = :username "
        + "WHERE user_pk = :userPk"
        ;
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("userPk", userId);
    params.put("firstName", user.getFirstName());
    params.put("lastName", user.getLastName());
    params.put("username", user.getUsername());

    int isUpdated = jdbcTemplate.update(sql, params);

    if (isUpdated == 1) {
      return true;
    } else {
      return false;
    }
  }
  

  /*
   * ===============================================================================================
   * CREATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public UserEntity createUser(UserEntity userEntity) {
    //@formatter:off
    String sql = ""
        + "INSERT INTO users "
        +   "(first_name, last_name, username)"
        + "VALUES "
        +   "(:firstName, :lastName, :username) "
        ;
    //@formatter:on
    
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("firstName", userEntity.getFirstName());
    params.addValue("lastName", userEntity.getLastName());
    params.addValue("username", userEntity.getUsername());

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(sql, params, keyHolder);
    Long userPK = keyHolder.getKey().longValue();

//    return gamePK;
    return fetchUsers(userPK).get(0);
  }

  @Override
  public boolean joinUserToGame(Long userId, Long gameId) {
    //@formatter:off
    String sql = ""
        + "INSERT INTO user_games "
        +   "(user_pk, game_pk) "
        + "VALUES "
        +   "(:userPk, :gamePk) "
        ;
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("userPk", userId);
    params.put("gamePk", gameId);

    int isCreated = jdbcTemplate.update(sql, params);

    if (isCreated == 1) {
      return true;
    } else {
      return false;
    }
  }


  /*
   * ===============================================================================================
   * DELETE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public boolean removeUserFromGame(Long userId, Long gameId) {
    String sql = "DELETE FROM user_games WHERE user_pk = :userPk AND game_pk = :gamePk";

    Map<String, Object> params = new HashMap<>();
    params.put("userPk", userId);
    params.put("gamePk", gameId);

    int isDeleted = jdbcTemplate.update(sql, params);

    if (isDeleted == 1) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public boolean deleteUser(Long userId) {
    String sql = "DELETE FROM users WHERE user_pk = :userPk";

    Map<String, Object> params = new HashMap<>();
    params.put("userPk", userId);

    int isDeleted = jdbcTemplate.update(sql, params);

    if (isDeleted == 1) {
      return true;
    } else {
      return false;
    }
  }


  /*
   * ===============================================================================================
   * ===============================================================================================
   * ===============================================================================================
   * CLASSES FOR ROWMAPPER
   * ===============================================================================================
   * ===============================================================================================
   * ===============================================================================================
   */

  class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet rs, int row) throws SQLException {
    //@formatter:off
      UserEntity currentUser = UserEntity.builder()
          .userPk(rs.getLong("user_pk"))
          .firstName(rs.getString("first_name"))
          .LastName(rs.getString("last_name"))
          .username(rs.getString("username"))
          .build();
    //@formatter:on

      return currentUser;
    }

  }

  class UsersForGameRowMapper implements RowMapper<GameEntity> {

    @Override
    public GameEntity mapRow(ResultSet rs, int row) throws SQLException {
    //@formatter:off
      GameEntity currentGame = GameEntity.builder()
          .gamePk(rs.getLong("game_pk"))
          .gameName(rs.getString("game_name"))
          .gameDescription(rs.getString("game_description"))
          .availableDateTime(rs.getTimestamp("available_date_time"))
          .lockDateTime(rs.getTimestamp("lock_date_time"))
          .build();
    //@formatter:on

      return currentGame;
    }

  }

  class GamesForUserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet rs, int row) throws SQLException {
    //@formatter:off
      UserEntity currentGame = UserEntity.builder()
          .userPk(rs.getLong("user_pk"))
          .firstName(rs.getString("first_name"))
          .LastName(rs.getString("last_name"))
          .username(rs.getString("username"))
          .build();
    //@formatter:on

      return currentGame;
    }

  }

  
  
  

  // JUST IGNORE THIS. JUST MAKING ADDING LOGGIN LESS MESSY IN ECLIPSE.
  @SuppressWarnings("unused")
  private void logNothing() {
    log.debug("just here to have import not through unused error");
  }
  
}
