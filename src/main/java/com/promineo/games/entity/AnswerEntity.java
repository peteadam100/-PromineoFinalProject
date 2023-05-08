
package com.promineo.games.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AnswerEntity {
  private Long answerPk;
  private Long questionPk;
  private int answerOrder;
  private String answer;
  private boolean isCorrectAnswer;
  private String specialNotes;
  
  @JsonIgnore
  public Long getAnswerPk() {
    return answerPk;
  }
}
