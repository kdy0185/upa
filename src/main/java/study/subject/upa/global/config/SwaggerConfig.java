package study.subject.upa.global.config;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Class : SwaggerConfig
 * @Author : KDW
 * @Date : 2022-03-12
 * @Description : Swagger 설정
 */
@Configuration
@EnableWebMvc
public class SwaggerConfig {

    /**
     * <p>Swagger Bean 등록</p>
     *
     * @return Docket (Docket Plugin)
     */
    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
            .consumes(getConsumeContentTypes())
            .produces(getProduceContentTypes())
            .select()
            .apis(RequestHandlerSelectors.basePackage("study.subject.upa"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false);
    }

    /**
     * <p>API 정보 설정</p>
     *
     * @return ApiInfo (Api Info)
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("URL Parsing API")
            .description("URL 파싱 후 데이터 가공하기")
            .build();
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }
}
