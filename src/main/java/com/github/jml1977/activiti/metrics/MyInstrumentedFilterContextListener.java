package com.github.jml1977.activiti.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlet.InstrumentedFilterContextListener;

public class MyInstrumentedFilterContextListener extends InstrumentedFilterContextListener {
    public static final MetricRegistry REGISTRY = new MetricRegistry();

    @Override
    protected MetricRegistry getMetricRegistry() {
        return REGISTRY;
    }
}
