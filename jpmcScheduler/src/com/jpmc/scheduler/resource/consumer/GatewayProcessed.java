package com.jpmc.scheduler.resource.consumer;

import org.apache.log4j.Logger;

import com.jpmc.scheduler.resource.item.Message;
import com.jpmc.scheduler.resource.producer.AdvanceScheduler;

public class GatewayProcessed extends Thread implements Gateway{
	private static final Logger logfile = Logger.getLogger(AdvanceScheduler.class);

	@Override
	public void send(Message msg) {
		logfile.info("message sent for processing");
		
		// after the message is processed
		msg.completed();
	}

}
