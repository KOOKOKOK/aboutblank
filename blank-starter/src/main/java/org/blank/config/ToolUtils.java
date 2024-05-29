package org.blank.config;

import org.blank.utils.DateUtil;
import org.blank.utils.JacksonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolUtils {
    @Bean
    public JacksonUtil jacksonUtilTool(){
        return  new JacksonUtil();
    }
    @Bean
    public DateUtil dateUtilTool(){
        return new DateUtil();
    }
}
