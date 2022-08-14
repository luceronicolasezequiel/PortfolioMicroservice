package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateFullnameAndTitleRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateSummaryRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IPersonalInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/personalInformation")
public class PersonalInformationController {

    private IPersonalInformationService personalInformationService;

    public PersonalInformationController(IPersonalInformationService personalInformationService) {
        this.personalInformationService = personalInformationService;
    }

    @GetMapping("/getOne")
    public ResponseEntity<?> getOne() {
        try {
            var personalInformation = personalInformationService.getOne();

            return ResponseEntity.ok(personalInformation);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping("/updateFullnameAndTitle")
    public ResponseEntity<?> updateFullnameAndTitle(@RequestBody @Valid UpdateFullnameAndTitleRequestDto request) {
        try {
            var personalInformation = personalInformationService.updateFullnameAndTitle(request);

            return ResponseEntity.ok(personalInformation);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping("/updateSummary")
    public ResponseEntity<?> updateSummary(@RequestBody @Valid UpdateSummaryRequestDto request) {
        try {
            var personalInformation = personalInformationService.updateSummary(request);

            return ResponseEntity.ok(personalInformation);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }
}
