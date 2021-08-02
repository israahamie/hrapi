package com.example.hrapi.company;

import com.example.hrapi.address.AddressNotFoundException;
import com.example.hrapi.company.request.NewCompanyRequest;
import com.example.hrapi.company.response.CompaniesResponse;
import com.example.hrapi.company.response.CompanyResponse;
import com.example.hrapi.shared.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CompanyController defines methods that can retrieve
 * companies and insert companies from and to the company table of the
 * database.
 * This class provides the definition as http GET and POST methods
 * and implements CompanyMapper interface, which defines the SQL definitions.
 */


@RestController
@RequestMapping("/company")
@AllArgsConstructor
@Log4j2
public class CompanyController {

    private final CompanyMapper companyMapper;
    private final CompanyLogic companyLogic;

    /**
     * method gets the company by matching it to its id
     *
     * @param id the company entry's unique identifying id
     * @return a Company object
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<CompanyResponse>> getCompany(@PathVariable Long id) {
        log.info("Invoke getCompany Method, id: {}", id);
        CompanyResponse response = new CompanyResponse();
        response.setCompany(companyMapper.findCompanyById(id));
        log.info("Return Response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the company by matching it to its name which is unique(copyrighted)
     *
     * @param name the company's name
     * @return a Company object
     */
    @GetMapping("/name")
    public ResponseEntity<ResponseBody<CompanyResponse>> getCompanyByName(@RequestParam String name) {
        log.info("Invoke getCompanyByName Method, name: {}", name);
        CompanyResponse response = new CompanyResponse();
        response.setCompany(companyMapper.findCompanyByName(name));
        log.info("Return Response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the company by matching it to its address id
     *
     * @param addressId the company's link to its address present in the address table
     * @return a list of companies
     */
    @GetMapping("/address")
    public ResponseEntity<ResponseBody<CompanyResponse>> findCompanyByAddress(@RequestParam Long addressId) {

        log.info("Invoke getCompanyByAddress Method, address id: {}", addressId);
        CompaniesResponse response = new CompaniesResponse();
        response.setCompanies(companyMapper.findCompanyByAddress(addressId));
        log.info("Return Response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method inserts a new company into the database
     * must commit the insertion due to changing the database (adding a row)
     *
     * @param newCompanyRequest the values to be inserted
     *                          into the columns of the database
     * @return a response entity containing the details of the company entry
     * inserted and the status code of the request
     * @throws AddressNotFoundException in case the foreign
     *                                  * key of the address is not found in the address table
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseBody<CompanyResponse>> addCompany(@RequestBody NewCompanyRequest newCompanyRequest) {
        log.info("invoke addCompany method, New Company Request :{}", newCompanyRequest);
        /*
        Inserting the new Company in the database.
         */
        CompanyResponse response = companyLogic.addCompany(
                newCompanyRequest.getName(),
                newCompanyRequest.getAddressId());
        /*
        Returning response entity
         */
        log.info("Return CompanyResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));


    }
}