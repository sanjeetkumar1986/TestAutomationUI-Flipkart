package utility;

import flipkart.automation.constants.FilePath;
import flipkart.automation.utility.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private BrowserDriver() {
        // Private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        try {
            if (driver.get() == null) {
                // Fetch browser type from config, default to firefox if not specified
                String browser = PropertyUtils.getValue(FilePath.CONFIGPATH, "browser");
                if (browser == null || browser.isEmpty()) {
                    browser = "firefox";
                }

                switch (browser.toLowerCase()) {
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        driver.set(new FirefoxDriver(firefoxOptions));
                        break;

                    case "chrome":
                    default:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--remote-allow-origins=*");
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        driver.set(new ChromeDriver(chromeOptions));
                        break;
                }

                // Maximizing via WebDriver API works cross-browser without CLI flags
                driver.get().manage().window().maximize();
            }
        } catch (Exception e) {
           System.out.println(e.getCause());
           System.out.println("++++++++++++++++++++++++++++");
           System.out.println(e.getStackTrace());
            throw new RuntimeException("Failed to initialize WebDriver on current thread: " + e.getMessage(), e);
        }
        return driver.get();
    }

    public static void navigateToEnvUrl() {
        String envUrl = PropertyUtils.getValue(FilePath.CONFIGPATH, "Env.url");
        if (envUrl != null && !envUrl.isEmpty()) {
            getDriver().get(envUrl);
        } else {
            throw new RuntimeException("Environment URL is missing in the configuration file.");
        }
    }

    public static void close() {
        if (driver.get() == null) return;
        try {
            driver.get().quit();
        } catch (Exception e) {
            System.err.println("Exception caught while quitting WebDriver instance: " + e.getMessage());
        } finally {
            // Eliminates memory leaks on thread pools
            driver.remove();
        }
    }
}