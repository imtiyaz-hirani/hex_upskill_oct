package com.hex.trs.service;

import com.hex.trs.model.Plan;
import com.hex.trs.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    public List<Plan> getPlansByCustomer(long customerId) {
        return planRepository.getPlansByCustomer(customerId);
    }
}
