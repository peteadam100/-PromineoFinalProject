/**
 * 
 */
package com.promineo.games.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineo.games.dao.IGamesDao;
import com.promineo.games.entity.AnswerEntity;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.QuestionEntity;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GamesService implements IGamesService {
  @Autowired
  private IGamesDao iGamesDao;

  /*
   * ===============================================================================================
   * FETCH OPERATIONS
   * ===============================================================================================
   */
  @Override
  @Transactional(readOnly = true)
  public Map<Long, String> fetchAllGames() {
    log.debug("Service: fetch all games");

    Map<Long, String> games = new HashMap<>();

    List<GameEntity> gameEntities = iGamesDao.fetchGames(null);

    for (GameEntity game : gameEntities) {
      games.put(game.getGamePk(), game.getGameName());
    }
    return games;
  }

  @Override
  public Optional<GameEntity> fetchGameById(Long gameId) {
    log.debug("Service: fetch game with id: {}", gameId);
    List<GameEntity> games = iGamesDao.fetchGames(gameId);

    if (games.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.ofNullable(games.get(0));
    }
  }

  public List<QuestionEntity> fetchAllQuestionsByGameId(Long gameId) {
    List<QuestionEntity> questions = iGamesDao.fetchQuestionsForGame(gameId);
    return questions;
  }

  public Optional<QuestionEntity> fetchQuestionById(Long questionId) {
    List<QuestionEntity> questions = iGamesDao.fetchQuestion(questionId);

    if (questions.isEmpty()) {
      return Optional.empty();
    } else {
      return Optional.ofNullable(questions.get(0));
    }
  }
  
  public List<AnswerEntity> fetchAllAnswersByQuestionId(Long questionId) {
    List<AnswerEntity> answers = iGamesDao.fetchAnswersForQuestion(questionId);
    return answers;
  }


  /*
   * ===============================================================================================
   * UPDATE OPERATIONS
   * ===============================================================================================
   */
  @Override
  public GameEntity updateGameById(Long gamePk, GameEntity gameEntity) {
    log.debug("Service: update Game with id: {}", gamePk);
    if (iGamesDao.updateGameById(gameEntity, gamePk)) {
      if (gameEntity.getQuestions() != null) {
        for (QuestionEntity question : gameEntity.getQuestions()) {
          if (iGamesDao.updateQuestionById(question, question.getGamePk())) {
            if (question.getAnswers() != null) {
              for (AnswerEntity answer : question.getAnswers()) {
                if (iGamesDao.updateAnswerById(answer, answer.getAnswerPk())) {
                  // log.debug("successfully updated all the way through");
                  // return the whole gameEntity if all three levels are successful

                }
              }
            }
          }
        }
      }

    }
    GameEntity updatedGame = iGamesDao.fetchGames(gamePk).get(0);
    updatedGame.setQuestions(iGamesDao.fetchQuestionsForGame(gamePk));
    for (QuestionEntity question : updatedGame.getQuestions()) {
      question.setAnswers(iGamesDao.fetchAnswer(question.getQuestionPk()));
    }
    return updatedGame;
  }

  public QuestionEntity updateQuestionById(Long questionPk, Integer questionOrder, String questionText) {
    log.debug("Service: update Question with id: {}", questionPk);
//    questionEntity.setGamePk(iGamesDao.fetchQuestion(questionPk).get(0).getGamePk());
    
    QuestionEntity oldQuestion = iGamesDao.fetchQuestion(questionPk).get(0);

    //@formatter:off
    QuestionEntity newQuestion = QuestionEntity.builder()
      .gamePk(oldQuestion.getGamePk())
      .questionOrder(questionOrder)
      .questionText(questionText)
      .build();
    //@formatter:on
    
    if (iGamesDao.updateQuestionById(newQuestion, questionPk)) {
      newQuestion = iGamesDao.fetchQuestion(questionPk).get(0);
    } 
    
    return newQuestion;
  }
  
  public AnswerEntity updateAnswerById(Long answerPk, AnswerEntity answerEntity){
    log.debug("Service: update Question with id: {}", answerPk);
    AnswerEntity oldAnswer = iGamesDao.fetchAnswer(answerPk).get(0);
    
    answerEntity.setQuestionPk(oldAnswer.getQuestionPk());
    
    if (iGamesDao.updateAnswerById(answerEntity, answerPk)) {
      //successful. Can add error trapping here
    } 
    
    AnswerEntity newAnswer = iGamesDao.fetchAnswer(answerPk).get(0);
    
    return newAnswer;
  }

  /*
   * ===============================================================================================
   * CREATE OPERATIONS
   * ===============================================================================================
   */
  public GameEntity createGame(GameEntity game) {
    log.debug("Service: create game: {}", game);
    List<QuestionEntity> questions = new ArrayList<>();

    GameEntity newGame = iGamesDao.createGame(game);
    log.debug("new Game: {}", game);
    if (game.getQuestions() != null) {
      for (QuestionEntity question : game.getQuestions()) {
        question.setGamePk(newGame.getGamePk());
        List<AnswerEntity> answers = new ArrayList<>();
        log.debug("new question: {}", question);
        log.debug("game Id: {}", newGame.getGamePk());
        log.debug("gamePk: {}", question.getGamePk());
        QuestionEntity newQuestion = iGamesDao.createQuestion(question);
        log.debug("question entity created: {}", newQuestion);
        if (question.getAnswers() != null) {
          for (AnswerEntity answer : question.getAnswers()) {
            answer.setQuestionPk(newQuestion.getQuestionPk());
            log.debug("should create the answer: {}", answer);
            answers.add(iGamesDao.createAnswer(answer));
          }
        }
        newQuestion.setAnswers(answers);
        questions.add(newQuestion);
      }
    }
    newGame.setQuestions(questions);

    return newGame;
  }
  
  public List<AnswerEntity> createAnswers(List<AnswerEntity> answers){
    log.debug("Service: create answers: {}", answers);
    List<AnswerEntity> newAnswers = new ArrayList<>();
    
    for(AnswerEntity answer : answers) {
      newAnswers.add(iGamesDao.createAnswer(answer));
    }
    
    return newAnswers;
  }

  public List<QuestionEntity> createQuestion(List<QuestionEntity> questions) {
    List<QuestionEntity> returnedQuestions = new ArrayList<>();
    for (QuestionEntity question : questions) {
      returnedQuestions.add(iGamesDao.createQuestion(question));
    }
    return returnedQuestions;
  }

  /*
   * ===============================================================================================
   * DELETE OPERATIONS
   * ===============================================================================================
   */
  public void deleteGameById(Long gameId) {
    boolean isDeleted = iGamesDao.deleteGameById(gameId);
    if (!isDeleted) {
      String msg = String.format("No game found with ID={}", gameId);
      throw new NoSuchElementException(msg);
    } else {
      log.debug("Service: deleted game with ID={}", gameId);
    }
  }
  
  public void deleteQuestionById(Long questionId) {
    boolean isDeleted = iGamesDao.deleteQuestionById(questionId);
    if (!isDeleted) {
      String msg = String.format("No game found with ID={}", questionId);
      throw new NoSuchElementException(msg);
    } else {
      log.debug("Service: deleted game with ID={}", questionId);
    }
  }
  
  public void deleteAnswerById(Long answerId) {
    boolean isDeleted = iGamesDao.deleteAnswerById(answerId);
    if (!isDeleted) {
      String msg = String.format("No game found with ID={}", answerId);
      throw new NoSuchElementException(msg);
    } else {
      log.debug("Service: deleted game with ID={}", answerId);
    }
  }

}
