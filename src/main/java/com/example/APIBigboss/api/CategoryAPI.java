package com.example.APIBigboss.api;
import com.example.APIBigboss.models.Category;
import com.example.APIBigboss.payload.response.MessageResponse;
import com.example.APIBigboss.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryAPI {
   
}
