package org.automation_practice.configuration;

public class Configuration {

    public static final Browser BROWSER = Browser.fromText(System.getProperty("browser", "chrome"));
    public static final String ENVIRONMENT = System.getProperty("environment", "prd");

}
