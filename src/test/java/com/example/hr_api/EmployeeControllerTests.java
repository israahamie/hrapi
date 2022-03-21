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
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getEmployeeTest() throws Exception {
        helperGetTester("/employee/2");

    }

    @Test
    public void getEmployeeByNameTest() throws Exception {
        helperGetTester("/employee/name?firstName=jane");

    }
    @Test
    public void getEmployeeBySurnameTest() throws Exception {
        helperGetTester("/employee/surname?lastName=doe");

    }

    @Test
    public void getEmployeeByAddressTest() throws Exception {
        helperGetTester("/employee/address-id?addressId=3");

    }
    @Test
    public void getEmployeeByNumberTest() throws Exception {
        helperGetTester("/employee/number?phoneNumber=+96171833944");

    }
    @Test
    public void addEmployeeTest() throws Exception {
        helperPostTester("/employee/add","13","Shoyo","Hinata","+23249384894","2");

    }


    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("2")))
                .andExpect(content().string(containsString("jane")))
                .andExpect(content().string(containsString("doe")))
                .andExpect(content().string(containsString("+96171833944")))
                .andExpect(content().string(containsString("3")));

    }

    private void helperPostTester(String requestUrl,String id,String name,String surname,String number,String addressId) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
                .andExpect(content().string(containsString(name)))
                .andExpect(content().string(containsString(surname)))
                .andExpect(content().string(containsString(number)))
                .andExpect(content().string(containsString(addressId)));

    }
}
