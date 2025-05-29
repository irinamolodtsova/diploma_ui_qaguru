package config;


import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "file:src/test/resources/remote.properties",
        "file:src/test/resources/local.properties",
})
public interface WebDriverConfig extends Config {
    @Key("getBrowser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("getBrowserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("getBaseUrl")
    @DefaultValue("https://level.travel/")
    String getBaseUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}