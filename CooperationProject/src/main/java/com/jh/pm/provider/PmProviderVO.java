package com.jh.pm.provider;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jh.pm.provideritem.PmProviderItemJoinItemVO;
import com.jh.pm.provideritem.PmProviderItemVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PmProviderVO {
	private String id;
	private Date regDate; 
	private String bname;
	private String bnumber;
	private String bsector;
	private String chief;
	private String manager; 
	private String tel;
	private String fax;
	private String email;
	private String mobile;
	private String postNo;
	private String address1;
	private String address2;
	private String address3;
	private String memo;
	private String remark1;
	private String remark2;
	
	private List<PmProviderItemVO> pmProviderItemVOs;
	private List<PmProviderItemJoinItemVO> pmProviderJoinItemVOs;
	
	@JsonIgnore
	private int offset;
	@JsonIgnore
	private int limit;
	@JsonIgnore
	private String sort;
	@JsonIgnore
	private String orderBy;	
}
