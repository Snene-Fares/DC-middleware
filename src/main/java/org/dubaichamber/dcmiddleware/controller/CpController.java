package org.dubaichamber.dcmiddleware.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.dubaichamber.dcmiddleware.dto.cp.ValuesListRequestDTO;
import org.dubaichamber.dcmiddleware.dto.cp.ValuesListWsRequestDTO;
import org.dubaichamber.dcmiddleware.service.CpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cp-services")
@RequiredArgsConstructor
public class CpController {
    private final CpService cpService;

    @PostMapping("values-list")
    public ResponseEntity<Object> valuesList(@RequestBody @Valid ValuesListRequestDTO request) {
        return ResponseEntity.ok(cpService.valuesList(request));
    }

    @PostMapping("license-info")
    public ResponseEntity<Object> licenseInfo(@RequestBody Object request) {
        return ResponseEntity.ok(cpService.licenseInfo(request));
    }

    @PostMapping("validate-account")
    public ResponseEntity<Object> validateAccount(@RequestBody Object request) {
        return ResponseEntity.ok(cpService.validateAccount(request));
    }

    @PostMapping("service-fees")
    public ResponseEntity<Object> serviceFees(@RequestBody Object request) {
        return ResponseEntity.ok(cpService.serviceFees(request));
    }

    @PostMapping("verify-signature")
    public ResponseEntity<Object> verifySignature(@RequestBody Object request) {
        return ResponseEntity.ok(cpService.verifySignature(request));
    }

    @PostMapping("query-svs")
    public ResponseEntity<Object> querySvs(@RequestBody Object request) {
        return ResponseEntity.ok(cpService.querySvs(request));
    }

    @PostMapping("auth-cert")
    public ResponseEntity<Object> authCert(@RequestBody Object request) {
        return ResponseEntity.ok(cpService.authCert(request));
    }

    @PostMapping("true-copy")
    public ResponseEntity<Object> trueCopy(@RequestBody Object request) {
        return ResponseEntity.ok(cpService.trueCopy(request));
    }
}
