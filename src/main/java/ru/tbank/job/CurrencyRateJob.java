package ru.tbank.job;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tbank.model.CurrencyRateDto;
import ru.tbank.service.CbrClient;
import ru.tbank.entity.TrackedCurrency;
import ru.tbank.repository.ClientRepository;
import java.util.List;
@Component
@RequiredArgsConstructor
public class CurrencyRateJob {
    private final CbrClient cbrClient;
    private final ClientRepository trackedCurrencyRepository;
    @Scheduled(cron = "0 0 * * * *")
    @PostConstruct
    public void fetchAndCompareRates() {
        List<CurrencyRateDto> apiRates = cbrClient.fetchRates();
        List<TrackedCurrency> tracked = trackedCurrencyRepository.findAll();

        for (TrackedCurrency tc : tracked) {
            apiRates.stream()
                    .filter(dto -> dto.getCode().equalsIgnoreCase(tc.getBaseCurrency()))
                    .findFirst()
                    .ifPresent(dto -> {
                        double diff = (dto.getValue() - dto.getPrevious()) / dto.getPrevious();
                        if (Math.abs(diff) >= Math.abs(tc.getPriceChangeRange())) {
                            System.out.println("ALERT: " + tc.getDescription());
                        }
                    });
        }
    }
}
