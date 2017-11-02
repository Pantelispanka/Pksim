/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kinkydesign.pksim.dto;

import org.jaqpot.algorithms.dto.dataset.Dataset;

/**
 *
 * @author pantelispanka
 */
public class PredictionRequest {
    
    private Dataset dataset;
    private Object rawModel;
    private Object additionalInfo;

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public Object getRawModel() {
        return rawModel;
    }

    public void setRawModel(Object rawModel) {
        this.rawModel = rawModel;
    }

    public Object getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Object additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    
}
