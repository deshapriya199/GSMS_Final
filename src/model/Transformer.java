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
public class Transformer {
    private int idTransformer;
    private String model;
    private String location;
    private String description;
    
    
    

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

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
