package com.esiea.ihm.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.esiea.ihm.entity.Address;
import com.esiea.ihm.entity.Contact;
import com.esiea.ihm.model.dao.impl.AddressDAOImpl;
import com.esiea.ihm.model.dao.impl.ContactDAOImpl;

@Controller
@RequestMapping(value = "contact")
public class ContactController {

	@PostConstruct
	private void init() {
		ContactDAOImpl.getInstance();
		AddressDAOImpl.getInstance();
	}

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

	@RequestMapping(value = "/{contactId:[0-9]+}", method = RequestMethod.GET)
	public String displayContact(@PathVariable String contactId, ModelMap model) {

		Contact contact = ContactDAOImpl.getInstance().getContactByKey(
				contactId);

		if (contact == null) {
			return "index";
		}

		ArrayList<Address> addresses = new ArrayList<Address>(
				contact.getAddresses());

		model.addAttribute("contact", contact);
		model.addAttribute("addresses", addresses);

		return "viewContact";
	}

	@RequestMapping(value = "/{contactId:[0-9]+}/edit", method = RequestMethod.GET)
	public ModelAndView editContactForm(@PathVariable String contactId) {

		Contact contact = ContactDAOImpl.getInstance().getContactByKey(
				contactId);

		if (contact == null) {
			return displayContacts();
		}

		return new ModelAndView("contactForm", "contact", contact);
	}

	@RequestMapping(value = "/{contactId:[0-9]+}/newAddress", method = RequestMethod.GET)
	public String createAddressForm(@PathVariable String contactId, Model model) {
		model.addAttribute("address", new Address(ContactDAOImpl.getInstance()
				.getContactByKey(contactId)));
		return "addressForm";
	}

	@RequestMapping(value = "/{contactId:[0-9]+}", method = RequestMethod.PUT)
	@ResponseBody
	public Contact editContact(@RequestBody Contact contact) {

		ContactDAOImpl.getInstance().updateContact(contact);
		return contact;
	}

	@RequestMapping(value = "/{contactId:[0-9]+}", method = RequestMethod.DELETE)
	@ResponseBody
	public Contact deleteContact(@PathVariable String contactId) {

		return ContactDAOImpl.getInstance().removeContact(contactId);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchContact(
			@RequestParam(value = "search") String searchParam) {
		if (searchParam == null)
			return displayContacts();

		System.out.println("Search= " + searchParam);

		ModelAndView model = new ModelAndView("searchContact");

		ArrayList<Contact> contactByNameList = new ArrayList<Contact>();
		contactByNameList.addAll(ContactDAOImpl.getInstance()
				.getContactByFName(searchParam));
		contactByNameList.addAll(ContactDAOImpl.getInstance()
				.getContactByLName(searchParam));

		ArrayList<Contact> contactByEmailList = new ArrayList<Contact>();
		contactByEmailList.addAll(ContactDAOImpl.getInstance()
				.getContactByEmail(searchParam));

		ArrayList<Contact> contactByPhoneNbrList = new ArrayList<Contact>();
		contactByPhoneNbrList.addAll(ContactDAOImpl.getInstance().getContactByPhoneNbr(searchParam));
		
		/*if(contactByNameList.size()==0 && contactByEmailList.size()==0 && contactByPhoneNbrList.size()==0)
		{
			return displayContacts();
		}*/
		
		model.addObject("nameList", contactByNameList);
		model.addObject("emailList", contactByEmailList);
		model.addObject("phoneList", contactByPhoneNbrList);
		return model;
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
