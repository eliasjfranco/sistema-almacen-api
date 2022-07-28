package com.sistema.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	public final static Result ERR_GENERAL = new Result(Constants.RESULT_ERROR,"ERR_GENERAL", "Error general");
	
	//PRODUCTS
	public final static Result ERR_PRODUCT_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_PRODUCT_EXISTS", "El producto ya se encuentra registrado");
	public final static Result ERR_PRODUCT_NOT_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_PRODUCT_NOT_EXISTS", "El producto ingresado no existe");

	//PARAM
	public final static Result ERR_NAME_PARAM = new Result(Constants.RESULT_ERROR, "ERR_NAME_PARAM", "El parámetro nombre es requerido");
	public final static Result ERR_DETAIL_PARAM = new Result(Constants.RESULT_ERROR, "ERR_DETAIL_PARAM", "El parámetro detalle es requerido");
	public final static Result ERR_PRODUCT_PARAM = new Result(Constants.RESULT_ERROR, "ERR_NAME_PARAM", "El parámetro id producto es requerido");
	
	//CATEGORY
	public final static Result ERR_CATEGORY_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_CATEGORY_EXISTS", "La categoria ingresada ya se encuentra registrada");
	public final static Result ERR_CATEGORY_NOT_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_CATEGORY_NOT_EXISTS", "La categoria ingresada no existe");
	
	//USER
	public final static Result ERR_USER_NOT_EXISTS = new Result(Constants.RESULT_ERROR, "ERR_USER_NOT_EXISTS", "El usuario ingresado no existe");
	public final static Result ERR_LOGIN_PARAM = new Result(Constants.RESULT_ERROR, "ERR_LOGIN_PARAM", "No se completaron los datos de ingreso");
	public final static Result ERR_USER_PASSWORD_NOT = new Result(Constants.RESULT_ERROR, "ERR_USER_PASSWORD_NOT", "Los datos de ingreso no coinciden");
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		
		if(e.getMessage().equals(ERR_DETAIL_PARAM.getError_code()))
			return ERR_DETAIL_PARAM;
		if(e.getMessage().equals(ERR_NAME_PARAM.getError_code()))
			return ERR_NAME_PARAM;
		if(e.getMessage().equals(ERR_PRODUCT_EXISTS.getError_code()))
			return ERR_PRODUCT_EXISTS;
		if(e.getMessage().equals(ERR_PRODUCT_NOT_EXISTS.getError_code()))
			return ERR_PRODUCT_NOT_EXISTS;
		if(e.getMessage().equals(ERR_PRODUCT_PARAM.getError_code()))
			return ERR_PRODUCT_PARAM;
		if(e.getMessage().equals(ERR_CATEGORY_EXISTS.getError_code()))
			return ERR_CATEGORY_EXISTS;
		if(e.getMessage().equals(ERR_CATEGORY_NOT_EXISTS.getError_code()))
			return ERR_CATEGORY_NOT_EXISTS;
		if(e.getMessage().equals(ERR_USER_NOT_EXISTS.getError_code()))
			return ERR_USER_NOT_EXISTS;
		if(e.getMessage().equals(ERR_LOGIN_PARAM.getError_code()))
			return ERR_LOGIN_PARAM;
		if(e.getMessage().equals(ERR_USER_PASSWORD_NOT.getError_code()))
			return ERR_USER_PASSWORD_NOT;
		
		ERR_GENERAL.setError_description(e.getMessage());
		return ERR_GENERAL;
	}
}
