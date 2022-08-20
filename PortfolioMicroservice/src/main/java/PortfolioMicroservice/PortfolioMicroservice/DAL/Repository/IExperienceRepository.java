package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IExperienceGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Integer> {

    @Query(
            value = "SELECT e.id, e.organization, e.period_from AS periodFrom, e.period_to AS periodTo, e.position " +
                    "FROM experiences AS e " +
                    "ORDER BY e.period_to IS NULL DESC, e.period_to DESC, e.period_from DESC",
            nativeQuery = true
    )
    List<IExperienceGetAllResponseDto> getAll();

}
