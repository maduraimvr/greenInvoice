package com.company.greeninvoice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.greeninvoice.dto.Invoice;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice, String>{

//	public void addInvoice(Invoice invoice);
	
//	public List<Invoice> getAll();
}
