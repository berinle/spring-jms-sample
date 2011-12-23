package spooky.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jms.Queue;

@Controller
public class SpookyController {
    
    @Autowired private Queue queue;

    @RequestMapping
    public String index(){
        System.out.println(" calling index() ");
        return "index";
    }
}
