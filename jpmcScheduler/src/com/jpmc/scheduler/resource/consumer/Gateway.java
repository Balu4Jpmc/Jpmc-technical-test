package com.jpmc.scheduler.resource.consumer;

import com.jpmc.scheduler.resource.item.Message;


public interface Gateway {
	public void send(Message msg);
}
