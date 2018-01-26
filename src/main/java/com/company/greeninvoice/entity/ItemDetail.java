package com.company.greeninvoice.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * ItemDetail is bean class.
 * @author Venkatraman
 *
 */
@Data
@Embeddable
@Entity
@Table(name="itemdetailpojodto")
public class ItemDetail  implements Serializable{

	@Id
	 private String serialNumber;
	
	 private String itemDescription;
	
	 private int itemQuantity;
	 
	 private float itemRate;
	
	 private float amount;

}
