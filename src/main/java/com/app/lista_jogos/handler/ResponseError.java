package com.app.lista_jogos.handler;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseError {
	private Date timestamp =new Date();
	private String status = "error";
	private int statusCode= 400;
	private String error;
}
