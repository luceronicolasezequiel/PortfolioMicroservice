package PortfolioMicroservice.PortfolioMicroservice.DAL.Repository;

import PortfolioMicroservice.PortfolioMicroservice.DAL.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
