/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.Date;

/**
 *
 * @author san
 */
public class RepairModel {
    private int idTransfomer;
    private String description;
    private Date date=new Date();
    private File[] files;
    

    public int getIdTransfomer() {
        return idTransfomer;
    }

    public void setIdTransfomer(int idTransfomer) {
        this.idTransfomer = idTransfomer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
