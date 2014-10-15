package com.esiea.ihm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

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

	public Map<String, Contact> data = new HashMap<String, Contact>();

	@PostConstruct
	private void init() {
		System.out.println("Initializing datas...");

		Calendar calendar = Calendar.getInstance();
		calendar.set(1992, 11, 11);
		data.put("1", new Contact("Guillaume", "Bourderye",
				"guillaumebourderye@hotmail.com", calendar, "06000000"));

		calendar = Calendar.getInstance();
		calendar.set(1989, 8, 3);
		data.put("2", new Contact("Anna", "Guyen", "guyen@et.esiea.fr",
				calendar, "06111111"));

		calendar = Calendar.getInstance();
		calendar.set(1992, 11, 6);
		data.put("3", new Contact("Tarek", "Smirani", "smirani@hotmail.com",
				calendar, "06222222"));

		calendar = Calendar.getInstance();
		calendar.set(0, 3, 1);
		data.put("4", new Contact("Mourad", "One piece",
				"moumou75@capitaine.com", calendar, "06333333"));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayContacts() {

		ArrayList<Contact> contacts = new ArrayList<Contact>(data.values());

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
		data.put(Integer.toString(contact.getId()), contact);

		return contact;
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public String displayContact(@PathVariable String contactId, ModelMap model) {

		Contact contact = data.get(contactId);

		if (contact == null) {
			return "index";
		}

		model.addAttribute("contact", contact);

		return "viewContact";
	}

	@RequestMapping(value = "/{contactId}/edit", method = RequestMethod.GET)
	public ModelAndView editContactForm(@PathVariable String contactId) {

		Contact contact = data.get(contactId);

		if (contact == null) {
			return displayContacts();
		}

		return new ModelAndView("contactForm", "contact", contact);
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.PUT)
	@ResponseBody
	public Contact editContact(@RequestBody Contact contact) {

		data.put(Integer.toString(contact.getId()), contact);
		return contact;
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Contact deleteContact(@PathVariable String contactId) {

		return data.remove(contactId);
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