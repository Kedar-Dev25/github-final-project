package com.smartclinic.controller;

import com.smartclinic.model.Prescription;
import com.smartclinic.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // Create a new prescription
    @PostMapping("/{token}")
    public ResponseEntity<Map<String, String>> addPrescription(
            @PathVariable String token,
            @Valid @RequestBody Prescription prescription) {

        Map<String, String> response = new HashMap<>();

        // Optional: validate token here using TokenService if you have it
        boolean isValidToken = true; // replace with actual token validation
        if (!isValidToken) {
            response.put("status", "error");
            response.put("message", "Invalid token");
            return ResponseEntity.status(401).body(response);
        }

        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        response.put("status", "success");
        response.put("message", "Prescription saved successfully");
        response.put("prescriptionId", String.valueOf(savedPrescription.getPrescriptionId()));

        return ResponseEntity.ok(response);
    }
}
