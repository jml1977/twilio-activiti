package com.github.jml1977.activiti.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.jml1977.activiti.hystrix.CloseTaskCommand;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	private static Log logger = LogFactory.getLog(TaskController.class);

	@RequestMapping(value = "{taskId}/submit", method = RequestMethod.POST)
	public String handleSubmit(Model model, @PathVariable("taskId") String taskId, @RequestParam Map<String, Object> map) {
		CloseTaskCommand cmd = new CloseTaskCommand(taskId);
		Boolean success = cmd.execute();
		// model.addAttribute("success", success);
		return "redirect:/myapp/list";
	}
}
