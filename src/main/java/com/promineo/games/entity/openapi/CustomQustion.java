/**
 * 
 */
package com.promineo.games.entity.openapi;

import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

@Configuration
//@OpenAPIDefinition
public class CustomQustion {
  @Bean

  public OpenAPI customOpenAPI() {
    Schema questionSchema = new Schema<Map<String, Object>>()
        .addProperties("questionText", new StringSchema().example("some question here"))
        .addProperties("password",new StringSchema().example("P4SSW0RD"))
        .addProperties("image", new StringSchema().example("https://robohash.org/John123.png"));

    return new OpenAPI()
        // .servers(servers)
//        .info(new Info()
//            .title("Your app title")
//            .description("App description")
//            .version("1.0")
//            .license(new License()
//            .name("GNU/GPL")
//            .url("https://www.gnu.org/licenses/gpl-3.0.html")))
        .components(new Components().addSchemas("NewUserBody", questionSchema));
  }
  // public OpenAPI customQuestionOpenAPI() {
  // Schema questionSchema = new Schema()<Map<String, Object>>()
  // .addProperties("questionText", new StringSchema().example(""));
  //
  // return new OpenAPI()
  // .info(new Info()
  // .title("title")
  // .description
  // )
  // }
}
