package com.esiea.ihm.entity;
/**
 * 
 * Cette énumération nous permet de définir deux types pour l'adresse :
 * - DELIVERY pour les adresses de livraisons.
 * - PAYMENT pour les adresses de facturations.
 * 
 * @author
 * @version 1
 *
 */
public enum AddressType {
	
	DELIVERY {
		public String toString() {
			return "DELIVERY";
		}
	},PAYMENT {
		public String toString() {
			return "PAYMENT";
		}
	};

}
