package main.repository;

import main.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, Long> {
    @Query("SELECT v FROM Verification v WHERE v.email = ?1")
    Verification findByEmail(String email);
}
