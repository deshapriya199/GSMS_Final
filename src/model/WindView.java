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
public class WindView {
    private int value;
    private String type;
    private Date time;
    private int idTransfomer;

    public WindView(int value, String type, Date time, int idTransfomer) {
        this.value = value;
        this.type = type;
        this.time = time;
        this.idTransfomer = idTransfomer;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public Date getTime() {
        return time;
    }

    public int getIdTransfomer() {
        return idTransfomer;
    }

    /**
     * @return the value
     */
    
    
}
