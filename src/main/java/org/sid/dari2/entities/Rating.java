package org.sid.dari2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rating
{
    @Id @GeneratedValue
    private Integer id;
    private Integer refUtilisateur;
    private Integer refMaison;
    private Integer valeur;

    public Rating()
    {

    }
    public Rating(Integer refUtilisateur, Integer refMaison, Integer valeur)
    {

        this.refUtilisateur = refUtilisateur;
        this.refMaison = refMaison;
        this.valeur = valeur;
    }

    public Integer getId()
    {

        return id;
    }

    public void setId(Integer id)
    {

        this.id = id;
    }

    public Integer getRefUtilisateur()
    {

        return refUtilisateur;
    }

    public void setRefUtilisateur(Integer refUtilisateur)
    {

        this.refUtilisateur = refUtilisateur;
    }

    public Integer getRefMaison()
    {

        return refMaison;
    }

    public void setRefMaison(Integer refMaison)
    {

        this.refMaison = refMaison;
    }

    public Integer getValeur()
    {

        return valeur;
    }

    public void setValeur(Integer valeur)
    {

        this.valeur = valeur;
    }
}
