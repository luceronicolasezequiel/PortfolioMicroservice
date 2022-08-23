package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateProfileRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateFullnameAndTitleRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateSummaryRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.IPersonalInformationService;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

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
            var response = personalInformationService.getOne();

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping("/updateFullnameAndTitle")
    public ResponseEntity<?> updateFullnameAndTitle(@RequestBody @Valid UpdateFullnameAndTitleRequestDto request) {
        try {
            var response = personalInformationService.updateFullnameAndTitle(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PutMapping(value = "/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestParam Integer id, @RequestParam MultipartFile profile) {
        try {
            var request = new UpdateProfileRequestDto(id, profile);

            var response = personalInformationService.updateProfile(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        } catch (IOException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/updateSummary")
    public ResponseEntity<?> updateSummary(@RequestBody @Valid UpdateSummaryRequestDto request) {
        try {
            var response = personalInformationService.updateSummary(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

}
