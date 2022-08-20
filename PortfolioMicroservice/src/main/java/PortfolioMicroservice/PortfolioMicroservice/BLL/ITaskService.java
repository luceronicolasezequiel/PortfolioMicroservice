package PortfolioMicroservice.PortfolioMicroservice.BLL;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.CreateTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.DeleteTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetByExperienceResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.UpdateTaskRequestDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Task;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface ITaskService {

    public List<ITaskGetByExperienceResponseDto> getByExperience(Integer experienceId) throws HttpClientErrorException;

    public Task create(CreateTaskRequestDto request) throws HttpClientErrorException;

    public Task update(UpdateTaskRequestDto request) throws HttpClientErrorException;

    public Task save(Task task);

    public void delete(DeleteTaskRequestDto request) throws HttpClientErrorException;

}
