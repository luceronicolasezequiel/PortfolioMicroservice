package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateHabilityRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateHabilityRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IHabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/hability")
public class HabilityController {
    private IHabilityService habilityService;

    public HabilityController(IHabilityService habilityService) {
        this.habilityService = habilityService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            var response = habilityService.getAll();

            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateHabilityRequestDto request) {
        try {
            var response = habilityService.create(request);

            URI experienceURI = URI.create("/api/hability/create/" + response.getId());

            return ResponseEntity.created(experienceURI).body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateHabilityRequestDto request) {
        try {
            var response = habilityService.update(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

}
