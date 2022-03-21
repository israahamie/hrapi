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
public class DepartmentControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDepartmentTest() throws Exception {
        helperGetTester("/department/1");

    }

    @Test
    public void getDepartmentByNameTest() throws Exception {
        helperGetTester("/department/name?name=marketing");

    }

    @Test
    public void addDepartmentTest() throws Exception {
        helperPostTester("/department/add","10","Trade");

    }


    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")))
                .andExpect(content().string(containsString("marketing")));

    }

    private void helperPostTester(String requestUrl,String id,String name) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
                .andExpect(content().string(containsString(name)));

    }
}
