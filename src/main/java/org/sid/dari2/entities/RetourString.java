package org.sid.dari2.entities;

public class RetourString
{
    private String retour;
    private String nom;
    private String prenom;

    public String getNom()
    {

        return nom;
    }

    public void setNom(String nom)
    {

        this.nom = nom;
    }

    public String getPrenom()
    {

        return prenom;
    }

    public void setPrenom(String prenom)
    {

        this.prenom = prenom;
    }

    public RetourString()
    {

    }

    public RetourString(String retour, String nom, String prenom)
    {

        this.retour = retour;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getRetour()
    {

        return retour;
    }

    public void setRetour(String retour)
    {

        this.retour = retour;
    }
}
