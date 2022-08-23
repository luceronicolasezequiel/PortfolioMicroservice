package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.DeleteEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateEducationRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IEducationService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private IEducationService educationService;

    public EducationController(IEducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            var response = educationService.getAll();

            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateEducationRequestDto request) {
        try {
            var response = educationService.create(request);

            URI experienceURI = URI.create("/api/education/create/" + response.getId());

            return ResponseEntity.created(experienceURI).body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateEducationRequestDto request) {
        try {
            var response = educationService.update(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteEducationRequestDto request) {
        try {
            educationService.delete(request);

            return ResponseEntity.noContent().build();
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

}
