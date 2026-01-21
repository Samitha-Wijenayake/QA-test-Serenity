package steps;
import api.AuthApi;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;

import static org.junit.jupiter.api.Assertions.*;

public class AuthApiSteps {
    @Steps
    AuthApi authApi;

    @Given("User sends login request with username {string} and password {string}")
    public void sendLogin(String username, String password) {
        authApi.login(username, password);
    }

    @Then("API should return status {int}")
    public void verifyStatus(int status) {
        assertEquals(status, authApi.getStatusCode());
    }

    @Then("response should contain token and tokenType")
    public void verifyToken() {
        assertNotNull(authApi.getToken());
        assertNotNull(authApi.getTokenType());
    }

    @Then("response message should be {string}")
    public void verifyErrorMessage(String msg) {
        assertEquals(msg, authApi.getMessage());
    }
}
