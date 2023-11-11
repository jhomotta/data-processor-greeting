package com.nttdata.dataprocessorgreeting.controllers;

import com.nttdata.dataprocessorgreeting.services.FactorialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@Slf4j
public class GreetingController {

  @Autowired
  private FactorialService factorialService;


  @GetMapping("/hola")
  public ResponseEntity<Map<String, String>> greeting() {
    Map<String, String> response = new HashMap<>();
    response.put("saludo", "Hola equipo X-FORCE!");
    return ResponseEntity.ok(response);
  }



  @GetMapping("/factorial/{numero}")
  public ResponseEntity<Map<String, Object>> calculateFactorial(@PathVariable("numero") int numero) {
    Map<String, Object> response = new HashMap<>();
    response.put("factorial", factorialService.calculateFactorial(numero));
    return ResponseEntity.ok(response);
  }

}
