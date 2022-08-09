package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.API.DTO.IEducationGetAllResponseDto;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer> {

    @Query(
            value = "SELECT id, organization, title, period_from AS periodFrom, period_to AS periodTo " +
                    "FROM educations AS e " +
                    "ORDER BY period_to DESC, period_from DESC",
            nativeQuery = true
    )
    List<IEducationGetAllResponseDto> getAll();

}
