package com.example.datastoremicroservice.web.controller;

import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.model.SummaryType;
import com.example.datastoremicroservice.service.SummaryService;
import com.example.datastoremicroservice.web.dto.SummaryDto;
import com.example.datastoremicroservice.web.mapper.SummaryMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/analytics")
@AllArgsConstructor
public class AnalyticsController {

    private final SummaryService summaryService;

    private final SummaryMapper summaryMapper;

    @GetMapping("/summary/{sensorId}")
    public SummaryDto getSummary(@PathVariable long sensorId,
                                 @RequestParam(value = "mt", required = false)
                                 Set<MeasurementType> measurementTypes,
                                 @RequestParam(value = "st", required = false)
                                     Set<SummaryType> summaryTypeSet) {

        Summary summary = summaryService.get(
                sensorId,
                measurementTypes,
                summaryTypeSet
        );

        return summaryMapper.toDto(summary);
    }
}
