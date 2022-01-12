package com.example.PrescriptionCRUD.services;

import org.junit.jupiter.api.Test;

import java.util.List;

class PrescriptionServiceTest {

    @Test
    public void findMatching() {
        List<Integer> a = List.of(1,2,3);
        List<Integer> b = List.of(1,2,4);

        a.forEach(customer -> {
            boolean conditionFailed = b.stream().noneMatch(id -> id.equals(customer));
            if (conditionFailed) {
                throw new IllegalStateException();
            }
        });
    }

}