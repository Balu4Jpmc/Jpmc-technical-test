package com.jpmc.scheduler.resource.producer;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jpmc.scheduler.resource.consumer.GatewayProcessed;
import com.jpmc.scheduler.resource.item.Message;
import com.jpmc.scheduler.resource.item.MessageInfo;


public class AdvanceScheduler extends Thread {
	
	private static final Logger logfile = Logger.getLogger(AdvanceScheduler.class);
	boolean externalAvailable = true;
	Message msg;
	private static Map<Integer, String> keyMessages = new HashMap<Integer, String>();

	public synchronized Message forward(MessageInfo info){
		GatewayProcessed processed = new GatewayProcessed();
		keyMessages = info.getKeyMessages(); 
		if(null!=keyMessages){
			logfile.info("messages from group are "+ keyMessages);
			if(info.getGroupId()==1){
				logfile.info("message being sent now "+ keyMessages.get(1));
				msg= info;
				if (externalAvailable == true) {
					try {
						processed.send(msg);
						wait();
					} catch (InterruptedException e) {

					}
				}
			}		
			// else it would go to queue method.
			else{
				queue(msg);
			}
			
			externalAvailable = true;
			notifyAll();
			
		}
		System.err.println("msg is "+msg);
		return msg;
	}
	
	public synchronized void queue(Message queMsg){
		
		if (externalAvailable == false) {
			try {
				wait();
				queMsg.completed();
			} catch (InterruptedException e) {

			}
		}
		msg = queMsg;
		externalAvailable = false;
		notifyAll();
		
	}
	

	public Message prioritize()
	{
		// here the prioritizing algorithm is written
		// which would return the message that gets highest priority 
		return msg;
	}
}


	
