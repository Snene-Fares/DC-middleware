package org.dubaichamber.dcmiddleware.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dubaichamber.dcmiddleware.util.SCIMProfileHolder;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationWebConfigurer implements WebMvcConfigurer {
    private final SCIMProfileHolder scimProfileHolder;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(
                new WebRequestInterceptor() {
                    @Override
                    public void preHandle(WebRequest request)  {}

                    @Override
                    public void postHandle(WebRequest request, ModelMap model)  {}

                    @Override
                    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
                        scimProfileHolder.clear();
                    }
                }
        );
    }
}
