package com.jpmc.scheduler.resource.producer;

import org.apache.log4j.Logger;

public class AdvanceSchedulerImpl02 extends AdvanceSchedulerImpl01{
	private static final Logger logfile = Logger.getLogger(AdvanceSchedulerImpl02.class);

	/**
	 * The last message of a group has terminate message, once that is processed, 
	 * if any new message from that group is forwarded, an error should be thrown. 
	 */
	public void terminate(){
		try{
			throw new Exception("All messages in the group processed, no new message can be sent");
		}
		catch (Exception e)
		{
			logfile.error(e, e);
		}
	}
}
