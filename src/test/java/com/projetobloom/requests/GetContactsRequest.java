package com.projetobloom.requests;

import com.projetobloom.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetContactsRequest extends RequestRestBase {
    public GetContactsRequest() {

        requestService = "/contacts";
        method = Method.GET;
    }

    public GetContactsRequest(String dadosContato) {

        requestService = "/contacts";
        method = Method.GET;

        queryParameters.put("name", dadosContato);
    }
}
