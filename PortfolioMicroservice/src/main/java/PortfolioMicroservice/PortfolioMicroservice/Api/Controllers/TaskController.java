package PortfolioMicroservice.PortfolioMicroservice.Api.Controllers;

import PortfolioMicroservice.PortfolioMicroservice.Api.DTO.ITaskGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.ITaskRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    private ITaskRepository taskRepository;

    public TaskController(ITaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("/getAll")
    public List<ITaskGetAllResponseDto> getAll(){
        return this.taskRepository.getAll();
    }
}
