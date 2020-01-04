package com.in28minutes.rest.webservices.restwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {


    // filed1 , filed2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){
        SomeBean someBean = new SomeBean("value1","value2","value3");
        return filterResponseField(someBean);
    }

    // filed2 , filed3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListSomeBeans(){
        List<SomeBean> list =  Arrays.asList(new SomeBean("value1","value2","value3"),
                new SomeBean("value12","value22","value32"));
        return filterResponseField(list);

    }

    private MappingJacksonValue filterResponseField(Object list) {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter =
                SimpleBeanPropertyFilter.filterOutAllExcept("filed2","filed3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter",simpleBeanPropertyFilter);
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }

}
