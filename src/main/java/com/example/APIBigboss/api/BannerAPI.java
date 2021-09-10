package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Banner;
import com.example.APIBigboss.models.Menu;
import com.example.APIBigboss.repository.BannerRepository;
import com.example.APIBigboss.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/banner")
public class BannerAPI {
   
}
