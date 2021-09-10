package com.example.APIBigboss.api;

import com.example.APIBigboss.models.City;
import com.example.APIBigboss.models.ContactNew;
import com.example.APIBigboss.repository.CityRepository;
import com.example.APIBigboss.repository.ContactNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/contact-new")
public class ContactNewAPI {
  
}
