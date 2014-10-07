package com.esiea.contacts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EditAddressController implements Controller {

	 public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        //TODO;
	        return new ModelAndView("editAddress.jsp");
	 }
}
