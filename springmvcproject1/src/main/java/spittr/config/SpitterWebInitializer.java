package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import spittr.web.WebConfig;
//配置DispatcherServlet,任意扩展了AbstractAnnotationConfigDispatcherServletInitializer的任意类都会自动地配置
//DispatcherServlet和Spring 应用的上下文。Spring应用的上下文，位于应用程序的servlet 上下文中。
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  /**
   * 当DispatchServt 启动的时候，他会创建Spring应用上下文，并加载配置文件或配置类中所声明的bean,在getRootConfigClasses()方法中
   * 我们要求DispatchServlet加载应用上下文时，使用定义在webConfig配置类中的(使用java 配置)bean,
   *
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class<?>[] { RootConfig.class };
  }
/**
 * 但是在SpringWeb应用中，通常还会有宁外一个应用上下文，宁外的这个应用上下文是由ContextLoaderListener创建的
 * 我们希望DispatchServlet加载Web组件的Bean,如控制器，视图解析器以及处理器映射，而ContextLoaderListener要加载应用中的其他
 * bean,这些bean 通常是驱动应用后端的中间层和数据层组件。
 * 实际上，AbstractAnnotationConfigDispatcherServletInitializer 会同时创建DispatchServlet和ContextLoaderListener，
 * getServletConfigClasses方法返回的带有@Configuration注解的类将会用来定义DispatchServlet应用上下文中的bean,getRootConfigClasses方法返回的带有
 * @Configuration注解的类将会用来配置ContextLoaderListener创建的应用上下文中的bean.
 *
 */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] { WebConfig.class };
  }
/**
 * 它将一个和多个路径映射到DispatcherServlet 上。在本例中，它映射的是"/",这表示它会是应用的默认的Servlet。它会处理进入应用的所有请求。
 * 为了理解其他的两个方法，我们首先要理解DispatchServlet和一个Servlet监听器（ContextLoaderListener）的关系
 *
 */
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}