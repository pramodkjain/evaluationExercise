package com.exercise.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceDTO {
	private Long invoiceID;
	private String name;
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	private List<InvoiceLineItemDTO> lineItems = new ArrayList<InvoiceLineItemDTO>();

	public InvoiceDTO() {
	}

	public InvoiceDTO(String nameArg, String emailArg, Date dueDateArg) {
		this.name = nameArg;
		this.email = emailArg;
		this.dueDate = dueDateArg;
	}

	public Long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(Long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<InvoiceLineItemDTO> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<InvoiceLineItemDTO> lineItems) {
		this.lineItems = lineItems;
	}

}
