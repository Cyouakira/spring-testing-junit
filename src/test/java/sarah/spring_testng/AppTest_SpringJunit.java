package sarah.spring_testng;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * junit with Spring test
 * 
 * @author Sarah
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration({ "/bean.xml" }) // 加载配置文件
@FixMethodOrder(MethodSorters.DEFAULT)
public class AppTest_SpringJunit {

	@Autowired
	App app;

	@Test
	public void test() {
		app.sarahApp();
	}

}
