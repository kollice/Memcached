package main.java;

import static org.junit.Assert.*;

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
		memcachedHelper.set("name", "baijy");
	}

	@After
	public void tearDown() throws Exception {
		memcachedHelper.delete("name");
	}

	@Test
	public void test() {
		String result = (String) memcachedHelper.get("name");
        assertTrue("baijy".equals(result));
	}

}
