package com.assuresoft.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
   /**
   *  Configures the MessageDispatcherServlet and maps it to the "/ws/*" URL.
   */
  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/ws/*");
  }

  /**
   * Defines the WSDL configuration for the SOAP service.
   */
  @Bean(name = "countries")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    // Sets the port type name for the service.
    wsdl11Definition.setPortTypeName("CountriesPort");
    // Sets the URI location for the service.
    wsdl11Definition.setLocationUri("/ws");
    // Sets the target namespace for the service.
    wsdl11Definition.setTargetNamespace("www.assuresoft.com");
    // Sets the schema for the service.
    wsdl11Definition.setSchema(countriesSchema);

    return wsdl11Definition;
  }

  /**
   * Defines the XSD schema for the SOAP service.
   */
  @Bean
  public XsdSchema countriesSchema() {
    return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
  }
}
