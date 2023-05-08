/**
 * 
 */
package com.promineo.games.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class QuestionEntity {
  private Long questionPk;
  private Long gamePk;
  private int questionOrder;
  private String questionText;
  
//This is the only property excluded
  private List<AnswerEntity> answers;

  @JsonIgnore
  public Long getQuestionPk() {
    return questionPk;
  }

}

