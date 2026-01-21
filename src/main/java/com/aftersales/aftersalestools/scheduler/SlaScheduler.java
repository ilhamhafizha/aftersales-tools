package com.aftersales.aftersalestools.scheduler;

import com.aftersales.aftersalestools.service.SlaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SlaScheduler {

    private final SlaService slaService;

    // Jalan tiap 5 menit
    @Scheduled(cron = "0 */5 * * * *")
    public void checkSla() {
        slaService.checkAndUpdateSla();
    }
}
