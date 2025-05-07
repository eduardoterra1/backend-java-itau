package desafio.itau.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.dto.StatatisticsResponse;
import desafio.itau.springboot.service.TransactionService;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
    
    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatatisticsResponse> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatatisticsResponse(stats));
    }
}
