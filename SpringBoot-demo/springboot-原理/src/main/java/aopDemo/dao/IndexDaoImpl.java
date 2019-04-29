package aopDemo.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: kakaoracle
 * @create: 2019-04-07 08:54
 **/
@Component("dao")
@Repository
public class IndexDaoImpl {
    //@Override
    public void query() {
        System.out.println("dao---query");
    }
    
}
