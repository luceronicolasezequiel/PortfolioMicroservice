package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskByExperienceResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.API.DTO.ITaskGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

    @Query(
            value = "SELECT t.id AS taskId, t.name AS taskName, t.experience_id AS experienceId, e.position, e.organization " +
                    "FROM tasks AS t " +
                    "INNER JOIN experiences AS e ON e.id = t.experience_id",
            nativeQuery = true
    )
    List<ITaskGetAllResponseDto> getAll();

    @Query(
            value = "SELECT t.id AS taskId, t.name AS taskName " +
                    "FROM tasks AS t " +
                    "WHERE t.experience_id = :experienceId",
            nativeQuery = true
    )
    List<ITaskByExperienceResponseDto> getByExperience(Integer experienceId);
}
