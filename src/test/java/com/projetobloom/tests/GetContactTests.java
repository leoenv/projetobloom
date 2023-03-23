package com.projetobloom.tests;

import com.projetobloom.bases.TestBase;
import com.projetobloom.requests.GetContactRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetContactTests extends TestBase {

    @Test
    public void buscarContatoPorIdComSucesso() {

        //region Arrange

        String idContato = "5fd7f1b0591c23002f91972b";

        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        GetContactRequest getContactRequest = new GetContactRequest(idContato);
        ValidatableResponse response = getContactRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);

        //endregion
    }

    @Test
    public void buscarContatoPorIdInexistente() {

        //region Arrange

        String idContato = "aaaaaaaaa";

        String messageEsperado = "We were unable to perform your search at this time.";
        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //endregion

        //region Act

        GetContactRequest getContactRequest = new GetContactRequest(idContato);
        ValidatableResponse response = getContactRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }
}
