package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import util.Configuration;

import util.RESTUtil;

public abstract class BaseApiTest {

    public RESTUtil restUtil;
    public static final Configuration _config;

    static {
        _config = new Configuration();
    }

    @BeforeSuite
    public void beforeSuite() {
        restUtil = new RESTUtil(_config);
    }

    @AfterSuite
    public void afterSuite() {
        restUtil = null;
    }

}
