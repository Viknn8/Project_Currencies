package ru.tbank.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tbank.entity.TrackedCurrency;
import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<TrackedCurrency, Long> {
    Optional<TrackedCurrency> findByBaseCurrency(String baseCurrency);
}

