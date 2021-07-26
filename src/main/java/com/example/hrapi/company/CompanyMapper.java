package com.example.hrapi.company;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * CompanyMapper defines the SQL functionality of the methods in CompanyController.
 * These methods allow communication with the hr database.
 */
@Mapper
public interface CompanyMapper {
    /**
     * This method is mapped to an sql select query which chooses
     * a company from the db by its unique id
     *
     * @param id the primary key value in the company table
     * @return Company
     */
    @Select("SELECT id, name, fk_address_id  FROM company WHERE id = #{id}")
    @Results(id = "companyResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "address", column = "fk_address_id", one =
            @One(select = "com.example.hrapi.address.AddressMapper.findAddressById"))
    })
    Company findCompanyById(Long id);

    /**
     * This method is mapped to an sql select query which chooses
     * a company from the db by its name
     *
     * @param name the name field in the company table
     * @return Company object
     */
    @Select("SELECT id, name, fk_address_id FROM company WHERE name = #{name}")
    @ResultMap("companyResultMap")
    Company findCompanyByName(String name);

    /**
     * This method is mapped to an sql select query which chooses
     * a company from the db by its address
     *
     * @param address_id the primary key value in the address table
     *                   referenced in the company table
     * @return list of Companies
     */
    @Select("SELECT id, name, fk_address_id FROM company WHERE fk_address_id = #{address.id};")
    @ResultMap("companyResultMap")
    List<Company> findCompanyByAddress(Long address_id);

    /**
     * This method is mapped to an sql insert query which inserts a new company
     *
     * @param company Company Object
     * @return Long which is the id of the inserted Company
     */
    @Select("INSERT INTO company(name,fk_address_id) VALUES (#{name},#{address.id}) RETURNING id;")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    Long insertCompany(Company company);

}
