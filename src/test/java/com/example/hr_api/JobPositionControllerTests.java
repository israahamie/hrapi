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
public class JobPositionControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getPositionTest() throws Exception {
        helperGetTester("/job-position/1");

    }

    @Test
    public void getPositionByTitleTest() throws Exception {
        helperGetTester("/job-position/title?title=Senior developer");

    }
    @Test
    public void addPositionTest() throws Exception {
        helperPostTester("/job-position/add","10","Supervisor");

    }


    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")))
                .andExpect(content().string(containsString("Senior developer")));

    }

    private void helperPostTester(String requestUrl,String id,String title) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
                .andExpect(content().string(containsString(title)));

    }
}
