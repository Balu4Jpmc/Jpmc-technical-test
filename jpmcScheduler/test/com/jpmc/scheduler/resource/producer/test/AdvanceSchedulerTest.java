package com.jpmc.scheduler.resource.producer.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jpmc.scheduler.resource.item.MessageInfo;
import com.jpmc.scheduler.resource.producer.AdvanceScheduler;

public class AdvanceSchedulerTest {
	private static final Logger logfile = Logger.getLogger(AdvanceScheduler.class);
	private static Map<Integer, String> keyMessages = new HashMap<Integer, String>();

	public static void main(String[] args){
		logfile.info("Started the Scheduler");
		MessageInfo messageInfo = new MessageInfo();
		messageInfo.setGroupId(1);
		keyMessages.put(1,"message 1 group1");
		keyMessages.put(2, "message 2 group1");
		keyMessages.put(3," message terminate group1");
		messageInfo.setKeyMessages(keyMessages);
		
		AdvanceScheduler advanceScheduler = new AdvanceScheduler();
		advanceScheduler.forward(messageInfo);
	}

}
