package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateProyectRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.DeleteProyectRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IProyectGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateProyectRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IProyectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/proyect")
public class ProyectController {
    private IProyectService proyectService;

    public ProyectController(IProyectService proyectService) {
        this.proyectService = proyectService;
    }

    @GetMapping("/getAll")
    public List<IProyectGetAllResponseDto> getAll() {
        var response = proyectService.getAll();

        return response;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateProyectRequestDto request) {
        try {
            var response = proyectService.create(request);

            URI experienceURI = URI.create("/api/proyect/create/" + response.getId());

            return ResponseEntity.created(experienceURI).body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateProyectRequestDto request) {
        try {
            var response = proyectService.update(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteProyectRequestDto request) {
        try {
            proyectService.delete(request);

            return ResponseEntity.noContent().build();
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

}
