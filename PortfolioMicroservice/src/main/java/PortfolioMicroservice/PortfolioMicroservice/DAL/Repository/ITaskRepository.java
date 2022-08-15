package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetByExperienceResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

    @Query(
            value = "SELECT t.id, t.name, t.experience_id AS experienceId " +
                    "FROM tasks AS t " +
                    "WHERE t.experience_id = :experienceId",
            nativeQuery = true
    )
    List<ITaskGetByExperienceResponseDto> getByExperience(Integer experienceId);
}
