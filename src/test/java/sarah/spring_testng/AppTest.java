package sarah.spring_testng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration({ "/bean.xml" }) // 加载配置文件
public class AppTest extends AbstractTestNGSpringContextTests
{
	

	@Autowired
	App app;
	
	@Test
	public void test() {
		System.out.println(app);
		app.sarahApp();
	}
}
