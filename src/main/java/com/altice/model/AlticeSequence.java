package com.altice.model;

import com.altice.controller.AlticeService;

import java.util.ArrayList;
import java.util.List;

public class AlticeSequence {

    private List<Long> sequence = new ArrayList<Long>();
    private long value;

    public AlticeSequence(AlticeService alticeService, long value) {
        this.sequence = alticeService.showSequence(value);
        this.value = sequence.get(sequence.size()-1);
    }

    public List<Long> getSequence() {
        return sequence;
    }

    public long getValue() {
        return value;
    }
}
