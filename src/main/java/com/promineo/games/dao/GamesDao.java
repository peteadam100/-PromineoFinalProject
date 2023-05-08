
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
import com.promineo.games.entity.AnswerEntity;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.QuestionEntity;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GamesDao implements IGamesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  /*
   * ===============================================================================================
   * FETCH OPERATIONS
   * ===============================================================================================
   */
  public List<GameEntity> fetchGames(Long gameId) {
//    log.debug("DAO: fetch all games");

    String sql = "SELECT * FROM games WHERE "; // WHERE game_pk = 2";
    Map<String, Long> params = new HashMap<>();


    if (gameId == null) {
      sql += "1=1";
    } else {
      sql += "game_pk = :gameId ";
      params.put("gameId", gameId);
    }

    List<GameEntity> games = jdbcTemplate.query(sql, params, new GameRowMapper());

//    log.debug("games returned: " + games.toString());

    return games;

  }

  @Override
  public List<QuestionEntity> fetchQuestionsForGame(Long gameId) {
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM questions "
        + "WHERE game_pk = :gamePk"
        ;
    //@formatter:on

    Map<String, Long> params = new HashMap<>();
    params.put("gamePk", gameId);

    List<QuestionEntity> questions = jdbcTemplate.query(sql, params, new QuestionRowMapper());

//    log.debug("question 1 : {}", questions.get(0));
    return questions;
  }
  
  @Override
  public List<QuestionEntity> fetchQuestion(Long questionId) {
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM questions "
        + "WHERE question_pk = :gamePk"
        ;
    //@formatter:on

    Map<String, Long> params = new HashMap<>();
    params.put("gamePk", questionId);

    List<QuestionEntity> questions = jdbcTemplate.query(sql, params, new QuestionRowMapper());

//    log.debug("question 1 : {}", questions.get(0));
    return questions;
  }

  @Override
  public List<AnswerEntity> fetchAnswersForQuestion(Long questionId) {
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM answers "
        + "WHERE question_pk = :questionPk"
        ;
    //@formatter:on

    Map<String, Long> params = new HashMap<>();
    params.put("questionPk", questionId);

    List<AnswerEntity> answers = jdbcTemplate.query(sql, params, new AnswerRowMapper());

    return answers;
  }
  
  public List<AnswerEntity> fetchAnswer(Long answerId){
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM answers "
        + "WHERE answers_pk = :questionPk"
        ;
    //@formatter:on

    Map<String, Long> params = new HashMap<>();
    params.put("questionPk", answerId);

    List<AnswerEntity> answer = jdbcTemplate.query(sql, params, new AnswerRowMapper());

    return answer;
  }

  /*
   * ===============================================================================================
   * UPDATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public boolean updateGameById(GameEntity game, Long gameId) {
//    log.debug("DAO: trying to update id: {}", gameId);
    //@formatter:off
    String sql = ""
        + "UPDATE games "
        + "SET "
        +   "game_name = :gameName, "
        +   "game_description = :gameDescription, "
        +   "available_date_time = :availableDateTime, "
        +   "lock_date_time = :lockDateTime "
        + "WHERE game_pk = :gamePk "
        ;
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("gamePk", gameId);
    params.put("gameName", game.getGameName());
    params.put("gameDescription", game.getGameDescription());
    params.put("availableDateTime", game.getAvailableDateTime());
    params.put("lockDateTime", game.getLockDateTime());

    int isUpdated = jdbcTemplate.update(sql, params);

    if (isUpdated == 1) {
      return true;
    } else {
      return false;
    }

    // return fetchGames(gameId).get(0);
  }

  @Override
  public boolean updateQuestionById(QuestionEntity question, Long questionId) {
//    log.debug("DAO: trying to update id: {}", questionId);
    //@formatter:off
    String sql = ""
        + "UPDATE questions "
        + "SET "
        +   "game_pk = :gamePk, "
        +   "question_order = :questionOrder, "
        +   "question_text = :questionText "
        + "WHERE question_pk = :questionPk "
        ; 
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("gamePk", question.getGamePk());
    params.put("questionOrder", question.getQuestionOrder());
    params.put("questionText", question.getQuestionText());
    params.put("questionPk", questionId);
//    log.debug(params.toString());

    int isUpdated = jdbcTemplate.update(sql, params);

    if (isUpdated == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean updateAnswerById(AnswerEntity answer, Long answerId) {
//    log.debug("DAO: trying to update id: {}", answerId);
    //@formatter:off
    String sql = ""
        + "UPDATE answers "
        + "SET "
        +   "question_pk = :questionPk, "
        +   "answer_order = :answerOrder, "
        +   "answer = :answer, "
        +   "is_correct_answer = :isCorrectAnswer, "
        +   "special_notes = :specialNotes "
        + "WHERE answers_pk = :answerPk"
        ;
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("questionPk", answer.getQuestionPk());
    params.put("answerOrder", answer.getAnswerOrder());
    params.put("answer", answer.getAnswer());
    params.put("isCorrectAnswer", answer.isCorrectAnswer());
    params.put("specialNotes", answer.getSpecialNotes());
    params.put("answerPk", answerId);

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
  public GameEntity createGame(GameEntity game) {
    //@formatter:off
    String sql = ""
        + "INSERT INTO games "
        +   "(game_name, game_description, available_date_time, lock_date_time) "
        + "VALUES "
        +   "(:gameName, :gameDescriptions, :availableDateTime, :lockDateTime)"
        ;
    //@formatter:on

    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("gameName", game.getGameName());
    params.addValue("gameDescriptions", game.getGameDescription());
    params.addValue("availableDateTime", game.getAvailableDateTime());
    params.addValue("lockDateTime", game.getLockDateTime());

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(sql, params, keyHolder);
    Long gamePK = keyHolder.getKey().longValue();

//    return gamePK;
    return fetchGames(gamePK).get(0);
  }

  public QuestionEntity createQuestion(QuestionEntity question) {
    //@formatter:off
    String sql = "INSERT INTO questions "
        +   "(game_pk, question_order, question_text) "
        + "VALUES "
        +   "(:gamePk, :questionOrder, :questionText)"
        ;
    //@formatter:on

    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("gamePk", question.getGamePk());
    params.addValue("questionOrder", question.getQuestionOrder());
    params.addValue("questionText", question.getQuestionText());

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(sql, params, keyHolder);
    Long questionPK = keyHolder.getKey().longValue();

//    log.debug("new question id: {}", questionPK);
    return fetchQuestion(questionPK).get(0);
  }

  public AnswerEntity createAnswer(AnswerEntity answer) {
    //@formatter:off
    String sql = ""
        + "INSERT INTO answers "
        +   "(question_pk, answer_order, answer, is_correct_answer, special_notes) "
        + "VALUES "
        +   "(:questionPk, :answerOrder, :answer, :isCorrectAnswer, :specialNotes)"
        ;
    //@formatter:on

    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("questionPk", answer.getQuestionPk());
    params.addValue("answerOrder", answer.getAnswerOrder());
    params.addValue("answer", answer.getAnswer());
    params.addValue("isCorrectAnswer", answer.isCorrectAnswer());
    params.addValue("specialNotes", answer.getSpecialNotes());

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(sql, params, keyHolder);
    Long answerPK = keyHolder.getKey().longValue();
    
    return fetchAnswer(answerPK).get(0);
  }


  /*
   * ===============================================================================================
   * DELETE OPERATIONS
   * ===============================================================================================
   */
  public boolean deleteGameById(Long gameId) {
    String sql = "DELETE FROM games WHERE game_pk = :gamePk";

    Map<String, Object> params = new HashMap<>();
    params.put("gamePk", gameId);

    int isDeleted = jdbcTemplate.update(sql, params);

    if (isDeleted == 1) {
      return true;
    } else {
      return false;
    }
  }
  
  public boolean deleteQuestionById(Long questionId) {
    String sql = "DELETE FROM questions WHERE question_pk = :questionPk";

    Map<String, Object> params = new HashMap<>();
    params.put("questionPk", questionId);

    int isDeleted = jdbcTemplate.update(sql, params);

    if (isDeleted == 1) {
      return true;
    } else {
      return false;
    }
  }
  
  public boolean deleteAnswerById(Long answerId) {
    String sql = "DELETE FROM answers WHERE answers_pk = :questionPk";

    Map<String, Object> params = new HashMap<>();
    params.put("questionPk", answerId);

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

  class GameRowMapper implements RowMapper<GameEntity> {

    @Override
    public GameEntity mapRow(ResultSet rs, int row) throws SQLException {
    //@formatter:off
      GameEntity currentGame =  GameEntity.builder()
        .gamePk(rs.getLong("game_pk"))
        .gameName(rs.getString("game_name"))
        .gameDescription(rs.getString("game_description"))
        .availableDateTime(rs.getTimestamp("available_date_time"))
//        .availableDateTime(rs.getDate("available_date_time"))
        .lockDateTime(rs.getTimestamp("lock_date_time"))
        .build();
    //@formatter:on

      return currentGame;
    }

  }

  class QuestionRowMapper implements RowMapper<QuestionEntity> {

    @Override
    public QuestionEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
    //@formatter:off
      QuestionEntity currentQuestion=  QuestionEntity.builder()
        .questionPk(rs.getLong("question_pk"))
        .gamePk(rs.getLong("game_pk"))
        .questionOrder(rs.getInt("question_order"))
        .questionText(rs.getString("question_text"))
        .build();
    //@formatter:on

      return currentQuestion;
    }

  }

  class AnswerRowMapper implements RowMapper<AnswerEntity> {

    @Override
    public AnswerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
    //@formatter:off
      AnswerEntity currentAnswer=  AnswerEntity.builder()
        .answerPk(rs.getLong("answers_pk"))
        .questionPk(rs.getLong("question_pk"))
        .answerOrder(rs.getInt("answer_order"))
        .answer(rs.getString("answer"))
        .isCorrectAnswer(rs.getBoolean("is_correct_answer"))
        .specialNotes(rs.getString("special_notes"))
        .build();
    //@formatter:on

      return currentAnswer;
    }

  }

  
//  JUST IGNORE THIS. JUST MAKING ADDING LOGGIN LESS MESSY IN ECLIPSE.
  @SuppressWarnings("unused")
  private void logNothing() {
    log.debug("just here to have import not through unused error");
  }


}
