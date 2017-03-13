package org.jogl.config;

import org.jogl.dem.draw.FrameWindow;
import org.jogl.dem.file.FileReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:jogl.properties")
public class AppContext {
	
	@Value("${title}")
    String title;
	
    @Bean(name = "beanFrameWindow")
    public FrameWindow createMainFrame() {
        return new FrameWindow();
    }
    
    @Bean(name = "beanFile")
    public FileReader createFile(){
    	return new FileReader();
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer setUp() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
