package com.projetobloom.tests;

import com.projetobloom.bases.TestBase;
import com.projetobloom.requests.GetContactsRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetContactsTests extends TestBase {

    @Test
    public void buscarTodosContatosComSucesso() {

        //region Arrange

        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        GetContactsRequest getContactsRequest = new GetContactsRequest();
        ValidatableResponse response = getContactsRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);

        //endregion
    }

    @Test
    public void buscarContatosPorNome() {

        //region Arrange

        String nomeContato = "Joao";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        GetContactsRequest getContactsRequest = new GetContactsRequest(nomeContato);
        ValidatableResponse response = getContactsRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);

        //endregion
    }

    @Test
    public void buscarContatosPorEstado() {

        //region Arrange

        String estadoContato = "TS";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        GetContactsRequest getContactsRequest = new GetContactsRequest(estadoContato);
        ValidatableResponse response = getContactsRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);

        //endregion
    }

    @Test
    public void buscarContatosPorDadoInexistente() {

        //region Arrange

        String nomeContato = "TSadsadafad";

        String messageEsperado = "We were unable to perform your search at this time. Check that the options have been filled out correctly.";
        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //endregion

        //region Act

        GetContactsRequest getContactsRequest = new GetContactsRequest(nomeContato);
        ValidatableResponse response = getContactsRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }
}
