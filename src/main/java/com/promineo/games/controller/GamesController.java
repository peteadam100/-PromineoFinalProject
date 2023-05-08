/**
 * 
 */
package com.promineo.games.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.games.entity.AnswerEntity;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.QuestionEntity;
import com.promineo.games.service.IGamesService;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class GamesController implements IGamesController {
  @Autowired
  private IGamesService iGameService;


  /*
   * ===============================================================================================
   * CREATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public GameEntity addGame(GameEntity game) {
    log.debug("Controller: add game: {}", game);
    return iGameService.createGame(game);
  }

  @Override
  public List<QuestionEntity> addQuestion(List<QuestionEntity> questions) {
    log.debug("Controller: add Questions: {}", questions);
    return iGameService.createQuestion(questions);
  }

  @Override
  public List<AnswerEntity> addAnswers(List<AnswerEntity> answers) {
    return iGameService.createAnswers(answers);
  }


  /*
   * ===============================================================================================
   * READ OPERATIONS
   * ===============================================================================================
   */
  @Override
  public Map<Long, String> getAllGames() {
    log.debug("Controller: Request for list of all existing games");
    return iGameService.fetchAllGames();
  }

  @Override
  public GameEntity getGameById(Long gameId) {
    log.debug("Controller: Request for game id: {}", gameId);
    return iGameService.fetchGameById(gameId)
        .orElseThrow(() -> new NoSuchElementException("Game with ID=" + gameId + " was not found"));
  }

  @Override
  public List<QuestionEntity> getAllQuestionsForGame(Long gameId) {
    log.debug("Controller: Request for questions for game with id: {}", gameId);
    List<QuestionEntity> questions = iGameService.fetchAllQuestionsByGameId(gameId);
    if (questions.isEmpty()) {
      throw new NoSuchElementException("Game with ID=" + gameId + " was not found");
    } else {
      return questions;
    }
  }

  @Override
  public QuestionEntity getQuestionById(Long questionId) {
    log.debug("Controller: Request for question id: {}", questionId);
    return iGameService.fetchQuestionById(questionId).orElseThrow(
        () -> new NoSuchElementException("Question with ID=" + questionId + " was not found"));
  }
  
  @Override
  public List<AnswerEntity> getAllAnswersForQuestion(Long questionId) {
    log.debug("Controller: Request for question id: {}", questionId);
    List<AnswerEntity> answers = iGameService.fetchAllAnswersByQuestionId(questionId);
    
    if (answers.isEmpty()) {
      throw new NoSuchElementException("Game with ID=" + questionId + " was not found");
    } else {
      return answers;
    }
  }


  /*
   * ===============================================================================================
   * UPDATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public GameEntity updateGame(GameEntity gameEntity, Long gameId) {
    log.debug("Controller: Request to update game: {}", gameId);
    // log.debug("Controller: Game={}", gameEntity.toString());
    return iGameService.updateGameById(gameId, gameEntity);
  }

  @Override
  public QuestionEntity updateQuestion(Long questionId, Integer questionOrder,
      String questionText) {
    log.debug("Controller: update question with ID:{}", questionId);
    log.debug("Controller: new question={}", questionText);

    return iGameService.updateQuestionById(questionId, questionOrder, questionText);
  }

  @Override
  public AnswerEntity updateAnswer(Long answerId, AnswerEntity answer) {
    log.debug("Controller: update answer with ID:{}", answerId);
    log.debug("Controller: new answer={}", answer);
    
    return iGameService.updateAnswerById(answerId, answer);
  }


  /*
   * ===============================================================================================
   * DELETE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public void deleteGame(Long gameId) {
    log.debug("Controller: remove game with id {}", gameId);
    iGameService.deleteGameById(gameId);
  }

  @Override
  public void deleteQuestion(Long questionId) {
    log.debug("Controller: remove game with id {}", questionId);
    iGameService.deleteQuestionById(questionId);
  }

  @Override
  public void deleteAnswer(Long answerId) {
    log.debug("Controller: remove answer with id {}", answerId);
    iGameService.deleteAnswerById(answerId);
  }



  //
  //
  //
  //
  // =================================================================================

  // @Override
  // public GameEntity addQuestions(Integer gameId) {
  // // TODO Auto-generated method stub
  // return null;
  // }



}
