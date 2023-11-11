package com.nttdata.dataprocessorgreeting.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nttdata.dataprocessorgreeting.services.FactorialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.math.BigInteger;

@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private FactorialService factorialService;

  @BeforeEach
  void setUp() {
    // Set up any required preconditions or mocks here
  }

  @Test
  public void returnGreetingMessage() throws Exception {
    mockMvc.perform(get("/api/hola")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.saludo").value("Hola equipo X-FORCE!"));
  }

  @Test
  public void calculateFactorial() throws Exception {
    int testNumber = 5;
    BigInteger expectedFactorial = BigInteger.valueOf(120); // Expected result for 5!

    when(factorialService.calculateFactorial(testNumber)).thenReturn(expectedFactorial);

    mockMvc.perform(get("/api/factorial/" + testNumber)
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.factorial").value(expectedFactorial.intValue()));
  }

}