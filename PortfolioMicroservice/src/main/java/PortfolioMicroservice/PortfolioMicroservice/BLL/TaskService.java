package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetByExperienceResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Task;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IExperienceRepository;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.ITaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    private ITaskRepository taskRepository;
    private IExperienceRepository experienceRepository;

    public TaskService(ITaskRepository taskRepository,
                       IExperienceRepository experienceRepository){
        this.taskRepository = taskRepository;
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<ITaskGetByExperienceResponseDto> getByExperience(Integer experienceId) throws HttpClientErrorException {
        if (experienceId <= 0)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Task Bad Request.");

        var response = taskRepository.getByExperience(experienceId);

        return response;
    }

    @Override
    public Task create(CreateTaskRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Task Bad Request.");

        var experience = experienceRepository.findById(request.getExperienceId()).orElse(null);

        if (experience == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Experience Not Found with Id " + request.getExperienceId() + ".");

        var response = new Task();
        response.setName(request.getName());
        response.setExperience(experience);
        response = save(response);

        return response;
    }

    @Override
    public Task update(UpdateTaskRequestDto request) throws HttpClientErrorException {
        if (request == null)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Task Bad Request.");

        var response = taskRepository.findById(request.getId()).orElse(null);

        if (response == null)
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Task Not Found with Id " + request.getId() + ".");

        response.setName(request.getName());

        response = save(response);

        return response;
    }

    @Override
    public Task save(Task task) {
        var response = taskRepository.save(task);

        return response;
    }

}
