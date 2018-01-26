package com.company.greeninvoice.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.greeninvoice.dao.InvoiceDao;
import com.company.greeninvoice.dto.Customer;
import com.company.greeninvoice.dto.Invoice;
import com.company.greeninvoice.entity.ItemDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	public static final String EMPTY_STRING = "";
	
	public static final String INVOICE_CODE = "INV";
	
	public static final String SEPERATOR = "-";
	
	public static final String DEFAULT_INVOICE_NUMBER = "0000";
	
	public static final String INVOICE_FORMATTER = "%04d";
	
	@Autowired
	InvoiceDao invoiceDao;
	
//	public void setInvoiceDao(InvoiceDao invoiceDao){
//	     this.invoiceDao = invoiceDao;
//	  }
	
	@Transactional
	@Override
	public String generateInvoiceNumber() {
		insertRecord();
		String invoiceNumber = EMPTY_STRING;
//		List<Invoice> invoiceList=invoiceDao.getAll();
//		List<Invoice> invoiceList=new ArrayList<>();
//		if(Objects.nonNull(invoiceList)) {
//			int totalInvoiceNumber = invoiceList.size();
//			if(totalInvoiceNumber==0) {
//				LocalDate todayDate=LocalDate.now();
//				String yearCode = String.valueOf(todayDate.getYear()%1000);
//				String monthCode = LocalDate.now().getMonth().name().substring(0, 3);
//				invoiceNumber=INVOICE_CODE+SEPERATOR+yearCode+monthCode+SEPERATOR+DEFAULT_INVOICE_NUMBER;
//			}else {
//				if(StringUtils.isEmpty(invoiceNumber)) {
//					LocalDate todayDate=LocalDate.now();
//					String[] invoiceCodeArray = invoiceNumber.split(SEPERATOR);
//					int lastInvoiceNumber=Integer.parseInt(invoiceCodeArray[2]);
//					String number = String.format(INVOICE_FORMATTER, lastInvoiceNumber+1);
//					String yearCode = String.valueOf(todayDate.getYear()%1000);
//					String monthCode = LocalDate.now().getMonth().name().substring(0, 3);
//					invoiceNumber=INVOICE_CODE+SEPERATOR+yearCode+monthCode+SEPERATOR+number;
//				}
//			}
//		}
		return invoiceNumber;
	}

	private void insertRecord() {
		Invoice invoice=new Invoice();
		List<ItemDetail> itemdetailsList=new ArrayList<>();
		ItemDetail itemDetail=new ItemDetail();
		LocalDate todayDate=LocalDate.now();
		String yearCode = String.valueOf(todayDate.getYear()%1000);
		String monthCode = LocalDate.now().getMonth().name().substring(0, 3);
		String invoiceNumber=INVOICE_CODE+SEPERATOR+yearCode+monthCode+SEPERATOR+"0001";
		invoice.setInvoiceNumber(invoiceNumber);
		Customer customer=new Customer();
		customer.setCustomerName("VENKAT");
		customer.setMale(true);
		invoice.setCustomerDetails(customer);
		invoice.setTotalAmount((float) 25.02);
		invoice.setInvoiceDate(Date.valueOf(todayDate));
		itemDetail.setSerialNumber("2");
		itemDetail.setItemDescription("Pencil");
		itemDetail.setItemQuantity(2);
		itemDetail.setItemRate(25);
		itemDetail.setAmount(50);
		itemdetailsList.add(itemDetail);
		invoice.setItemdetailsList( itemdetailsList);
//		JSONObject responseDetailsJson = new JSONObject();
//		JSONArray jsonArray = new JSONArray();
//		invoice.getItemdetailsList().stream().forEach(action->{
//			JSONObject formDetailsJson = new JSONObject();
//			 formDetailsJson.put("serialNumber", action.getSerialNumber());
//			 formDetailsJson.put("itemDescription", action.getItemDescription());
//			 formDetailsJson.put("itemQuantity", action.getItemQuantity());
//			 formDetailsJson.put("itemRate", action.getItemRate());
//			 formDetailsJson.put("amount", action.getAmount());
//			 jsonArray.put(responseDetailsJson);
//		});
//		responseDetailsJson.put("itemDetails", jsonArray);
		System.out.println("--------------------------------------------------------------------------------");
//		System.out.println(responseDetailsJson);
		System.out.println("--------------------------------------------------------------------------------");
		ObjectMapper obj=new ObjectMapper();
//		invoice.setItemDetailListJSON(responseDetailsJson.toString());
		
//		objectmapper.
//		invoiceDao.addInvoice(invoice);
		invoiceDao.save(invoice);
	}

}
