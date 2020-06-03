package com.jh.pm.provideritem;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PmProviderItemVO {
	private String id;
	private String tbitem_ID;
	private String tbProvider_ID;
	private String price;
	private String weight;
	private Date updateDate;
	private String memo;
	private String remark1;
	private String remark2;
}
