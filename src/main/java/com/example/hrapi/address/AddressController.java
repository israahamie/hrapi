package com.example.hrapi.address;

import com.example.hrapi.address.request.NewAddressRequest;
import com.example.hrapi.address.response.AddressResponse;
import com.example.hrapi.address.response.AddressesResponse;
import com.example.hrapi.shared.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The AddressController class links java method definitions
 * to their equivalent SQL statements/queries present in the
 * corresponding AddressMapper interface.
 * <p>
 * These methods can both read addresses from the database and
 * insert addresses into the address table of the hr database.
 * <p>
 * This enables the communication with the hr database via the
 * web's http methods.
 *
 * @author Israa Hamieh
 */
@RestController
@RequestMapping("/address")
@AllArgsConstructor
@Log4j2
public class AddressController {

    private AddressMapper addressMapper;
    private AddressLogic addressLogic;

    public AddressController() {

    }


    /**
     * method gets the address by matching it to its id
     *
     * @param id the address entry's unique identifying id
     * @return an Address object
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<AddressResponse>> getAddress(@PathVariable Long id) {
        log.info("Invoke getAddress Method, id: {}", id);
        AddressResponse response = new AddressResponse();
        response.setAddress(addressMapper.findAddressById(id));
        log.info("Return Response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets addresses with matching country fields
     *
     * @param country the address entries' country field
     * @return list of Addresses
     */
    @GetMapping("/country")
    public ResponseEntity<ResponseBody<AddressResponse>> getAddressByCountry(@RequestParam String country) {
        log.info("Invoke getAddressByCountry Method, country: {}", country);
        AddressesResponse response = new AddressesResponse();
        response.setAddresses(addressMapper.findAddressByCountry(country));
        log.info("Return Response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets addresses with matching city fields
     *
     * @param city the address entries' city field inputted into method as a String
     * @return list of Addresses
     */
    @GetMapping("/city")
    public ResponseEntity<ResponseBody<AddressResponse>> getAddressByCity(@RequestParam String city) {
        log.info("Invoke getAddressByCity Method, city: {}", city);
        AddressesResponse response = new AddressesResponse();
        response.setAddresses(addressMapper.findAddressByCity(city));
        log.info("Return Response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method inserts a new address into the database
     * must commit the insertion due to changing the database (adding a row)
     *
     * @param newAddressRequest object the values to be inserted into
     *                          the corresponding columns of the database
     * @return a response entity containing the details of the Address
     * inserted as well as status code
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseBody<AddressResponse>> addAddress(@RequestBody NewAddressRequest newAddressRequest) {
        log.info("invoke addAddress method, New Address Request :{}", newAddressRequest);
        /*
        Inserting the new Address in the database.
         */
        AddressResponse response = addressLogic.addAddress(
                newAddressRequest.getCountry(),
                newAddressRequest.getCity());
        /*
        Returning response entity
         */
        log.info("Return AddressResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));


    }
}

