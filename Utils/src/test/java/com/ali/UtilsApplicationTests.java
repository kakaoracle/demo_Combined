package com.ali;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsApplicationTests {

	@Test
	public void contextLoads() {
		String ttt = null;

		try {
			System.out.println(ttt.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

