package com.example.restful.restfulapiusingspringboot.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	@GetMapping(path = "/filter")
	public FilterBeanExample filterOne() {
		FilterBeanExample filterBeanExample = new FilterBeanExample("value 1", "value 2", "value 3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filterBeanExample);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilterBeanExample", filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return filterBeanExample;
	}

}
