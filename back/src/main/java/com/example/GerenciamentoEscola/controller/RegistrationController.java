package com.example.GerenciamentoEscola.controller;

import com.example.GerenciamentoEscola.model.CourseModel;
import com.example.GerenciamentoEscola.model.RegistrationModel;
import com.example.GerenciamentoEscola.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/registration")
public class RegistrationController {
  @Autowired
  RegistrationService registrationService;

  @GetMapping
  public List<RegistrationModel> findAllRegistrations() {
    return registrationService.findAllRegistrations();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RegistrationModel newRegister(@RequestBody RegistrationModel registrationModel){
    return registrationService.createRegistration(registrationModel);
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<?> updateCourse(@PathVariable Long id, @RequestBody RegistrationModel course) {
    Optional<RegistrationModel> optionalRegistration = registrationService.findOneRegistration(id);
    if(optionalRegistration.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado!");
    }
    registrationService.updateCourse(id, course);
    return null;
  }
}
