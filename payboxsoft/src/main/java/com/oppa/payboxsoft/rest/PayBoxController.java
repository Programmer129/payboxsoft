package com.oppa.payboxsoft.rest;

import com.oppa.payboxsoft.api.FinancialParameters;
import com.oppa.payboxsoft.api.MobileParameters;
import com.oppa.payboxsoft.api.PayBoxService;
import com.oppa.payboxsoft.api.Price;
import com.oppa.payboxsoft.api.Service;
import com.oppa.payboxsoft.api.UtilitiesAndCharityParameters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/paybox/products")
public class PayBoxController {

    private final PayBoxService payBoxService;

    public PayBoxController(PayBoxService service) {
        this.payBoxService = service;
    }

    @PostMapping("/mobile")
    ResponseEntity<Object> transferToMobile(@Valid @RequestBody MobileParameters request) {
        payBoxService.transferToMobile(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/charity")
    ResponseEntity<Object> transferToCharity(@Valid @RequestBody UtilitiesAndCharityParameters request) {
        payBoxService.transferToCharity(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/utilities")
    ResponseEntity<Object> transferToUtilities(@Valid @RequestBody UtilitiesAndCharityParameters request) {
        return transferToCharity(request);
    }

    @PostMapping("/financials")
    ResponseEntity<Object> transferToFinancials(@Valid @RequestBody FinancialParameters request) {
        payBoxService.transferToFinancials(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/pre-price")
    Price getPrePrice(@RequestParam("amount") int amount,
                      @RequestParam("service") Service service) {
        return payBoxService.calculatePrePrice(amount, service);
    }
}
