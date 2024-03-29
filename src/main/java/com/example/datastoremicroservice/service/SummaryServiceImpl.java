package com.example.datastoremicroservice.service;

import com.example.datastoremicroservice.model.Data;
import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.model.SummaryType;
import com.example.datastoremicroservice.model.exception.SensorNotFoundException;
import com.example.datastoremicroservice.repository.SummaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepository summaryRepository;

    @Override
    public Summary get(long sensorId,
                       Set<MeasurementType> measurementTypes,
                       Set<SummaryType> summaryTypeSet) {
        return summaryRepository.findBySensorId(
                sensorId,
                measurementTypes == null ? Set.of(MeasurementType.values()) : measurementTypes,
                summaryTypeSet == null ? Set.of(SummaryType.values()) : summaryTypeSet
        ).orElseThrow(SensorNotFoundException::new);
    }

    @Override
    public void handle(Data data) {
        summaryRepository.handle(data);
    }
}
