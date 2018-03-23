package com.springcloud.example.demo;

import com.springcloud.example.demo.service.GradeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private GradeService gradeService;

	@Test
	public void contextLoads() {
	 	String gradeName = gradeService.getGradeById(1).getGradename();

		System.out.println(gradeName);
	}

}
