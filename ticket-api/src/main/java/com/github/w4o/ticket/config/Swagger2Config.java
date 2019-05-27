package com.github.w4o.ticket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author frank
 * @date 2019-05-17
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private TicketConfig ticketConfig;

    @Autowired
    public Swagger2Config(TicketConfig ticketConfig) {
        this.ticketConfig = ticketConfig;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 是否开启
                .enable(ticketConfig.getSwagger2().getEnabled()).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.github.w4o.ticket.controller"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Ticket票务系统管理接口")
                .description("一个票务管理系统")
                .version(ticketConfig.getVersion())
                .build();
    }
}
