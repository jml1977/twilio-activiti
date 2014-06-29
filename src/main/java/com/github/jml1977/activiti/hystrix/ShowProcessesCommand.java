package com.github.jml1977.activiti.hystrix;

import java.util.Collections;
import java.util.List;

import org.activiti.engine.task.Task;

public class ShowProcessesCommand extends AbstractProcessEngineCommand<List<Task>> {

	public ShowProcessesCommand() {
		super("Edge", "ShowProcesses", "Edge", 100000);
	}

	@Override
	protected List<Task> run() throws Exception {
		List<Task> tasks = getTaskService().createTaskQuery().includeTaskLocalVariables().includeProcessVariables().orderByProcessInstanceId().desc().list();
		return Collections.unmodifiableList(tasks);
	}
}
