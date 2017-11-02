/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kinkydesign.pksim.dto;

import java.util.Map;
import org.jaqpot.algorithms.dto.dataset.Dataset;

/**
 *
 * @author pantelispanka
 */
public class TrainingRequest {
    
    private Dataset dataset;
    private String predictionFeature;
    private Map<String, Object> parameters;

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public String getPredictionFeature() {
        return predictionFeature;
    }

    public void setPredictionFeature(String predictionFeature) {
        this.predictionFeature = predictionFeature;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
    
    
}
