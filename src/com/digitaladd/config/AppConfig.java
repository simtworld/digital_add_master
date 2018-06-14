package com.digitaladd.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.digitaladd")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	 @Bean
	    public TilesConfigurer tilesConfigurer() {
	        TilesConfigurer tilesConfigurer = new TilesConfigurer();
	        tilesConfigurer.setDefinitions(
	          new String[] { "/WEB-INF/tiles.xml" });
	        tilesConfigurer.setCheckRefresh(true);
	         
	        return tilesConfigurer;
	    }
	     
	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        TilesViewResolver viewResolver = new TilesViewResolver();
	        registry.viewResolver(viewResolver);
	    }
	     
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/assets/**")
	          .addResourceLocations("/WEB-INF/assets/");
	    }
	
/*	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
*/
}