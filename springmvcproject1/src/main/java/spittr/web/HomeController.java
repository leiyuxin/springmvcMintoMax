package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home","/","/homepage"})
public class HomeController {

  @RequestMapping(method = GET)
  public String home(Model model) {
    return "home"; //home 方法没有做太多的事情它返回一个String类型的home,这个String将会被SpringMVC解读为要渲染的视图名称，DispatchServlet会要求视图解析器将这个逻辑名称解析为实际的视图因为我们在视图解析器里面配置的InternalResourceViewResolver的方式
  }

}
