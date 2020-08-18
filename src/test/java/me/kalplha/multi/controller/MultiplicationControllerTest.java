package me.kalplha.multi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kalplha.multi.entity.Multiplication;
import me.kalplha.multi.service.MultiplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MultiplicationController.class)
class MultiplicationControllerTest {
    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // 이 객체는 initFields() 메서드를 이용해 자동으로 초기화
    private JacksonTester<Multiplication> json;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void whenGetRandomMultiplication_ConnectResponse() throws Exception {
        //given
        given(multiplicationService.createRandomMultiplication())
                .willReturn(new Multiplication(70, 20));

        //when
        MockHttpServletResponse response = mockMvc.perform(get("/multiplications/random")
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn()
                .getResponse();

        //test
        assertTrue(response.getStatus() == HttpStatus.OK.value());
        assertTrue(response.getContentAsString().contentEquals(json.write(new Multiplication(70, 20)).getJson()));
    }


    @Test
    public void whenGetRandomMultiplication_ConnectResponse2() throws Exception {
        //given
        given(multiplicationService.createRandomMultiplication())
                .willReturn(new Multiplication(70, 20));

        //when & test
        mockMvc.perform(get("/multiplications/random")
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("result").value("1400"));
    }
}