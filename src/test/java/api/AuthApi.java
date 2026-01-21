package api;

import net.serenitybdd.rest.SerenityRest;
import io.restassured.response.Response;

public class AuthApi {
    private Response response;

    public void login(String username, String password) {
        response = SerenityRest.given()
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}")
                .post("/api/auth/login");
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getToken() {
        return response.jsonPath().getString("token");
    }

    public String getTokenType() {
        return response.jsonPath().getString("tokenType");
    }

    public String getMessage() {
        return response.jsonPath().getString("message");
    }
}
