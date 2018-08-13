package sarah.spring_testng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sarah.listners.testngl.CustomListner;

/**
 * TestNG 数据驱动的实现 with Spring test 
 * @author Sarah
 *
 */
@ContextConfiguration({ "/bean.xml" }) // 加载配置文件
@Listeners(CustomListner.class)
public class AppTest_SpringTestNGDataDriver extends AbstractTestNGSpringContextTests
{
	

	@Autowired
	App app;
	
	@Test(dataProvider="Data")
	public void test(String param1,String param2,String param3) {
		app.sarahApp();
		System.out.println(param1+"==="+param2+"==="+param3);
	}
	
	@DataProvider(name = "Data")
	public static Object[][] generateArrays() {
		Object[][] params = new Object[2][3];
		for (int i = 0; i < params.length; i++) {
			for (int j = 0; j < params[i].length; j++) {
				params[i][j] = i+""+j;// 从第二列开始，所以j+2,
				System.out.println(params[i][j]);
			}
		}
		return params;
	}

}
