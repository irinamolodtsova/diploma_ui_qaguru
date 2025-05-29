package helpers;

public class JenkinsProperties {

    public static String getServer() {
        String login = System.getProperty("login");
        String pw = System.getProperty("pw");
        String server = System.getProperty("server");

        return "https://" + login + ":" + pw + "@" + server + "/wd/hub";
    }

    public static String getBrowser() {
        return System.getProperty("browser", "chrome");
    }

    public static String getBrowserVersion() {
        return System.getProperty("version", "126.0");
    }

}
