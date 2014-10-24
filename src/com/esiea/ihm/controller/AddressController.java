package com.esiea.ihm.controller;

import java.util.ArrayList;

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
import com.esiea.ihm.model.dao.impl.AddressDAOImpl;
import com.esiea.ihm.model.dao.impl.ContactDAOImpl;

@Controller
@RequestMapping("address")
public class AddressController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayAddresses() {
		ArrayList<Address> addresses = new ArrayList<Address>(AddressDAOImpl
				.getInstance().getAddresses());
		ModelAndView model = new ModelAndView("listAddress");
		model.addObject("lists", addresses);
		return model;
	}

	@RequestMapping(value = "/{addressId:[0-9]+}", method = RequestMethod.GET)
	public String displayAddress(@PathVariable String addressId, ModelMap model) {
		Address address = AddressDAOImpl.getInstance().getAddressByKey(
				addressId);
		if (address == null) {
			return "index";
		}
		model.addAttribute("address", address);
		return "viewAddress";
	}
	
	@RequestMapping(value = "/{addressId:[0-9]+}/edit", method = RequestMethod.GET)
	public ModelAndView editAddressForm(@PathVariable String addressId) {
		Address address = AddressDAOImpl.getInstance().getAddressByKey(
				addressId);
		if (address == null) {
			return displayAddresses();
		}
		return new ModelAndView("addressForm", "address", address);
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createAddressForm(
			@RequestParam(value = "contact", required = true, defaultValue = "-1") String contactID,
			Model model) {
		model.addAttribute("address", new Address(ContactDAOImpl.getInstance()
				.getContactByKey(contactID)));
		return "addressForm";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public String createAddress(@RequestBody Address address) {
		address.getContact().addAddress(address);
		AddressDAOImpl.getInstance().addAddress(address);
		
		return "index";
	}
	
	@RequestMapping(value = "/{addressId:[0-9]+}", method = RequestMethod.PUT)
	@ResponseBody
	public Address editAddress(@RequestBody Address address) {
		AddressDAOImpl.getInstance().updateAddress(address);
		
		return address;
	}

	@RequestMapping(value = "/{addressId:[0-9]+}", method = RequestMethod.DELETE)
	@ResponseBody
	public Address deleteAddress(@PathVariable String addressId) {
		return AddressDAOImpl.getInstance().removeAddress(addressId);
	}
	
	@RequestMapping(value="/search", method= RequestMethod.GET)
	@ResponseBody
	public ModelAndView searchAddress(@RequestParam(value="search") String searchParam) {
		if(searchParam == null)
			return displayAddresses();
		
		
		ModelAndView model = new ModelAndView("searchAddress");
		
		ArrayList<Address> addressByNbrList = new ArrayList<Address>();
		
		try {
			addressByNbrList.addAll(AddressDAOImpl.getInstance().getAddressByNbr(Integer.parseInt(searchParam)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		ArrayList<Address> addressByStreetList = new ArrayList<Address>();
		addressByStreetList.addAll(AddressDAOImpl.getInstance().getAddressByStreet(searchParam));
		
		ArrayList<Address> addressByCityList = new ArrayList<Address>();
		addressByCityList.addAll(AddressDAOImpl.getInstance().getAddressByCity(searchParam));
		
		model.addObject("nbrList", addressByNbrList);
		model.addObject("streetList", addressByStreetList);
		model.addObject("cityList", addressByCityList);
		
		return model;
	}
}
