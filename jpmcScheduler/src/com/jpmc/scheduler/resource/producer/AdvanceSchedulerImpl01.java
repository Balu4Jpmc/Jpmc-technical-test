package com.jpmc.scheduler.resource.producer;

import com.jpmc.scheduler.resource.item.Message;

public class AdvanceSchedulerImpl01 extends AdvanceScheduler{

	public void cancel(){
		//if a group message is cancelled, no messages from that 
		//group should be forwarded to gateway. 
	}
	
	@Override
	public Message prioritize()
	{
		// here the prioritizing algorithm is overridden to 
		// alter the prioritisation logic
		return msg;
	}
	
}
	