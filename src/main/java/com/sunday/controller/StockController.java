package com.sunday.controller;

import com.sunday.model.Stock;
import com.sunday.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("stock")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping("insert")
    public ResponseEntity<Stock> getAllStock(@RequestBody Stock stock) {
        return ok(stockService.insertData(stock));
    }

    @GetMapping("all")
    public ResponseEntity<List<Stock>> getStock() {
        return ok(stockService.getAllData());
    }

    @GetMapping("vehicle")
    public ResponseEntity<List<String>> getAllvehicleNo() {
        return ok(stockService.getAllvehicle());
    }

    @DeleteMapping("delete/{stkId}")
    public ResponseEntity<Boolean> deleteStock(@PathVariable("stkId") String stkId) {
        return ok(stockService.deleteRecord(stkId));
    }

    @PostMapping("updaterate/{stk}/{rate}")
    public ResponseEntity<Stock> updateRate(@PathVariable("stk") String stk,
                                            @PathVariable("rate") int rate) {
        return ok(stockService.updateRate(stk, rate));
    }

    @PostMapping("updaterate/{stk}/{weight}")
    public ResponseEntity<Stock> updateweight(@PathVariable("stk") String stk,
                                              @PathVariable("weight") int weight) {
        return ok(stockService.updateWeight(stk, weight));
    }

    @PostMapping("updaterate/{stk}/{bal}")
    public ResponseEntity<Stock> updateBalance(@PathVariable("stk") String stk,
                                               @PathVariable("bal") int bal) {
        return ok(stockService.updateBalance(stk, bal));
    }

    @PostMapping("updaterate/{stk}/{vNO}")
    public ResponseEntity<Stock> updateVehicleName(@PathVariable("stk") String stk,
                                                   @PathVariable("vNo") String vNO) {
        return ok(stockService.updateVehicleNo(stk, vNO));
    }

}