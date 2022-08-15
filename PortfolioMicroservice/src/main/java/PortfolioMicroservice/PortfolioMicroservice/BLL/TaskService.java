package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetByExperienceResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.ITaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<ITaskGetByExperienceResponseDto> getByExperience(Integer experienceId) throws HttpClientErrorException {
        if (experienceId <= 0)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Task Bad Request.");

        var response = taskRepository.getByExperience(experienceId);

        return response;
    }

}
