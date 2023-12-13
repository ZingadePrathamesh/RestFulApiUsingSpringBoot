package com.example.restful.restfulapiusingspringboot.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	@GetMapping(path = "/filter")
	public MappingJacksonValue filterOne() {
		FilterBeanExample filterBeanExample = new FilterBeanExample("value 1", "value 2", "value 3");
		
		MappingJacksonValue mappingJacksonValue = mappingJacksonValueProvider(filterBeanExample, "FilterBeanExample", "field1");
		
		return mappingJacksonValue;
	}
	
	@GetMapping(path = "/filter-list")
	public MappingJacksonValue filterAll(){
		
		List<FilterBeanExample> listOfFilterBeanExample = Arrays.asList(new FilterBeanExample("v1", "v2", "v3"),
				new FilterBeanExample("v1", "v2", "v3"),
				new FilterBeanExample("v1", "v2", "v3")
				);
		
		MappingJacksonValue mappingJacksonValue = mappingJacksonValueProvider(listOfFilterBeanExample, "FilterBeanExample" ,"field3", "field2");
		
		return mappingJacksonValue;
	}

	private MappingJacksonValue mappingJacksonValueProvider(List<?> listOfFilterBeanExample, String id ,String...strings ) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(listOfFilterBeanExample);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(strings);
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(id, filter);
		
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
	
	private MappingJacksonValue mappingJacksonValueProvider(FilterBeanExample beanExample , String id ,String...strings ) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(beanExample);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(strings);
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(id, filter);
		
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}

}
