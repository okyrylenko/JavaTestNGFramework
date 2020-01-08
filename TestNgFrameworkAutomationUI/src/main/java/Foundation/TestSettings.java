package Foundation;

import Foundation.Enums.Browsers;
import Foundation.Enums.Environments;
import com.google.gson.Gson;

public class TestSettings {
    private Environments env;
    private Browsers browser;
    private String baseUrl;


    public Environments getEnv() {
        return env;
    }
    public TestSettings setEnv(Environments env) {
        this.env = env;
        return this;
    }

    public Browsers getBrowser() {
        return browser;
    }

    public TestSettings setBrowser(Browsers browser) {
        this.browser = browser;
        return this;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public TestSettings setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
