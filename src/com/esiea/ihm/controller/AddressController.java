package com.esiea.ihm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;

import static com.esiea.ihm.entity.AddressType.DELIVERY;
import static com.esiea.ihm.entity.AddressType.PAYMENT;;

@Controller
@RequestMapping("address")
public class AddressController {
	
	public Map<String, Address> addresses = MainController.addresses;

	public Map<String, Contact> contacts = MainController.contacts;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayAddresses() {

		ArrayList<Address> addresses = new ArrayList<Address>(this.addresses.values());

		ModelAndView model = new ModelAndView("listAddress");
		model.addObject("lists", addresses);

		return model;
	}
	
	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public ModelAndView displayAddress(@PathVariable String contactId) {

		Contact contact = contacts.get(contactId);

		if (contact == null) {
			return null;
		}
		
		if(contact.getAddresses().size() == 0)
		{
			System.out.println("contact address list is null !");
			return new ModelAndView("index");
		}
		
		ModelAndView model = new ModelAndView("viewAddress");
		List<Address> addresses = new ArrayList<Address>(contact.getAddresses());
		model.addObject("addresses", addresses);

		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createAddressForm(@RequestParam(value="contact", required=true, defaultValue="-1")int contactID, Model model) {
		model.addAttribute("address", new Address(contacts.get(contactID)));
		return "addressForm";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Address createAddress(@RequestBody Address address) {

		System.out.println("OK");
		System.out.println("contact: " + address.getContact().getFName());
		addresses.put(Integer.toString(MainController.address_count++), address);

		return address;
	}
}
