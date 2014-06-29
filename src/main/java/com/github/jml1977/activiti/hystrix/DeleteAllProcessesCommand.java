package com.github.jml1977.activiti.hystrix;

import java.util.List;

import org.activiti.engine.runtime.ProcessInstance;

public class DeleteAllProcessesCommand extends AbstractProcessEngineCommand<String> {
	public DeleteAllProcessesCommand() {
		super("Edge", "DeleteAllProcesses", "Edge", 100000);
	}

	@Override
	protected String run() throws Exception {
		try {
			List<ProcessInstance> pis = getRuntimeService().createProcessInstanceQuery().list();
			for (ProcessInstance pi : pis) {
				getRuntimeService().deleteProcessInstance(pi.getProcessInstanceId(), "Cleaning up");
			}
			return "Done";
		} catch (Exception ex) {
			return "Failed: " + ex.getMessage();
		}
	}

}
