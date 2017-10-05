package com.exercise.dto;

public class InvoiceLineItemDTO {
	private Long invoiceLineItemID;
	private String description;
	private double amount;

	public InvoiceLineItemDTO() {
	}

	public InvoiceLineItemDTO(String descriptionArg, double amountArg) {
		this.description = descriptionArg;
		this.amount = amountArg;
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
