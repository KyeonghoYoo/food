package com.jh.common;

import org.springframework.validation.Errors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CommonObejcMapper {
	

	public ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Errors.class, new ErrorSerializer());
		
        objectMapper.registerModule(simpleModule);
        
        return objectMapper;
	}

}
