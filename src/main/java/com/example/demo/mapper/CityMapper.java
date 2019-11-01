package com.example.demo.mapper;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityMapper {
    //@Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(City city);

    //@Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
    City findById(@Param("cid") String id,@Param("id") String cid);
    List<City> getAll();
}
