package com.esiea.ihm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import com.esiea.ihm.entity.Contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
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

	@RequestMapping(value = "/contact/{contactId}", method = RequestMethod.GET)
	public String displayContact(@PathVariable String contactId, ModelMap model) {

		Contact contact = data.get(contactId);

		if (contact == null) {
			return "index";
		}

		model.addAttribute("contact", contact);

		return "viewContact";
	}

	@RequestMapping(value = "/addContactForm", method = RequestMethod.GET)
	public ModelAndView addContactForm() {
		return new ModelAndView("addContact", "command", new Contact());
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		data.put(Integer.toString(contact.getId()), contact);

		return "index";
	}
}