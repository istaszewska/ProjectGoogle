package com.google.homepage.configuration;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:EnvironmentConfig.properties")
public interface Configuration extends Config {

    @Config.Key("BROWSER")
    String browser();

}
