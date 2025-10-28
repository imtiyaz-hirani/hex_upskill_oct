package com.hex.trs.controller;

import com.hex.trs.model.Plan;
import com.hex.trs.service.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/plan")
@AllArgsConstructor
public class PlanController {

    private final PlanService planService;

    @GetMapping("/customer/{customerId}")
    public List<Plan> getPlansByCustomer(@PathVariable long customerId){
        return planService.getPlansByCustomer(customerId);
    }
}
