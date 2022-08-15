package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private ITaskService taskService;

    public TaskController(ITaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/getByExperience/{experienceId}")
    public ResponseEntity<?> getByExperience(@PathVariable Integer experienceId){
        try {
            var response = taskService.getByExperience(experienceId);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CreateTaskRequestDto request) {
        try {
            var response = taskService.create(request);

            URI experienceURI = URI.create("/api/task/create/" + response.getId());

            return ResponseEntity.created(experienceURI).body(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

}
