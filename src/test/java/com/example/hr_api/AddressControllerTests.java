package com.example.hr_api;

import com.example.hrapi.address.AddressController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTests {

    @Autowired
    private MockMvc mvc;

    private AddressController addressController = new AddressController();



    @Test
    public void getAddressTest() throws Exception {
        helperGetTester("/address/1");

    }

    @Test
    public void getAddressByCityTest() throws Exception {
        helperGetTester("/address/city?city=Beirut");

    }
    @Test
    public void getAddressByCountryTest() throws Exception {
        helperGetTester("/address/country?country=Lebanon");

    }
    @Test
    public void addAddressTest() throws Exception {
        helperPostTester("/address/add","17","Kyoto","Japan");

    }


    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")))
                .andExpect(content().string(containsString("Lebanon")))
                .andExpect(content().string(containsString("Beirut")));

    }

    private void helperPostTester(String requestUrl,String id,String city,String country) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
                .andExpect(content().string(containsString(city)))
                .andExpect(content().string(containsString(country)));

    }
}
