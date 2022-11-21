package com.alticcisequence.dellent.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AlticciService {

    @Cacheable(value = "alticci")
    public int calculate(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        return calculate(n - 3) + calculate(n -2);
    }

}
