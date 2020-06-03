package com.jh.pm.item;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PmDeleteItemIdList {
	private List<Map<String, String>> ids;
}
