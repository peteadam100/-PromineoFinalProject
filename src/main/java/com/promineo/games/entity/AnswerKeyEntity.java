/**
 * 
 */
package com.promineo.games.entity;

import java.util.List;
import lombok.Data;

@Data
public class AnswerKeyEntity {
  private List<AnswerEntity> correctAnswers;
}


//      DECIDED THAT THIS CLASS/ENTITY IS PROBABLY NOT THE BEST WAY TO DO THIS....
//      MOVED THE ABILITY TO GET ANSWER KEYS TO THE GameEntity IN A METHOD