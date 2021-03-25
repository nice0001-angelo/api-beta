/**
 * 
 */
package net.jin.config;

import org.springframework.context.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

/**
 * @author njh
 * Dependency에 Swagger2 와 UI를 등록한 후에 본 Config.java 파일을 생성한다.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Jimmy API Beta")
                .description("Jimmy's API Beta List")
                .build();
    }

    //Bean 등록
    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("API with Swagger")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("net.jin.controller"))
                .paths(PathSelectors.ant("/**"))
                .build();
    }
}
