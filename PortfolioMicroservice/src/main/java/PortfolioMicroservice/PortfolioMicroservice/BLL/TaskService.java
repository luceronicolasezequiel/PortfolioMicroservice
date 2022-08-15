package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.GetByExperienceTaskRequestDto;
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
    public List<ITaskGetByExperienceResponseDto> getByExperience(GetByExperienceTaskRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Task Bad Request.");

        var response = taskRepository.getByExperience(request.getId());

        return response;
    }

}
