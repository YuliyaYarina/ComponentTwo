package org.example.virtualtemperaturecontroller.service;

import org.example.regulator.service.VirtualRegulatorService;

import java.util.List;

public class Regulator implements RegulatorInterface{

    private final VirtualRegulatorService regulator;

    public Regulator(VirtualRegulatorService regulator) {
        this.regulator = regulator;
    }

    @Override
    public void setTemperatura(List<Float> outData) {
        regulator.setTemperatura(outData);
    }

    @Override
    public float getValuesTemperature(int offsetOut) {
        return regulator.getValuesTemperature(offsetOut);
    }

    @Override
    public void deleteValuesTemperature() {
        regulator.deleteValuesTemperature();
    }

    @Override
    public int adjustTemp(byte operation, float inData, List<Float> outData, int offsetOut) {
        return regulator.adjustTemp(operation, inData, outData, offsetOut);
    }
}
