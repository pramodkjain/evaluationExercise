package com.exercise.mapper;

import com.exercise.dto.InvoiceDTO;
import com.exercise.dto.InvoiceLineItemDTO;
import com.exercise.entity.Invoice;
import com.exercise.entity.InvoiceLineItem;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class InvoiceLineItemMapper extends ConfigurableMapper {
	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);
		factory.classMap(InvoiceLineItemDTO.class, InvoiceLineItem.class).byDefault().register();
	}

}
