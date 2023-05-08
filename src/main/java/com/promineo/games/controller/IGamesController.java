/**
 * 
 */
package com.promineo.games.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.games.entity.AnswerEntity;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.QuestionEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@Validated
// @RequestMapping("/games/update")
public interface IGamesController {
  /**
   * ================================================================================================
   * ==================================================================================================
   * Games section
   * ==================================================================================================
   * ==================================================================================================
   **/
  @RequestMapping(value = "/games", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Returns a list of games", 
      description = "Returns a map of all of the games with game pk and the name",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A map of games is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = List.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "The request parameters are invalid",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
//          @ApiResponse(
//              responseCode = "404", 
//              description = "No Jeeps were found with the input criteria",
//              content = @Content(mediaType = "application/json")
//          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  Map<Long, String> getAllGames();

  // ==================================================================================================

  @RequestMapping(value = "/games/{id}", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Returns a game", 
      description = "Returns a game along with the questions and answers",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A game is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GameEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      },
      parameters = {
          @Parameter(
              name = "id", 
              allowEmptyValue = false, 
              required = true, 
              description = "The integer of the game to return"
          )
      }  
  )
  //@formatter:on
  GameEntity getGameById(@PathVariable(value = "id") Long gameId);

  // ==================================================================================================

  @RequestMapping(value = "/games/add", method = RequestMethod.PUT)
  @ResponseStatus(code = HttpStatus.CREATED)
  //@formatter:off
  @Operation(
      summary = "DONE - Add a new game", 
      description = "Adds a new game to the database. Can add questions and answers as well, or "
          + "use the /update POST endpoint to update those later",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A game successfully added to the database",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GameEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }//,
//      parameters = {
//          @Parameter(
//              name = "gameID", 
//              allowEmptyValue = false, 
//              required = true, 
//              description = "The integer of the game to return"
//          )
//      }  
  )
  //@formatter:on
  GameEntity addGame(@RequestBody GameEntity game);

  // ==================================================================================================

  @RequestMapping(value = "/games/update/{gameId}", method = RequestMethod.POST)
  @ResponseStatus(code = HttpStatus.CREATED)
  //@formatter:off
  @Operation(
      summary = "DONE - Update an existing game", 
      description = "Updates and existing game in the database. This can be adding "
          + "questions and/or answers or just updating information about the game",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A game successfully added to the database",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GameEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }
  )
  //@formatter:on
  GameEntity updateGame(@Valid @RequestBody GameEntity gameEntity,
      @PathVariable(value = "gameId") Long gameId);

  // ==================================================================================================

  @RequestMapping(value = "/games/delete/{gameId}", method = RequestMethod.DELETE)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Remove an existing game", 
      description = "Delete a game from the database",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A game successfully added to the database",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GameEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  void deleteGame(@PathVariable(value = "gameId") Long gameId);

  /**
   * ================================================================================================
   * ==================================================================================================
   * Questions section
   * ==================================================================================================
   * ==================================================================================================
   **/

