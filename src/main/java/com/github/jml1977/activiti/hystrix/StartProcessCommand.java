package com.github.jml1977.activiti.hystrix;

import java.util.Collections;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;

public class StartProcessCommand extends AbstractProcessEngineCommand<String> {

	public StartProcessCommand(String processKey, Map<String, Object> variables) {
		super("Edge", "StartProcess", "Edge", 100000);
		this.processKey = processKey;
		this.variables = Collections.unmodifiableMap(variables);
	}

	final private String processKey;

	@Override
	public String run() throws Exception {
		ProcessInstance pi = getRuntimeService().startProcessInstanceByKey(processKey, variables);
		return pi.getId();
	}

	private Map<String, Object> variables;
}
