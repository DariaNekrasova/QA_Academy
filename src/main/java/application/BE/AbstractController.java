package application.BE;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public abstract class AbstractController {
    protected static final String EMPTY_BODY = "";

    protected final String contextUri;

    public AbstractController(String contextUri) {
        this.contextUri = contextUri;
    }

    protected RequestSpecification getSpecification() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        return given().header(new Header("csrftoken",
                                         "Mq4Yu6OUxFPSl680bQ6qngyW8GeIcaA4OdpEnxK2Bw05dX9DZfDr3fRoUTKEANzB"))
                      .header(new Header("sessionid", "k480bjkka0de0gmwijkh83eorplrwvqa"))
                      .contentType(ContentType.JSON);
    }

    protected String get(String uri) {
        return get(getSpecification(), uri).statusCode(StatusCodes.OK).extract().asString();
    }

    protected void get(String uri, int statusCode) {
        get(getSpecification(), uri).statusCode(statusCode);
    }

    protected <T> T get(String uri, Class<T> dtoClass) {
        return get(getSpecification(), uri).statusCode(StatusCodes.OK).extract().as(dtoClass);
    }

    protected <T> T get(String uri, Map<String, ?> parameters, Class<T> dtoClass) {
        return get(getSpecification().parameters(parameters), uri).statusCode(StatusCodes.OK).extract().as(dtoClass);
    }

    protected ValidatableResponse get(RequestSpecification specification, String uri) {
        return specification.when().get(uri).then();
    }

    //protected void post(String uri) {
    //    post(uri, EMPTY_BODY, StatusCodes.OK);
    //}

    protected ValidatableResponse post(String uri) {
        return getSpecification().when().post(uri).then();
    }

    protected void post(String uri, int statusCode) {
        post(uri, EMPTY_BODY, statusCode);
    }

    protected void post(String uri, Map<String, ?> parameters) {
        post(getSpecification().queryParams(parameters), uri).statusCode(StatusCodes.OK);
    }

    protected void post(String uri, String json) {
        post(uri, json, StatusCodes.OK);
    }

    protected void post(String uri, String json, int statusCode) {
        post(getSpecification(), uri, json).statusCode(statusCode);
    }

    protected <T> T post(String uri, Class<T> dtoClass) {
        return post(uri, EMPTY_BODY, dtoClass);
    }

    protected <T> T post(String uri, String json, Class<T> dtoClass) {
        return post(getSpecification(), uri, json).statusCode(StatusCodes.OK).extract().as(dtoClass);
    }

    protected ValidatableResponse post(RequestSpecification specification, String uri, String json) {
        return specification.body(json).when().post(uri).then();
    }

    protected ValidatableResponse post(RequestSpecification specification, String uri) {
        return specification.when().post(uri).then();
    }

    protected void put(String uri, String json) {
        put(uri, json, StatusCodes.OK);
    }

    protected void put(String uri) {
        put(uri, EMPTY_BODY, StatusCodes.OK);
    }

    protected void put(String uri, int statusCode) {
        put(uri, EMPTY_BODY, statusCode);
    }

    protected void put(String uri, String json, int statusCode) {
        put(getSpecification(), uri, json).statusCode(statusCode);
    }

    protected <T> T put(String uri, String json, Class<T> dtoClass) {
        return put(getSpecification(), uri, json).statusCode(StatusCodes.OK).extract().as(dtoClass);
    }

    protected ValidatableResponse put(RequestSpecification specification, String uri, String json) {
        return specification.body(json).when().put(uri).then();
    }

    protected ValidatableResponse put(String uri, Map<String, ?> parameters, String json) {
        return getSpecification().parameters(parameters).body(json).when().put(uri).then();
    }

    protected void delete(String uri) {
        delete(uri, EMPTY_BODY, StatusCodes.OK);
    }

    protected void delete(String uri, int statusCode) {
        delete(uri, EMPTY_BODY, statusCode);
    }

    protected void delete(String uri, String json, int statusCode) {
        delete(getSpecification(), uri, json).statusCode(statusCode);
    }

    protected ValidatableResponse delete(RequestSpecification specification, String uri, String json) {
        return specification.body(json).when().delete(uri).then();
    }
}
