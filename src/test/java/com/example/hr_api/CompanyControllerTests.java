package com.example.hr_api;

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
public class CompanyControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getCompanyTest() throws Exception {
        helperGetTester("/company/2");

    }

    @Test
    public void getCompanyByNameTest() throws Exception {
        helperGetTester("/company/name?name=Cisco");

    }
    @Test
    public void getCompanyByAddressIdTest() throws Exception {
        helperGetTester("/company/address?addressId=3");

    }
    @Test
    public void addCompanyTest() throws Exception {
        helperPostTester("/company/add","10","Garnier","3");

    }
    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2")))
                .andExpect(content().string(containsString("Cisco")))
                .andExpect(content().string(containsString("3")));

    }

    private void helperPostTester(String requestUrl,String id,String name,String addressId) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
                .andExpect(content().string(containsString(name)))
                .andExpect(content().string(containsString(addressId)));

    }
}
