package io.api.github;

import static io.restassured.RestAssured.given;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

public class ApiSteps {

  @Step("Создаем задачу с заданным названием")
  public Issue createIssue(String title) {
    final Issue toCreate = new Issue();

    toCreate.setTitle(title);
    return given()
            .filter(new AllureRestAssured())
            .header("Authorization", "token 728126394059a3991c9e6e3b8e83121401f35f6e")
            .baseUri("https://api.github.com")
            .body(toCreate)
            .when()
            .post("/repos/eroshenkoam/allure-example/issues")
            .then()
            .statusCode(201)
            .extract()
            .as(Issue.class);
  }

}
