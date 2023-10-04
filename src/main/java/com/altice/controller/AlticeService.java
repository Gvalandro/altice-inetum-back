package com.altice.controller;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class AlticeService {
    List<Long> sequence = new ArrayList<Long>();

    @CacheResult(cacheName = "sequence-cache")
    public List<Long> showSequence(long n) {

        /* Code used to test Cache
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        */
        if (sequence.size() > n) {
                return sequence.subList(0, (int)n + 1);
            }
        for (int i = sequence.size(); i <= n; i++) {
                if (i == 0) {
                    sequence.add(0L);
                } else if (i == 1 || i == 2) {
                    sequence.add(1L);
                } else {
                    long nextValue = sequence.get(i - 2) + sequence.get(i - 3);
                    sequence.add(nextValue);
                }
            }
            return sequence;

    }
}

