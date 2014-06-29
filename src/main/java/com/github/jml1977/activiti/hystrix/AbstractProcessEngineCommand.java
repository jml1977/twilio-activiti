package com.github.jml1977.activiti.hystrix;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;

public abstract class AbstractProcessEngineCommand<T> extends HystrixCommand<T> {
	protected AbstractProcessEngineCommand(String commandGroup, String command, String threadPool,
			int timeout) {

		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(commandGroup)).andCommandKey(HystrixCommandKey.Factory.asKey(command))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(threadPool))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(timeout)));
	}

	protected RuntimeService getRuntimeService() {
		return ProcessEngines.getDefaultProcessEngine().getRuntimeService();
	}

	protected TaskService getTaskService() {
		return ProcessEngines.getDefaultProcessEngine().getTaskService();
	}
}
