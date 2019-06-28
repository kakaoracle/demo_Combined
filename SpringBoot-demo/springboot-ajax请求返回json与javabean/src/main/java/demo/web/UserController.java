package demo.web;

import com.alibaba.fastjson.JSON;
import demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class UserController {
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public String json() {
        User user = new User();
        user.setName("xiaoming");
        user.setId(1L);
        String string = JSON.toJSONString(user);
        System.out.println("---返回json: " + string);
        return string;
    }

    @RequestMapping("/javabean")
    public User list() {
        User user = new User();
        user.setName("xiaoming");
        user.setId(1L);
        System.out.println("---返回对象: " + user.toString());
        return user;
    }
}
