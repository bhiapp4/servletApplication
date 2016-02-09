package org.servlet.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionMonitoringListener implements HttpSessionListener {

	private int activeSessionCount = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		activeSessionCount++;
		System.out.println("No of active sessions in the app is "+activeSessionCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		activeSessionCount--;
		System.out.println("No of active sessions in the app is "+activeSessionCount);
	}

}
