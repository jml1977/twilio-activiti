package com.github.jml1977.activiti.service;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;

public class TwilioSendSmsServiceTask implements JavaDelegate {
	public TwilioSendSmsServiceTask() {

	}

	private String authToken;

	 public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Map<String, Object> vars = execution.getVariables();
		String accountSid = (String) vars.get("AccountSid");
		String from = (String) vars.get("From");
		String to = (String) vars.get("To");
		TwilioRestClient client = new TwilioRestClient(accountSid, authToken);
		Account account = client.getAccount();
		SmsFactory smsFactory = account.getSmsFactory();
		Map<String, String> params = new HashMap<>();

		// resend to originator from the receiver
		params.put("To", from);
		params.put("From", to);
		params.put("Body", "Request completed");

		Sms sms = smsFactory.create(params);
	}
}
