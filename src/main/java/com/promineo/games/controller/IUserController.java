/**
 * 
 */
package com.promineo.games.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.games.entity.GameEntity;
import com.promineo.games.entity.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Adam
 *
 */
public interface IUserController {
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Returns a list of all users", 
      description = "Returns a list of all of the users",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of users is returned",
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
  List<UserEntity> getAllUsers();

//==================================================================================================
  
  @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Returns a user", 
      description = "Returns a JSON object of the user",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of users is returned",
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
  UserEntity getUser(@PathVariable(value = "userId") Long userId);
  
//==================================================================================================
  
  @RequestMapping(value = "/user_games/games_that_user_joined{userId}", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Returns games for user", 
      description = "Returns a list of the games that the user has joined",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of games is returned. This is game_pk: game_name",
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
  Map<Long, String> getGamesForUser(@PathVariable(value = "userId") Long userId);

//==================================================================================================
  
  @RequestMapping(value = "/users_games/users_that_joined_game/{gameId}", method = RequestMethod.GET)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Returns users for a game", 
      description = "Returns a list of the users that the have joined a game",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of users is returned. This is user_pk: first_name Last_name",
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
  Map<Long, String> getUsersForGame(@PathVariable(value = "gameId") Long gameId);
  
//==================================================================================================

 @RequestMapping(value = "/users/update/{userId}", method = RequestMethod.POST)
 @ResponseStatus(code = HttpStatus.CREATED)
 //@formatter:off
 @Operation(
     summary = "DONE - Update an existing user", 
     description = "Updates and existing user in the database",
     responses = {
         @ApiResponse(
             responseCode = "201", 
             description = "A user successfully updated in the database",
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
             description = "The user id was not found in the database",
             content = @Content(mediaType = "application/json")
         ), // Not found
         @ApiResponse(
             responseCode = "500", 
             description = "An unplanned error occurred",
             content = @Content(mediaType = "application/json")
         ), // Unplanned exception
     }
 )
 UserEntity updateUser(
     @Valid @RequestBody UserEntity userEntity,
     @PathVariable(value = "userId") Long userId
);
 //@formatter:on

//==================================================================================================
  
  @RequestMapping(value = "/users/add", method = RequestMethod.PUT)
  @ResponseStatus(code = HttpStatus.CREATED)
  //@formatter:off
  @Operation(
      summary = "DONE - Add a new user", 
      description = "Adds a user to the database",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "A user is successfully added to the database",
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
  UserEntity addUser(@RequestBody UserEntity user);

//==================================================================================================

  @RequestMapping(value = "/users_game/join", method = RequestMethod.PUT)
  @ResponseStatus(code = HttpStatus.CREATED)
  //@formatter:off
  @Operation(
      summary = "DONE - Join a user to a game", 
      description = "Add a user to a game in the join table",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A user is successfully inserted in the join table with the key of the game",
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
          @ApiResponse(
              responseCode = "404", 
              description = "No user game combination were found with the input criteria",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      } 
  )
  void joinGame(
      @RequestParam(value = "userId", required = true) Long userId,
      @RequestParam(value = "gameId", required = true) Long gameId
  );
  //@formatter:on

//==================================================================================================

  @RequestMapping(value = "/users_game/leave", method = RequestMethod.DELETE)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Remove a User from a game", 
      description = "A user is removed from a game",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A user is successfully unassociated with a game",
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
          @ApiResponse(
              responseCode = "404", 
              description = "No user game combination were found with the input criteria",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }
  )
  void leaveGame(
      @RequestParam(value = "userId", required = true) Long userId,
      @RequestParam(value = "gameId", required = true) Long gameId
  );
  //@formatter:on
  
//==================================================================================================

  @RequestMapping(value = "/users/delete/{userId}", method = RequestMethod.DELETE)
  @ResponseStatus(code = HttpStatus.OK)
  //@formatter:off
  @Operation(
      summary = "DONE - Remove a User", 
      description = "Delete a user",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A user is successfully removed",
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
          @ApiResponse(
              responseCode = "404", 
              description = "No user game combination were found with the input criteria",
              content = @Content(mediaType = "application/json")
          ), // Not found
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json")
          ), // Unplanned exception
      }
  )
  void deleteUser(@PathVariable(value = "userId") Long userId);
  //@formatter:on

}
