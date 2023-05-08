/**
 * 
 */
package com.promineo.games.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.promineo.games.entity.AnswerEntity;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.QuestionEntity;

/**
 * @author Adam
 *
 */
public interface IGamesService {
//  public Map<Integer, String> fetchGames();
  public Map<Long, String> fetchAllGames();
  public Optional<GameEntity> fetchGameById(Long gameId);
  public List<QuestionEntity> fetchAllQuestionsByGameId(Long gameId);
  public Optional<QuestionEntity> fetchQuestionById(Long questionId);
  public List<AnswerEntity> fetchAllAnswersByQuestionId(Long questionId);
  
  public GameEntity updateGameById(Long gamePk, GameEntity gameEntity);
  public QuestionEntity updateQuestionById(Long questionPk, Integer questionOrder, String questionText);
  public AnswerEntity updateAnswerById(Long answerPk, AnswerEntity answerEntity);
  
  public GameEntity createGame(GameEntity game);
  public List<QuestionEntity> createQuestion(List<QuestionEntity> questions);
  public List<AnswerEntity> createAnswers(List<AnswerEntity> answers);
  
  public void deleteGameById(Long gameId);
  public void deleteQuestionById(Long questionId);
  public void deleteAnswerById(Long answerId);
}

