/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kinkydesign.pksim.dto;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author pantelispanka
 */
public class PredictionResponse {
    
    List<LinkedHashMap<String, Object>> predictions;

    public List<LinkedHashMap<String, Object>> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<LinkedHashMap<String, Object>> predictions) {
        this.predictions = predictions;
    }
    
}
