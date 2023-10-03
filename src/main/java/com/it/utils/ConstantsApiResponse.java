package com.it.utils;

import org.springframework.http.HttpStatus;

import com.it.model.ResponseModel;

public class ConstantsApiResponse {

	public static ResponseModel getOkResponse(ResponseModel response) {
		response.setStatus(HttpStatus.OK.value());
		response.setStatusCode("SUCCESS");
		response.setMessage(HttpStatus.OK.name());
		return response;
    }
	
	public static ResponseModel getSavedSuccessResponse(ResponseModel response) {
		response.setStatus(HttpStatus.CREATED.value());
		response.setStatusCode("SUCCESS");
		response.setMessage(HttpStatus.CREATED.name());
		return response;
    }
	
	public static ResponseModel getErrorInternalServerError(ResponseModel response) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setStatusCode("ERROR");
		return response;
    }
}
