package com.esiea.ihm.controller;

import static com.esiea.ihm.entity.AddressType.DELIVERY;
import static com.esiea.ihm.entity.AddressType.PAYMENT;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;

import org.springframework.http.MediaType;
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

import com.esiea.ihm.entity.Contact;

@Controller
@RequestMapping(value = "contact")
public class MainController {

	public static Map<String, Address> addresses = new HashMap<String, Address>();
	public static Map<String, Contact> contacts = new HashMap<String, Contact>();
	static int address_count = 0;

	@PostConstruct
	private void init() {
		System.out.println("Initializing datas...");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1992, 11, 11);
		contacts.put("1", new Contact("Guillaume", "Bourderye",
				"guillaumebourderye@hotmail.com", calendar, "06000000"));
		
		addresses.put(Integer.toString(address_count++), new Address(contacts.get("1"), 3, "rue de l'eau", "Konoha", 445,DELIVERY));
		contacts.get("1").addAddress(addresses.get("1"));
		addresses.put(Integer.toString(address_count++), new Address(contacts.get("1"), 3, "rue de l'herbe", "Konoha", 445,PAYMENT));
		contacts.get("1").addAddress(addresses.get("2"));
		
		calendar = Calendar.getInstance();
		calendar.set(1989, 8, 3);
		contacts.put("2", new Contact("Anna", "Guyen", "guyen@et.esiea.fr",
				calendar, "06111111"));

		addresses.put(Integer.toString(address_count++), new Address(contacts.get("2"), 3, "rue de la terre", "Konoha", 445,DELIVERY));
		contacts.get("2").addAddress(addresses.get("3"));
		addresses.put(Integer.toString(address_count++), new Address(contacts.get("2"), 3, "rue de l'eau", "Konoha", 445,PAYMENT));
		contacts.get("2").addAddress(addresses.get("4"));
		
		calendar = Calendar.getInstance();
		calendar.set(1992, 11, 6);
		contacts.put("3", new Contact("Tarek", "Smirani", "smirani@hotmail.com",
				calendar, "06222222"));

		addresses.put(Integer.toString(address_count++), new Address(contacts.get("3"), 3, "rue de la foudre", "Konoha", 445,DELIVERY));
		contacts.get("3").addAddress(addresses.get("5"));
		
		calendar = Calendar.getInstance();
		calendar.set(0, 3, 1);
		contacts.put("4", new Contact("Mourad", "One piece",
				"moumou75@capitaine.com", calendar, "06333333"));

		addresses.put(Integer.toString(address_count++), new Address(contacts.get("4"), 5, "Câle", "Bateau de Luffy", 000,PAYMENT));
		contacts.get("4").addAddress(addresses.get("6"));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayContacts() {

		ArrayList<Contact> contacts = new ArrayList<Contact>(this.contacts.values());

		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", contacts);

		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createContactForm(Model model) {
		model.addAttribute("contact", new Contact());
		return "contactForm";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Contact createContact(@RequestBody Contact contact) {

		System.out.println("OK");
		System.out.println("contact: " + contact.getFName());
		contact.genId();
		contacts.put(Integer.toString(contact.getId()), contact);

		return contact;
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public String displayContact(@PathVariable String contactId, ModelMap model) {

		Contact contact = contacts.get(contactId);

		if (contact == null) {
			return "index";
		}

		model.addAttribute("contact", contact);

		return "viewContact";
	}

	@RequestMapping(value = "/{contactId}/edit", method = RequestMethod.GET)
	public ModelAndView editContactForm(@PathVariable String contactId) {

		Contact contact = contacts.get(contactId);

		if (contact == null) {
			return displayContacts();
		}

		return new ModelAndView("contactForm", "contact", contact);
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.PUT)
	@ResponseBody
	public Contact editContact(@RequestBody Contact contact) {

		contacts.put(Integer.toString(contact.getId()), contact);
		return contact;
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Contact deleteContact(@PathVariable String contactId) {

		return contacts.remove(contactId);
	}

	// @RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE)
	// public ModelAndView deleteContact(
	// @RequestParam(value = "ids") String contactIds) {
	//
	// String[] ids = contactIds.split("[^0-9]+");
	// for (String id : ids) {
	// data.remove(id);
	// }
	// return displayContacts();
	// }
}
