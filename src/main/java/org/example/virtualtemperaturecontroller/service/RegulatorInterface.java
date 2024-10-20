package org.example.virtualtemperaturecontroller.service;

import java.util.List;

public interface RegulatorInterface {

    void setTemperatura(List<Float> outData);

    float getValuesTemperature(int offsetOut);

    void deleteValuesTemperature();

    int adjustTemp(byte operation, float inData, List<Float> outData, int offsetOut);

}
