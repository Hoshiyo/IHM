package com.esiea.ihm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;

import static com.esiea.ihm.entity.AddressType.DELIVERY;
import static com.esiea.ihm.entity.AddressType.PAYMENT;

@Controller
@RequestMapping("address")
public class AddressController {
	
	public Map<String, Address> addresses = new HashMap<String, Address>();

	public Map<String, Contact> contacts = new HashMap<String, Contact>();

	@PostConstruct
	private void init() {
		System.out.println("Initializing datas...");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1992, 11, 11);
		contacts.put("1", new Contact("Guillaume", "Bourderye",
				"guillaumebourderye@hotmail.com", calendar, "06000000"));
		
		addresses.put("1", new Address(contacts.get("1"), 3, "rue de l'eau", "Konoha", 445,DELIVERY));
		contacts.get("1").addAddress(addresses.get("1"));

		addresses.put("2", new Address(contacts.get("1"), 3, "rue de l'herbe", "Konoha", 445,PAYMENT));
		contacts.get("1").addAddress(addresses.get("2"));
		
		calendar = Calendar.getInstance();
		calendar.set(1989, 8, 3);
		contacts.put("2", new Contact("Anna", "Guyen", "guyen@et.esiea.fr",
				calendar, "06111111"));

		addresses.put("3", new Address(contacts.get("2"), 3, "rue de la terre", "Konoha", 445,DELIVERY));
		contacts.get("2").addAddress(addresses.get("3"));
		addresses.put("4", new Address(contacts.get("2"), 3, "rue de l'eau", "Konoha", 445,PAYMENT));
		contacts.get("2").addAddress(addresses.get("4"));
		
		calendar = Calendar.getInstance();
		calendar.set(1992, 11, 6);
		contacts.put("3", new Contact("Tarek", "Smirani", "smirani@hotmail.com",
				calendar, "06222222"));

		addresses.put("5", new Address(contacts.get("3"), 3, "rue de la foudre", "Konoha", 445,DELIVERY));
		contacts.get("3").addAddress(addresses.get("5"));
		
		calendar = Calendar.getInstance();
		calendar.set(0, 3, 1);
		contacts.put("4", new Contact("Mourad", "One piece",
				"moumou75@capitaine.com", calendar, "06333333"));

		addresses.put("6", new Address(contacts.get("4"), 5, "Câle", "Bateau de Luffy", 000,PAYMENT));
		contacts.get("4").addAddress(addresses.get("6"));
	}
	
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
		List<Address> addresses = contact.getAddresses();
		model.addObject("addresses", addresses);

		return model;
	}
}
