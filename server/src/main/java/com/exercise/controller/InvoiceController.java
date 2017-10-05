package com.exercise.controller;

import com.exercise.entity.InvoiceLineItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.dto.InvoiceDTO;
import com.exercise.entity.Invoice;
import com.exercise.mapper.InvoiceMapper;
import com.exercise.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	private Log log = LogFactory.getLog(this.getClass());
	private List<String> invoiceLineItemsList = Arrays.asList("regular", "referral bonus", "reward", "bonus quaterly", "paid time off");

	@Autowired
	private InvoiceMapper invoiceMapper;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@RequestMapping(value = "invoice/{name}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InvoiceDTO>> getInvoice(@PathVariable String name) {
		try {
			Invoice invoice = invoiceRepository.findByNameIgnoreCase(name);
			// invoice.getLineItems();
			InvoiceDTO invoiceDTOResult = invoiceMapper.dedicatedMapperFor(InvoiceDTO.class, Invoice.class).mapReverse(invoice);
			ResponseEntity responseEntity = new ResponseEntity(invoiceDTOResult, HttpStatus.OK);
			return responseEntity;
		} catch (Exception ex) {
			log.error("Fatal Error!", ex);
			return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
		}
	}

	private void resetIdIfNameAlreadyExist(InvoiceDTO invoiceDTO) {
		if (invoiceDTO != null) {
			invoiceDTO.setInvoiceID(0L);
			if (invoiceDTO.getLineItems() != null) {
				invoiceDTO.getLineItems().stream().forEach(p -> p.setInvoiceLineItemID(0L));
			}
		}

	}

	@RequestMapping(value = "invoice", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveInvoice(@RequestBody InvoiceDTO invoiceDTO) {
		try {

			Invoice invoiceExist = invoiceRepository.findByNameIgnoreCase(invoiceDTO.getName());
			if (invoiceExist == null) {
				// This is case when user decides to modify, but instead changes the invoice name
				resetIdIfNameAlreadyExist(invoiceDTO);
			}
			Invoice invoice = invoiceRepository.save(invoiceMapper.map(invoiceDTO, Invoice.class));
			InvoiceDTO invoiceDTOResult = invoiceMapper.dedicatedMapperFor(InvoiceDTO.class, Invoice.class).mapReverse(invoice);
			ResponseEntity responseEntity = new ResponseEntity(invoiceDTOResult, HttpStatus.OK);
			return responseEntity;
		} catch (Exception ex) {
			String errorMsg = "Fatal Error!";
			log.error(errorMsg, ex);
			return new ResponseEntity(errorMsg, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "lineItem/suggest", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> lineItemSuggest(@RequestParam String q) {
		List<String> suggestion = invoiceLineItemsList.stream().filter(p -> p.startsWith(q)).collect(Collectors.toList());
		return new ResponseEntity(suggestion, HttpStatus.OK);
	}

	@RequestMapping(value = "invoiceName/suggest", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> invoiceNameSuggest(@RequestParam String q) {
		List<Invoice> invoices = invoiceRepository.findByNameIgnoreCaseStartingWith(q);
		List<String> suggestion = invoices.stream().map(p -> p.getName()).collect(Collectors.toList());
		return new ResponseEntity(suggestion, HttpStatus.OK);
	}

}
