package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IHabilityGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IHabilityService;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IHabilityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

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
}
