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
public class JobGradeControllerTests {

    @Autowired
    private MockMvc mvc;



    @Test
    public void getJobGradeTest() throws Exception {
        helperGetTester("/job-grade/1");

    }

    @Test
    public void getJobGradeByEmployeeTest() throws Exception {
        helperGetTester("/job-grade/employee?employeeId=2");

    }
    @Test
    public void getJobGradeByPositionTest() throws Exception {
        helperGetTester("/job-grade/position?positionId=2");

    }
    @Test
    public void getJobGradeByDepartmentTest() throws Exception {
        helperGetTester("/job-grade/department?departmentId=3");

    }
    @Test
    public void getJobGradeByGradeTest() throws Exception {
        helperGetTester("/job-grade/grade?grade=7");

    }
    @Test
    public void addJobGradeTest() throws Exception {
        helperPostTester("/job-grade/add","10","2","2","2","2");

    }


    private void helperGetTester(String requestUrl) throws Exception {
        this.mvc.perform(get(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1")))
                .andExpect(content().string(containsString("2")))
                .andExpect(content().string(containsString("3")))
                .andExpect(content().string(containsString("7")));

    }

    private void helperPostTester(String requestUrl,String id,String employee,String department,String position,String grade) throws Exception {
        this.mvc.perform(post(requestUrl))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
                .andExpect(content().string(containsString(employee)))
                .andExpect(content().string(containsString(grade)))
                .andExpect(content().string(containsString(department)))
                .andExpect(content().string(containsString(position)));

    }
}
