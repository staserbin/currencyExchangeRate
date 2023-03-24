package com.currency.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"})
public interface Configuration extends Config{

    @Config.Key("api.base.uri")
    String baseURI();

    @Config.Key("webdriver.chrome.driver")
    String webDriver();
}
