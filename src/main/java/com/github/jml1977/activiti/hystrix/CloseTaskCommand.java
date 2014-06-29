package com.github.jml1977.activiti.hystrix;

public class CloseTaskCommand extends AbstractProcessEngineCommand<Boolean> {
	public CloseTaskCommand(String taskId) {
		super("Edge", "CloseTask", "Edge", 100000);
		this.taskId = taskId;
	}

	private final String taskId;

	@Override
	protected Boolean run() throws Exception {
		getTaskService().complete(taskId);
		return true;
	}

	public Boolean getFallback() {
		return false;
	}

}
