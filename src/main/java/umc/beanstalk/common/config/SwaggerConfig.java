package umc.beanstalk.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${server.url}")
    private String serverUrl;

    @Bean
    public OpenAPI OpenApi() {
        Info info = new Info()
                .title("Open API")
                .description("API 명세서")
                .version("V1");

//        String jwtSchemeName = "JWT TOKEN";
//        // API 요청헤더에 인증정보 포함
//        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
//        // SecuritySchemes 등록
//        Components components = new Components()
//                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
//                        .name(jwtSchemeName)
//                        .type(Type.HTTP)
//                        .scheme("bearer")
//                        .bearerFormat("JWT"));

        return new OpenAPI()
                .addServersItem(new Server().url(serverUrl))
                .info(info);
//                .addSecurityItem(securityRequirement)
//                .components(components);
    }

}