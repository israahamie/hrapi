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
public class EmployeeDepartmentTests {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getEmployeeDepartmentTest() throws Exception {
        helperGetTester("/employee-department/employee1");

    }
    @Test
    public void addEmployeeDepartmentTest() throws Exception {
        helperPostTester("employee-department/add","7","1","1");

    }


    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")))
                .andExpect(content().string(containsString("6")))
                .andExpect(content().string(containsString("6")));

    }

    private void helperPostTester(String requestUrl,String employeeId,String departmentId,String positionId) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(employeeId)))
                .andExpect(content().string(containsString(departmentId)))
                .andExpect(content().string(containsString(positionId)));

    }
}
