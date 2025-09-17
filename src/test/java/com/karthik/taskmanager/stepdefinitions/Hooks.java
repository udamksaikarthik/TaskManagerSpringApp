package com.karthik.taskmanager.stepdefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.nio.file.Paths;

public class Hooks {

    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // false to debug locally
        page = browser.newPage();
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {
        try {
            if (scenario.isFailed() && page != null && !page.isClosed()) {
                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(Paths.get("screenshots/" + scenario.getName() + ".png")));
            }
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        } finally {
            if (page != null && !page.isClosed()) page.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        }
    }
}
