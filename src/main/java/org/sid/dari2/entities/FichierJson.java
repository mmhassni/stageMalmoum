package org.sid.dari2.entities;

import java.util.ArrayList;

public class FichierJson
{
    private String type;
    private ArrayList<Feature> features;
    private Crs crs;
    private ArrayList<Double> bbox;

    public FichierJson()
    {

    }

    public String getType()
    {

        return type;
    }

    public void setType(String type)
    {

        this.type = type;
    }

    public ArrayList<Feature> getFeatures()
    {

        return features;
    }

    public void setFeatures(ArrayList<Feature> features)
    {

        this.features = features;
    }

    public Crs getCrs()
    {

        return crs;
    }

    public void setCrs(Crs crs)
    {

        this.crs = crs;
    }

    public ArrayList<Double> getBbox()
    {

        return bbox;
    }

    public void setBbox(ArrayList<Double> bbox)
    {

        this.bbox = bbox;
    }
}
