package com.exercise.mapper;

import com.exercise.dto.InvoiceDTO;
import com.exercise.entity.Invoice;
import com.exercise.entity.InvoiceLineItem;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);
        factory.classMap(InvoiceDTO.class, Invoice.class).customize(new CustomMapper<InvoiceDTO, Invoice>() {
            @Override
            public void mapAtoB(InvoiceDTO invoiceDTO, Invoice invoice, MappingContext context) {
                super.mapAtoB(invoiceDTO, invoice, context);
                if(invoice.getLineItems() != null){
                    for(InvoiceLineItem invoiceLineItem:invoice.getLineItems()){
                        invoiceLineItem.setInvoice(invoice);
                    }
                }
            }
        }).byDefault().register();
    }

}
