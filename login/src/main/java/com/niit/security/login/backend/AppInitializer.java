package com.niit.security.login.backend;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	   
		@Override
		protected Class<?>[] getRootConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{DBConfig.class};
		}
	   
		@Override
		protected Class<?>[] getServletConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{AppConfig.class};
		}

		@Override
		protected String[] getServletMappings() {
			// TODO Auto-generated method stub
			return new String[]{"/"};
			
		}

}
