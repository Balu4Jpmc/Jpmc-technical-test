package com.jpmc.scheduler.resource.producer.junit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.jpmc.scheduler.resource.item.MessageInfo;
import com.jpmc.scheduler.resource.producer.AdvanceScheduler;

public class AdvanceSchedulerJUnitTest {
	AdvanceScheduler advanceScheduler;
	MessageInfo info;
	
	@Before
	public void setUp() throws Exception {
		advanceScheduler = new AdvanceScheduler();
		info = new MessageInfo();
	}

	@Test
	public void testforward() {
		info.setGroupId(1);
		Map<Integer, String> keyMessages = new HashMap<Integer, String>();
		keyMessages.put(1,"message 1 group1");
		info.setKeyMessages(keyMessages );
		assertEquals("", advanceScheduler.forward(info));
	}
	
	@Test
	@Ignore
	public void testqueue(){
		info.setGroupId(2);
		Map<Integer, String> keyMessages = new HashMap<Integer, String>();
		keyMessages.put(1,"message 1 group2");
		info.setKeyMessages(keyMessages );
	}
	
	@Test
	public void testprioritize(){
	
	}

}
