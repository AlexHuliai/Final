package com.capstone.caps;

	import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CapsApplicationTests {

	@Test
	void contextLoads() {
	}

	private final Logger log = LoggerFactory.getLogger(CapsApplicationTests.class);

	@Test
	public void calculator() {
	  assertEquals(16, mutliply(4,4));
	  assertEquals(20, sum(10,10));	 
	}

	int mutliply(int a, int b){
	return b*a;	
	}

	int sum(int a, int b){
	return b+a;	
	}
}
