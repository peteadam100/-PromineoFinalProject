
package com.promineo.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineo.ComponentScanMarker;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
//@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Games With Friends"),
  servers = {@Server(url = "http://localhost:8080", description = "Local server")})
public class GamesApplication {

  public static void main(String[] args) {
    SpringApplication.run(GamesApplication.class, args);
  }

}
