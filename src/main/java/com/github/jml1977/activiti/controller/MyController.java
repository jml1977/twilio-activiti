package com.github.jml1977.activiti.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.jml1977.activiti.hystrix.DeleteAllProcessesCommand;
import com.github.jml1977.activiti.hystrix.ShowProcessesCommand;
import com.github.jml1977.activiti.hystrix.StartProcessCommand;

@Controller
public class MyController {

	private static Log logger = LogFactory.getLog(MyController.class);

	@RequestMapping(value = "/myapp/create", method = RequestMethod.POST)
	public String create(Model model) {
		Map<String, Object> emptyMap = Collections.emptyMap();
		StartProcessCommand cmd = new StartProcessCommand("myProcess", emptyMap);
		String ret = cmd.execute();
		model.addAttribute("returnValue", ret);
		return "myapp/create.tmpl";
	}

	@RequestMapping(value = "/myapp/list")
	public String list(Model model) {
		ShowProcessesCommand cmd = new ShowProcessesCommand();
		List<Task> ret = cmd.execute();
		model.addAttribute("tasks", ret);
		return "myapp/list.tmpl";
	}

	@RequestMapping(value = "/myapp/delete", method = RequestMethod.POST)
	public String delete(Model model) {
		DeleteAllProcessesCommand cmd = new DeleteAllProcessesCommand();
		String ret = cmd.execute();
		model.addAttribute("completed", ret);
		return "myapp/delete.tmpl";
	}
}
