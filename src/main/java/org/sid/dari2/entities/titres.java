package org.sid.dari2.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class titres
{
    @Id
    @Column(name = "grid", columnDefinition = "serial")
    Integer gid;


    String nature;


    @Column(name="geomJSON")
    String geometry;



    public titres()
    {

    }

    public String getGeometry()
    {

        return geometry;
    }

    public void setGeom(String geometry)
    {

        this.geometry = geometry;
    }

    public Integer getGid()
    {

        return gid;
    }

    public void setGid(Integer gid)
    {

        this.gid = gid;
    }

    public String getNature()
    {

        return nature;
    }

    public void setNature(String nature)
    {

        this.nature = nature;
    }
}
