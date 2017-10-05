package com.exercise.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InvoiceLineItem {
	@Id
	@GeneratedValue
	private Long invoiceLineItemID;
	private String description;
	private double amount;
	@ManyToOne
	@JoinColumn(name = "invoiceID")
	private Invoice invoice;

	public InvoiceLineItem() {
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Long getInvoiceLineItemID() {
		return invoiceLineItemID;
	}

	public void setInvoiceLineItemID(Long invoiceLineItemID) {
		this.invoiceLineItemID = invoiceLineItemID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
