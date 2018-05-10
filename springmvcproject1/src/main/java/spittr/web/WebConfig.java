package spittr.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 我们有多种方式来配置DispatchServlet ,与之类似的启用SpringMVC组件的方法也不仅仅一种，以前，Spring 是使用XML进行配置的，你可以使用
 * <mvc:annotation-driven>启用注解驱动的SpringMVC。如果没有配置视图解释器，如果这样的话，Spring默认会使用BeanNameViewResolve这个视图解析器，这个解析器会查找ID与视图名称
 * 匹配的bean,并且查找的bean要实现view接口，它以这样的方式来解析视图，
 * dispatchServt 会映射为应用的默认Servlet，所以它会处理所有的请求， 包括静态资源的请求，如图片和样式表在多少
 * @author lyx
 *
 */
@Configuration
@EnableWebMvc  //启用Springmvc
@ComponentScan("spittr.web") //启用组件扫描如果没有只能找到显式声明在配置类中的控制器，
public class WebConfig extends WebMvcConfigurerAdapter { //扩展了

  @Bean //添加了一个ViewResolver bean
  public ViewResolver viewResolver() {//配置jsp视图解析器
    InternalResourceViewResolver resolver = new InternalResourceViewResolver(); // 作用是查找JSP文件
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable(); //配置静态资源处理 通过调用默认的方法,要求dispatcherServelt将静态资源的请求转发到servlet容器中默认的Servlet上而不是使用dispatchServlet本身来处理此类请求
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // TODO Auto-generated method stub
    super.addResourceHandlers(registry);
  }

}
