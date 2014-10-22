package com.esiea.ihm.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.impl.ContactDAOImpl;

@Controller
@RequestMapping(value = "contact")
public class ContactController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayContacts() {

		ArrayList<Contact> contacts = new ArrayList<Contact>(ContactDAOImpl
				.getInstance().getContacts());

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

		System.out.println("contact: " + contact.getFName());
		contact.genId();
		ContactDAOImpl.getInstance().addContact(contact);

		return contact;
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public String displayContact(@PathVariable String contactId, ModelMap model) {

		Contact contact = ContactDAOImpl.getInstance().getContactByKey(contactId);

		if (contact == null) {
			return "index";
		}

		model.addAttribute("contact", contact);

		return "viewContact";
	}

	@RequestMapping(value = "/{contactId}/edit", method = RequestMethod.GET)
	public ModelAndView editContactForm(@PathVariable String contactId) {

		Contact contact = ContactDAOImpl.getInstance().getContactByKey(contactId);

		if (contact == null) {
			return displayContacts();
		}

		return new ModelAndView("contactForm", "contact", contact);
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.PUT)
	@ResponseBody
	public Contact editContact(@RequestBody Contact contact) {

		ContactDAOImpl.getInstance().updateContact(contact);
		return contact;
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Contact deleteContact(@PathVariable String contactId) {
		
		return ContactDAOImpl.getInstance().removeContact(contactId);
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
