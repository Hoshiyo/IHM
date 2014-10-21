package com.esiea.ihm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.impl.AddressDAOImpl;
import com.esiea.ihm.model.dao.impl.ContactDAOImpl;

@Controller
@RequestMapping("address")
public class AddressController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayAddresses() {

		ArrayList<Address> addresses = new ArrayList<Address>(AddressDAOImpl.getInstance().getAddresses());

		ModelAndView model = new ModelAndView("listAddress");
		model.addObject("lists", addresses);

		return model;
	}
	
	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public ModelAndView displayAddress(@PathVariable int contactId) {

		Contact contact = ContactDAOImpl.getInstance().getContactById(contactId);

		if (contact == null) {
			return null;
		}
		
		if(contact.getAddresses().size() == 0)
		{
			System.out.println("contact address list is null !");
			return new ModelAndView("index");
		}
		
		ModelAndView model = new ModelAndView("viewAddress");
		List<Address> addresses = contact.getAddresses();
		model.addObject("addresses", addresses);

		return model;
	}
}
