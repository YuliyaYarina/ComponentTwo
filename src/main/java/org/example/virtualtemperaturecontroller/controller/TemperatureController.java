package org.example.virtualtemperaturecontroller.controller;

import org.example.virtualtemperaturecontroller.service.RegulatorInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class TemperatureController {

     RegulatorInterface regulator;

    @PostMapping("/set") //задать температуру
    public ResponseEntity<Void> setTemperature(@RequestHeader("test") List<Float> outData) {
        regulator.setTemperatura(outData);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/current") //получить текущую (последнюю)
    public ResponseEntity<Float> getCurrentTemperature() {
        return ResponseEntity.ok((float) regulator.getValuesTemperature(1));
    }

    @GetMapping("/recent") //получить одно из последних значений (указывается сдвиг и количество)
    public ResponseEntity<List<Float>> getRecent(@RequestHeader("test") int offsetOut) {
        return ResponseEntity.ok(Collections.singletonList(regulator.getValuesTemperature(offsetOut)));
    }

    @DeleteMapping("/clear") // очистить список
    public ResponseEntity<Void> clearList() {
        regulator.deleteValuesTemperature();
        return ResponseEntity.ok().build();
    }

}
