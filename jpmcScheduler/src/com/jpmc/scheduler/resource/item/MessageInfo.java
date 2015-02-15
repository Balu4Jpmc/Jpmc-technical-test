package com.jpmc.scheduler.resource.item;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jpmc.scheduler.resource.producer.AdvanceScheduler;

public class MessageInfo implements Message{
	private static final Logger logfile = Logger.getLogger(AdvanceScheduler.class);
	boolean isComplete = false;
	protected int GroupId;
	Map<Integer,String> keyMessages = new HashMap<Integer,String>();

	public Map<Integer, String> getKeyMessages() {
		return keyMessages;
	}

	public void setKeyMessages(Map<Integer, String> keyMessages) {
		this.keyMessages = keyMessages;
	}

	public int getGroupId() {
		return GroupId;
	}

	public void setGroupId(int groupId) {
		GroupId = groupId;
	}

	@Override
	public void completed() {
		isComplete = true;
		logfile.info("message completed");
	}

}
