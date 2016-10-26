package com.aj.james.backendproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Suppliers {

	@Id
	@GeneratedValue
	private int supplier_id;
	private String supplier_name;
	private String supplier_description;
	private String supplier_address;
	private int supplier_contact_number;
	
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_description() {
		return supplier_description;
	}
	public void setSupplier_description(String supplier_description) {
		this.supplier_description = supplier_description;
	}
	public String getSupplier_address() {
		return supplier_address;
	}
	public void setSupplier_address(String supplier_address) {
		this.supplier_address = supplier_address;
	}
	public int getSupplier_contact_number() {
		return supplier_contact_number;
	}
	public void setSupplier_contact_number(int supplier_contact_number) {
		this.supplier_contact_number = supplier_contact_number;
	}
	
}
