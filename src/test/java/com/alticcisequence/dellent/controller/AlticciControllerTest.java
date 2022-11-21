package com.alticcisequence.dellent.controller;

import com.alticcisequence.dellent.service.AlticciService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AlticciController.class)
class AlticciControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AlticciService service;

    @BeforeEach
    void main(){
        when(service.calculate(anyInt())).thenCallRealMethod();
    }

    @Test
    void baseCase0() throws Exception {
        mockMvc.perform(get("/alticci/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(0)));
    }
    @Test
    void baseCase1() throws Exception {
        mockMvc.perform(get("/alticci/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(1)));
    }
    @Test
    void baseCase2() throws Exception {
        mockMvc.perform(get("/alticci/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(1)));
    }
    @Test
    void baseCase10() throws Exception {
        mockMvc.perform(get("/alticci/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.is(9)));
    }
    @Test()
    void negativeValue() {
        assertThatThrownBy(() -> mockMvc.perform(get("/alticci/-1"))
                .andExpect(status().isInternalServerError())).isInstanceOf(NestedServletException.class).hasMessageContaining("Request processing failed; nested exception is javax.validation.ConstraintViolationException: getAlticciValue.n: must be greater than or equal to 0");
    }

}
