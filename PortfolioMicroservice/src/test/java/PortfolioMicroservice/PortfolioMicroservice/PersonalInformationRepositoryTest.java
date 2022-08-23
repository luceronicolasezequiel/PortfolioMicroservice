package PortfolioMicroservice.PortfolioMicroservice;

import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.PersonalInformation;
import PortfolioMicroservice.PortfolioMicroservice.DAL.Repository.IPersonalInformationRepository;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class PersonalInformationRepositoryTest {

    @Autowired
    IPersonalInformationRepository personalInformationRepository;

    @Test
    public void testCreatePersonalInformation() {
        var newPersonalInformation = new PersonalInformation();
        newPersonalInformation.setName("Name");
        newPersonalInformation.setSurname("Surname");
        newPersonalInformation.setTitle("Title");
        newPersonalInformation.setSummary("Summary");

        var savedPersonalInformation = this.personalInformationRepository.save(newPersonalInformation);

        assertThat(savedPersonalInformation).isNotNull();
        assertThat(savedPersonalInformation.getId()).isGreaterThan(0);
    }

}
