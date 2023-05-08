
package com.promineo.games.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserEntity {
  private Long userPk;
  private String firstName;
  private String LastName;
  private String username;
  
  @JsonIgnore
  public Long getUserPk(){
    return userPk;
  }
}
