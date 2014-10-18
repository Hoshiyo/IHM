package com.esiea.ihm.entity;
/**
 * @author snake984
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
