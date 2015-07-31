package main.java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"../../../../applicationContext.xml"})  
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public class Stub {
	@Autowired
	MemcachedHelper memcachedHelper;
	
	@Before
	public void setUp() throws Exception {
		File file = new File("C:\\source\\name11.jpg");
		memcachedHelper.set("name", FileUtils.readFileToByteArray(file));
//		memcachedHelper.set("name", "baijy");
	}

	@After
	public void tearDown() throws Exception {
		memcachedHelper.delete("name");
	}

	@Test
	public void test() {
		byte[] data = (byte[]) memcachedHelper.get("name");
		File output = new File("C:\\target\\name2.jpg");
		try {
			FileUtils.writeByteArrayToFile(output, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		String result = (String)memcachedHelper.get("name");
//        assertTrue("baijy".equals(result));
	}

}
