/**
 * 
 */
package com.promineo.games.dao;

import java.util.List;
import com.promineo.games.entity.AnswerEntity;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.QuestionEntity;

public interface IGamesDao {
  public List<GameEntity> fetchGames(Long gameId);
  public List<QuestionEntity> fetchQuestionsForGame(Long gameId);
  public List<QuestionEntity> fetchQuestion(Long questionId);
  public List<AnswerEntity> fetchAnswersForQuestion(Long questionId);
  public List<AnswerEntity> fetchAnswer(Long answerId);
  
  public boolean updateGameById(GameEntity game, Long gameId);
  public boolean updateQuestionById(QuestionEntity question, Long questionId);
  public boolean updateAnswerById(AnswerEntity answer, Long answerId);
  
  public GameEntity createGame(GameEntity game);
  public QuestionEntity createQuestion(QuestionEntity question);
  public AnswerEntity createAnswer(AnswerEntity answer);
  
  public boolean deleteGameById(Long gameId);
  public boolean deleteQuestionById(Long questionId);
  public boolean deleteAnswerById(Long answerId);
}
