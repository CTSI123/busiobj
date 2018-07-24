package cn.com.ctsi.busiobj;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPathProvider;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class BusiobjApplication {

	@Value("${jetty.maxThreads}")
	private Integer maxThreads;
	@Value("${jetty.minThreads}")
	private Integer minThreads;
	@Value("${server.port}")
	private Integer port;
	@Value("${jetty.acceptors}")
	private Integer acceptors;
	@Value("${jetty.selectors}")
	private Integer selectors;

	@Autowired
	@Qualifier("multipartConfig")
	private MultipartConfigElement multipartConfigElement;


	public static void main(String[] args) {
		SpringApplication.run(BusiobjApplication.class, args);
	}

	@Bean
	public SessionTrackingConfigListener sessionTrackingConfigListener() {
		SessionTrackingConfigListener listener = new SessionTrackingConfigListener();
		return listener;
	}

	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}




	@Bean
	public ServletRegistrationBean dispatchServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				dispatcherServlet(), "/*");
		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
		registration.setAsyncSupported(true);
		registration.setMultipartConfig(multipartConfigElement);
		registration.addInitParameter(
				"org.eclipse.jetty.servlet.Default.dirAllowed",
				"false");
		registration.setOrder(1);
		return registration;
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("PUT", "DELETE","GET","POST")
						.allowedHeaders("*")
						.exposedHeaders("access-control-allow-headers",
								"access-control-allow-methods",
								"access-control-allow-origin",
								"access-control-max-age",
								"X-Frame-Options")
						.allowCredentials(false).maxAge(3600);
			}
		};

	}


	@Bean
	public JettyServerCustomizer jettyServerCustomizer() {
		return server -> {
			final QueuedThreadPool threadPool = server
					.getBean(QueuedThreadPool.class);
			threadPool.setMaxThreads(maxThreads);
			threadPool.setMinThreads(minThreads);
			threadPool.setIdleTimeout(300000);
			threadPool.setName("jetty");

			ServerConnector connector = new ServerConnector(server,
					acceptors, selectors);
			connector.setPort(port);
			connector.setIdleTimeout(300000);
			connector.setAcceptQueueSize(200);
			connector.setReuseAddress(true);

			server.setConnectors(new Connector[] { connector });

			HttpConnectionFactory hcFact = (HttpConnectionFactory) connector
					.getConnectionFactory("HTTP/1.1");
			HttpConfiguration configuration = hcFact
					.getHttpConfiguration();
			configuration.setOutputBufferSize(1024);
			configuration.setSendServerVersion(false);
			configuration.setSendDateHeader(false);
		};
	}

	@Bean
	public JettyServletWebServerFactory jettyServletWebServerFactory(
			JettyServerCustomizer jettyServerCustomizer) {
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory(
				port);
		factory.addServerCustomizers(jettyServerCustomizer);
		return factory;
	}

	public class SessionTrackingConfigListener implements
			ServletContextInitializer {
		@Override
		public void onStartup(ServletContext servletContext) throws ServletException {
			SessionCookieConfig sessionCookieConfig = servletContext
					.getSessionCookieConfig();
			sessionCookieConfig.setHttpOnly(true);
		}
	}





}
