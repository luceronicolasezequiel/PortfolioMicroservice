package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateExperienceRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateExperienceRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IExperienceService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    private IExperienceService experienceService;

    public ExperienceController(IExperienceService experienceService){
        this.experienceService = experienceService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        try {
            var response = experienceService.getAll();

            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateExperienceRequestDto request) {
        try {
            var response = experienceService.create(request);

            URI experienceURI = URI.create("/api/experience/create/" + response.getId());

            return ResponseEntity.created(experienceURI).body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateExperienceRequestDto request) {
        try {
            var response = experienceService.update(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            experienceService.delete(id);

            return ResponseEntity.noContent().build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

}
