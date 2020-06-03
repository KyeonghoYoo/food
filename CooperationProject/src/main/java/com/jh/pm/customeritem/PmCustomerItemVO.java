package com.jh.pm.customeritem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class PmCustomerItemVO {
	private String id;
	private String tbCustomer_ID;
	private String tbItem_ID;
	private String regDate;
	private String memo;
	private String remark1;
	private String remark2;
		
}
