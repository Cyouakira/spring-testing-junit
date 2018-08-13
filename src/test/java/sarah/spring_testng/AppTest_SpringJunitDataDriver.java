package sarah.spring_testng;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;

import sarah.listners.junitl.CustomListner;

/**
 * junit 数据驱动的实现 with Spring test
 * 
 * @author Sarah
 *
 */
@RunWith(Parameterized.class)
@ContextConfiguration({ "/bean.xml" }) // 加载配置文件
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class})
@FixMethodOrder(MethodSorters.DEFAULT)
public class AppTest_SpringJunitDataDriver {

	private String username;
	private String password;
	private final TestContextManager testContextManager;

	public AppTest_SpringJunitDataDriver(String username, String password) {
		this.username = username;
		this.password = password;
		this.testContextManager = new TestContextManager(getClass());
	}

	/**
	 * 由于RunWith只能配置一个class类，已经配置了数据驱动启动，所以需要Spring 容器通过代码手动启动
	 * @throws Exception
	 */
	@Before
	public void InitialContext() throws Exception {
		this.testContextManager.prepareTestInstance(this);
	}
	
	@Autowired
	App app;

	@Test
	public void test() throws Exception {
		app.sarahApp();
		System.out.println(username + password);
	}

	@Parameters
	public static Collection getdata() {
		return Arrays.asList(new Object[][] { { "username1", "password1" }, { "username2", "password2" },
				{ "username3", "password3" } });
	}

	/**
	 * 如果用自定义的listener，这样run tests
	 * @param args
	 */
	public static void main(String[] args) {
	    JUnitCore core= new JUnitCore();
	    core.addListener(new CustomListner());
	    core.run(AppTest_SpringJunitDataDriver.class);
	}
}
