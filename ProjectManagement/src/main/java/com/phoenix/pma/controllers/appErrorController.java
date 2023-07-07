package com.phoenix.pma.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class appErrorController implements ErrorController {
	
	@GetMapping("/error")
	public String handleErr(HttpServletRequest req) {
		Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "Error/e404";
			}
			else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "Error/e500";
			}
			else if(statusCode == HttpStatus.FORBIDDEN.value()) {
				return "Error/e403";
			}
		}
		return "Error/error";
	}

	public String getErrorPath() {
		return "Error/error";
	}

}
