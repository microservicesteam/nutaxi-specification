package com.microservicesteam.nutaxi.infrastructure;

import static com.google.common.base.Throwables.propagate;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class SpecificationConfiguration {

    private final PropertiesConfiguration configuration;

    private SpecificationConfiguration() {
        configuration = loadConfiguration();
    }

    private static PropertiesConfiguration loadConfiguration() {
        try {
            return new PropertiesConfiguration("specification.properties");
        } catch (ConfigurationException e) {
            throw propagate(e);
        }
    }

    private static class SingletonHelper {
        private static final SpecificationConfiguration INSTANCE = new SpecificationConfiguration();
    }

    public static PropertiesConfiguration configuration() {
        return SingletonHelper.INSTANCE.configuration;
    }

}
