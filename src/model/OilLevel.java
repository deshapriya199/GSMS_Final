/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author san
 */
public class OilLevel {
    private int value;
    private int idMeter;
    private Date time;

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

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
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }
    
}
