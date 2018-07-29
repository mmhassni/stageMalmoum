package org.sid.dari2.entities;

public class Feature
{
    private String id ;
    private String type;
    private Geometry geometry;

    public Feature()
    {

    }

    public String getId()
    {

        return id;
    }

    public void setId(String id)
    {

        this.id = id;
    }

    public String getType()
    {

        return type;
    }

    public void setType(String type)
    {

        this.type = type;
    }

    public Geometry getGeometry()
    {

        return geometry;
    }

    public void setGeometry(Geometry geometry)
    {

        this.geometry = geometry;
    }
}
