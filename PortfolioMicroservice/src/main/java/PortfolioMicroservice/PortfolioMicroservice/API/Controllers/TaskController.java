package PortfolioMicroservice.PortfolioMicroservice.API.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.GetByExperienceTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetByExperienceResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.BLL.ITaskService;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.ITaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private ITaskService taskService;

    public TaskController(ITaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/getByExperience")
    public ResponseEntity<?> getByExperience(@RequestBody @Valid GetByExperienceTaskRequestDto request){
        try {
            var response = taskService.getByExperience(request);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (HttpClientErrorException ex) {
            return new ResponseEntity<String>(ex.getStatusText(), ex.getStatusCode());
        }
    }

}
