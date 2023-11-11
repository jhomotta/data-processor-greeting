package com.nttdata.dataprocessorgreeting.services;

import static org.junit.jupiter.api.Assertions.*;

import com.nttdata.dataprocessorgreeting.services.FactorialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
public class FactorialServiceTest {

  @Autowired
  private FactorialService factorialService;

  @Test
  public void calculateFactorial_BaseCase() {
    assertEquals(BigInteger.valueOf(6), factorialService.calculateFactorial(3));
  }

  @Test
  public void calculateFactorial_Five() {
    assertEquals(BigInteger.valueOf(362880), factorialService.calculateFactorial(9));
  }

}
