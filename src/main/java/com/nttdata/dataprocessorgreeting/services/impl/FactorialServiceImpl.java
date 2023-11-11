package com.nttdata.dataprocessorgreeting.services.impl;

import com.nttdata.dataprocessorgreeting.services.FactorialService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class FactorialServiceImpl implements FactorialService {
  @Override
  public BigInteger calculateFactorial(int number) {
    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= number; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }

  @Override
  public Long calculateFactorialTest(int number) {
    long result = 1;
    for(int i = 1; i <= number; i++) {
      result = result * i;
    }
    return result;
  }

}
