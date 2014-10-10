package main.java.com.esiea.ihm.controller;

import java.util.Map;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import main.java.com.esiea.ihm.entity.Contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController{
	
	public Map<String, Contact> data = new HashMap<String, Contact>();
	
	@PostConstruct
	private void init() {
		System.out.println("Initializing datas...");
		data.put("1", new Contact("Guigui"));
		data.put("2", new Contact("Tarek"));
		data.put("3", new Contact("Anna"));
		data.put("4", new Contact("One Piece"));
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public String displayContact(@PathVariable String contactId, ModelMap model) {

		Contact contact = data.get(contactId);

		if(contact == null) {
			return "index";
		}
		
		model.addAttribute("contact", contact);
		
		return "viewContact";
	}
}