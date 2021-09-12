package me.eatnows.bookmanager.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
// JPA metamodel must not be empty! 에러 해결을 위한
// HelloWorldController에서는 jpa가 필요없어서 jpa를 로딩할 수 없었던 것인데, 이 부분을 MockBean으로 처리하여 동작시키는 방법
//@MockBean(JpaMetamodelMappingContext.class)
    
//@SpringBootTest // slice 테스트가 아니라  full 테스트로 로딩을 하는 방법
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // slice 테스트가 아니라  full 테스트로 로딩을 하는 방법 WebMvcTest 애너테이션을 주석처리
//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mockMvc;
//    @BeforeEach // slice 테스트가 아니라  full 테스트로 로딩을 하는 방법
//    void before() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//    }



    @Test
    void helloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello-world"));
    }
}