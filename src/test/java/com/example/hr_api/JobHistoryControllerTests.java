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
public class JobHistoryControllerTests {
    @Autowired
    private MockMvc mvc;


    @Test
    public void getJobHistoryByEmployeeTest() throws Exception {
        helperGetTester("/job-history/employee?employeeId=4");

    }
    @Test
    public void addAddressTest() throws Exception {
        helperPostTester("/job-history/add","1","1","1",
                "23-02-2000","23-05-2001","false");

    }


    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")))
                .andExpect(content().string(containsString("4")))
                .andExpect(content().string(containsString("2")))
                .andExpect(content().string(containsString("false")))
                .andExpect(content().string(containsString("1995-08-23")))
                .andExpect(content().string(containsString("1995-08-23")));

    }

    private void helperPostTester(String requestUrl,String employee,String company,String position,
                                  String fromDate,String toDate,String isCurrent) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(employee)))
                .andExpect(content().string(containsString(company)))
                .andExpect(content().string(containsString(position)))
                .andExpect(content().string(containsString(fromDate)))
                .andExpect(content().string(containsString(toDate)))
                .andExpect(content().string(containsString(isCurrent)));

    }
}
