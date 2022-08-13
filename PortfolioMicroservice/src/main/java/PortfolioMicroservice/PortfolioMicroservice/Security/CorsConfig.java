package PortfolioMicroservice.PortfolioMicroservice.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());

        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //  cross domain configuration error , take .allowedOrigins Replace with .allowedOriginPatterns that will do .
        //  set the domain name that allows cross domain requests
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.addAllowedHeader("*");
        //  set allowed methods
        corsConfiguration.addAllowedMethod("*");
        //  whether to allow certificates
        corsConfiguration.setAllowCredentials(true);
        //  cross domain allow time
        corsConfiguration.setMaxAge(3600L);

        return corsConfiguration;
    }

}
