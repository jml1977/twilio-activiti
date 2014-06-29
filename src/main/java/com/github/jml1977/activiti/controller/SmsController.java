package com.github.jml1977.activiti.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.jml1977.activiti.hystrix.StartProcessCommand;
import com.twilio.sdk.verbs.TwiMLResponse;

@Controller
@RequestMapping("/sms")
public class SmsController {

	private static Log logger = LogFactory.getLog(MyController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String handleIncomingSms(Model model, @RequestParam Map<String, Object> map) {
		StartProcessCommand cmd = new StartProcessCommand("myProcess", map);
		String ret = cmd.execute();
		TwiMLResponse response = new TwiMLResponse();
		return response.toXML();
	}
}
