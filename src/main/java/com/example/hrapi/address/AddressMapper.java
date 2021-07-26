package com.example.hrapi.address;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * This interface defines methods' functionalities
 * in the context of SQL queries. It implements mybatis,
 * allowing dynamic SQL statements within the java program.
 *
 * @author Israa Hamieh
 * @version 1.0
 */
@Mapper
public interface AddressMapper {
    /**
     * This method is mapped to an sql select query which chooses
     * an address from the db by its unique id
     *
     * @param id the primary key value in the address table
     * @return Address
     */
    @Select("SELECT id, country, city FROM address WHERE id = #{id}")
    Address findAddressById(Long id);

    /**
     * This method is mapped to an sql select query which chooses
     * an address from the db by its country
     *
     * @param country the country field of a row in the address table
     * @return Address list
     */
    @Select("SELECT id,country,city FROM address WHERE country = #{country}")
    @Results(id = "addressResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "country", column = "country"),
            @Result(property = "city", column = "city")
    })
    List<Address> findAddressByCountry(String country);

    /**
     * This method is mapped to an sql select query which chooses
     * an address from the db by its city
     *
     * @param city the city field of a row in the address table
     * @return Address list
     */
    @Select("SELECT id,country, city FROM address WHERE city = #{city}")
    @ResultMap("addressResultMap")
    List<Address> findAddressByCity(String city);

    /**
     * This method is mapped to an sql select query which inserts
     * a new address row into the database and returns its id from the id column
     *
     * @param address Address Object
     * @return integer which is the id of the inserted Address in the address table
     */

    @Select("INSERT INTO address(country,city) VALUES (#{country},#{city}) RETURNING id;")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insertAddress(Address address);
}
