package axiom.service;

import axiom.annotation.CheckNull;
import axiom.vo.Param;
import org.springframework.stereotype.Service;

@Service
public class CheckNullService {

    @CheckNull
    public void test(String nullVal, @CheckNull(group="test") Param param) {
        System.out.println(param);
    }
}
