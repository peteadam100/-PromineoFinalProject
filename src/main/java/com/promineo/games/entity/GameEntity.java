
package com.promineo.games.entity;

import java.sql.Timestamp;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameEntity {
  private Long gamePk;
  @NotNull
  @Length(max = 255) 
  private String gameName;
  @Length(max = 65535)
  private String gameDescription;
  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
  private Timestamp availableDateTime;
  private Timestamp lockDateTime;
  private List<QuestionEntity> questions;
  
  @JsonIgnore
  public Long getGamePk(){
    return gamePk;
  }
  
  List<AnswerEntity> getCorrectAnswers(){
    return null;
  }

}
