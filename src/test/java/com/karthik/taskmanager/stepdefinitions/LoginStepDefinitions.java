package com.karthik.taskmanager.stepdefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinitions {

    Page page = Hooks.page;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        page.navigate("http://localhost:8080/login");
    }

    @When("User Enters username and password")
    public void user_enters_username_and_password() {
        page.fill("#username", "Karthik");
        page.fill("#password", "12345678");
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        page.click("#loginButton");
    }

    @Then("User is redirected to Task Manager App Dashboard Page")
    public void user_is_redirected_to_task_manager_app_dashboard_page() {
    	// Wait for navigation to the dashboard (replace '/dashboard' with your actual path)

        // Assert current URL is dashboard
        assertTrue(page.url().contains("/dashboard"), "User is not on dashboard page!");
    }
    
    @When("User Enters {string} and {string}")
    public void user_enters_credentials(String username, String password) {
        page.fill("#username", username);
        page.fill("#password", password);
    }
    
}
