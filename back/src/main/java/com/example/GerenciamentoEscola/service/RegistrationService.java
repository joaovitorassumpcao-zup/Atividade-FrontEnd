package com.example.GerenciamentoEscola.service;

import com.example.GerenciamentoEscola.model.CourseModel;
import com.example.GerenciamentoEscola.model.RegistrationModel;
import com.example.GerenciamentoEscola.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
  @Autowired
  RegistrationRepository registrationRepository;
  
  public RegistrationModel createRegistration(RegistrationModel registrationModel) {
    return registrationRepository.save(registrationModel);
  }
  public List<RegistrationModel> findAllRegistrations() {
    return registrationRepository.findAll();
  }

  public Optional<RegistrationModel> findOneRegistration(Long id) {
    return registrationRepository.findById(id);
  }
  
  public RegistrationModel updateCourse(Long id, RegistrationModel registrationModel) {
    RegistrationModel registration = registrationRepository.findById(id).get();
    if(registrationModel.getCourse() != null) {
      registrationModel.setCourse(registrationModel.getCourse());
    }
    return registrationRepository.save(registration);
  }
}
