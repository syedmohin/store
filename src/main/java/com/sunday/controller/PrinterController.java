package com.sunday.controller;

import com.sunday.model.Printer;
import com.sunday.repository.PrinterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("printer")
@RequiredArgsConstructor
public class PrinterController {

    private final PrinterRepository printerRepository;

    @GetMapping("inprinter")
    public ResponseEntity<Printer> getPrinter() {
        var iter = printerRepository.findAll();
        var list = new ArrayList<Printer>();
        iter.forEach(list::add);
        return ResponseEntity.ok(list.get(0));
    }

    @GetMapping("outprinter")
    public ResponseEntity<Printer> setPrinter(@RequestBody Printer printer) {
        return ResponseEntity.ok(printerRepository.save(printer));
    }
}
