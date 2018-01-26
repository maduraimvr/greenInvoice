package com.company.greeninvoice.service;

import org.springframework.stereotype.Service;

@Service
public interface InvoiceService {

	/**
	 * generateInvoiceNumber method to initially generate invoice number sequentially.
	 * @return invoiceNumber
	 */
	String generateInvoiceNumber();
}
