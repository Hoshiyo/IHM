package com.esiea.ihm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;

public class ViewAddressController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping(value = "/address/", method = RequestMethod.GET)
	public ModelAndView displayAddress() {

		ArrayList<Address> addresses = new ArrayList<Address>();

		ModelAndView model = new ModelAndView("address");
		model.addObject("addressList", addresses);

		return model;
	}
	
	@RequestMapping(value = "/address/{contactId}", method = RequestMethod.GET)
	public String displayContact(@PathVariable String contactId, ModelMap model) {

		Contact contact = new Contact();

		if (contact == null) {
			return "index";
		}

		model.addAttribute("contact", contact);

		return "viewContact";
	}

}
