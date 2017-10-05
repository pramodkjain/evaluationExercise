package com.exercise.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exercise.entity.Invoice;

import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
	Invoice findByNameIgnoreCase(String name);

	List<Invoice> findByNameIgnoreCaseStartingWith(String name);

}