  @RequestMapping(value = "/games/questions/{gameId}", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Get all questions for a game", 
      description = "Get all questions for a given game",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Returns a list of all Questions objects from the database for a given game",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GameEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  List<QuestionEntity> getAllQuestionsForGame(@PathVariable(value = "gameId") Long gameId);

  // ==================================================================================================


  @RequestMapping(value = "/games/question/{questionId}", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Get specific question", 
      description = "Get a Question object",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Returns a Questions object from the database for a given question ID",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = QuestionEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  QuestionEntity getQuestionById(@PathVariable(value = "questionId") Long questionId);

  // ==================================================================================================

  @RequestMapping(value = "/games/questions/add", method = RequestMethod.PUT)
  @ResponseStatus(code = HttpStatus.CREATED)
  //@formatter:off
  @Operation(
      summary = "DONE - Add a question to a game", 
      description = "Add a list of questions to the database. Must provide the game PK",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "Question successfully added to the database",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = QuestionEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  List<QuestionEntity> addQuestion(@RequestBody List<QuestionEntity> questions);

  // ==================================================================================================

  @RequestMapping(value = "/games/questions/update/{questionId}", method = RequestMethod.POST)
  @ResponseStatus(code = HttpStatus.CREATED)
  //@formatter:off
  @Operation(
      summary = "DONE - Update a question", 
      description = "Update a specific question. This will update the question only, not the "
          + "underlying answers. Must provide the question order and the text of the question",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "Question successfully updated",
              content = @Content(
                  mediaType = "application/json",
                  schema =  @Schema(implementation = QuestionEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      },
      parameters = {
          @Parameter(
              name = "questionOrder", 
              allowEmptyValue = false, 
              required = true, 
              description = "The order the question appears in the question"
          ),
          @Parameter(
              name = "questionText", 
              allowEmptyValue = false, 
              required = true,
              description = "The text of the question"
          )
      }  
  )
 
  QuestionEntity updateQuestion(
      @PathVariable(value = "questionId") Long questionId,
      @RequestParam(value = "questionOrder", required = true) Integer questionOrder,
      @RequestParam(value = "questionText", required = true) String questionText
//       @RequestBody QuestionEntity questionEntity
  );
//      @RequestBody Map<String, Object> questionInfo);
  //@formatter:on

  // ==================================================================================================

  @RequestMapping(value = "/games/questions/delete/{questionId}", method = RequestMethod.DELETE)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Delete a question", 
      description = "Remove a question from the database. This will remove all associated "
          + "questions and answers as well",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Question successfully removed",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = QuestionEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  void deleteQuestion(@PathVariable(value = "questionId") Long questionId);

  // //
  // ==================================================================================================
  //
  // @RequestMapping(value = "/games/questions/addMultipleQuestions", method = RequestMethod.PUT)
  // @ResponseStatus(code = HttpStatus.CREATED)
//  //@formatter:off
//  @Operation(
//      summary = "Add possible answers to a question - May remove this one. This isn't super helpful. Could add one question multiple times....", 
//      description = "",
//      responses = {
//          @ApiResponse(
//              responseCode = "201", 
//              description = "Answers successfully added to the database",
//              content = @Content(
//                  mediaType = "application/json",
//                  schema = @Schema(implementation = GameEntity.class)
//              )
//          ), // OK - Success
//          @ApiResponse(
//              responseCode = "400",
//              description = "Invalid request paramaters",
//              content = @Content(mediaType = "application/json")
//          ), // Illegal request
//          @ApiResponse(
//              responseCode = "404", 
//              description = "The game id was not found in the database",
//              content = @Content(mediaType = "application/json")
//          ), // Not found
//          @ApiResponse(
//              responseCode = "500", 
//              description = "An unplanned error occurred",
//              content = @Content(mediaType = "application/json")
//          ), // Unplanned exception
//      }  
//  )
//  //@formatter:on
  // GameEntity addQuestions(@PathVariable(value = "questionId") Integer gameId);

  
  
  /**
   * ================================================================================================
   * ==================================================================================================
   * Answers section
   * ==================================================================================================
   * ==================================================================================================
   **/
  @RequestMapping(value = "/games/answers/{questionId}", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Get all answers for a question", 
      description = "Get all answers for a given question",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Returns a list of all Answer objects from the database for a given question",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = GameEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  List<AnswerEntity> getAllAnswersForQuestion(@PathVariable(value = "questionId") Long questionId);
  
//==================================================================================================

 @RequestMapping(value = "/games/answers/add", method = RequestMethod.PUT)
 @ResponseStatus(code = HttpStatus.CREATED)
 //@formatter:off
 @Operation(
     summary = "DONE - Add answers to a question", 
     description = "Add a list of questions to the database. Must provide the game PK",
     responses = {
         @ApiResponse(
             responseCode = "201", 
             description = "Question successfully added to the database",
             content = @Content(
                 mediaType = "application/json",
                 schema = @Schema(implementation = AnswerEntity.class)
             )
         ), // OK - Success
         @ApiResponse(
             responseCode = "400",
             description = "Invalid request paramaters",
             content = @Content(mediaType = "application/json")
         ), // Illegal request
         @ApiResponse(
             responseCode = "404", 
             description = "The game id was not found in the database",
             content = @Content(mediaType = "application/json")
         ), // Not found
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred",
             content = @Content(mediaType = "application/json")
         ), // Unplanned exception
     }  
 )
 List<AnswerEntity> addAnswers(
     @RequestBody List<AnswerEntity> answers
 );
 //@formatter:on
 
//==================================================================================================

  @RequestMapping(value = "/games/answers/update/{answerId}", method = RequestMethod.POST)
  @ResponseStatus(code = HttpStatus.CREATED)
  //@formatter:off
  @Operation(
      summary = "DONE - Update an answer", 
      description = "Update a single given answer. must provide the answerOrder, answer, and correctAnswer",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "Answer successfully updated in the database",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AnswerEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  AnswerEntity updateAnswer(
      @PathVariable(value = "answerId") Long answerId,
      @RequestBody AnswerEntity answer 
  );
  //@formatter:on

  // ==================================================================================================

  @RequestMapping(value = "/games/answers/delete/{answerId}", method = RequestMethod.DELETE)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Delete an answer", 
      description = "Remove an answer from the database",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Answer successfully removed",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AnswerEntity.class)
              )
          ), // OK - Success
          @ApiResponse(
              responseCode = "400",
              description = "Invalid request paramaters",
              content = @Content(mediaType = "application/json")
          ), // Illegal request
          @ApiResponse(
              responseCode = "404", 
              description = "The game id was not found in the database",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }  
  )
  //@formatter:on
  void deleteAnswer(@PathVariable(value = "answerId") Long answerId);
}


