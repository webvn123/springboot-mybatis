package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.mapper.CityMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final CityMapper cityMapper;
    public HomeController(CityMapper cityMapper){
        this.cityMapper = cityMapper;
    }
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public City get(){
        return cityMapper.findById("id","1");
    }
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public List<City> getAll(){
        return  cityMapper.getAll();
    }
}
