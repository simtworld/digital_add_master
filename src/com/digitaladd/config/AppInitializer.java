package com.digitaladd.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInitializer extends
AbstractAnnotationConfigDispatcherServletInitializer {
   
  @Override
  protected Class<?>[] getRootConfigClasses() {
      return new Class[] { AppConfig.class };
  }
   
  @Override
  protected Class<?>[] getServletConfigClasses() {
      return null;
  }
   
  @Override
  protected String[] getServletMappings() {
      return new String[] { "/" };
  }
}
/*public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
	
	

}*/