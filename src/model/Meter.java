/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author san
 */
public class Meter {
    private int idMeter;
    private String type;
    private int maxValue;
    private int idTransformer;

    /**
     * @return the idMeter
     */
    public int getIdMeter() {
        return idMeter;
    }

    /**
     * @param idMeter the idMeter to set
     */
    public void setIdMeter(int idMeter) {
        this.idMeter = idMeter;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the maxValue
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * @return the idTransformer
     */
    public int getIdTransformer() {
        return idTransformer;
    }

    /**
     * @param idTransformer the idTransformer to set
     */
    public void setIdTransformer(int idTransformer) {
        this.idTransformer = idTransformer;
    }
    
}
