package org.sid.dari2.web;

import org.sid.dari2.dao.TitresRepository;
import java.util.ArrayList;
import org.sid.dari2.entities.Feature;

import org.sid.dari2.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UtilisateurRestService
{





    @Autowired
    private TitresRepository titresRepository;

    //Test de l'annoatation Request
    @RequestMapping(value="/chercher/titres",method= RequestMethod.GET)
    @CrossOrigin(origins = "http://127.0.0.1:8081")
    public FichierJson chercherTitre()
    {

        FichierJson fichierJSON = new FichierJson();
        fichierJSON.setType(ExtractGeometryType("FeatureCollection"));


        List<titres> listTitres = titresRepository.findAll();
        ArrayList<Feature> listFeature = new ArrayList<Feature>();
        Feature f;
        Geometry g;
        MultiPolygon mp;
        for(titres t : listTitres)

        {
            mp = new MultiPolygon();
            if(t.getGeometry()!= null && t.getGeometry().contains("coordinates"))
            {
                mp.setCoordinates(MultiPolyToObject(t.getGeometry()));
            }
            mp.setType(ExtractGeometryType(t.getGeometry()));

            g = mp;




            f = new Feature();

            f.setGeometry(g);

            f.setId(t.getGid().toString());

            //le type de la geometrie
            f.setType("Feature");





            //l'ajout de l'objet feature à la liste
            listFeature.add(f);
            fichierJSON.setFeatures(listFeature);
        }

        return fichierJSON;

    }

    //Methode pour determiner le type de la geometrie
    public String ExtractGeometryType(String geometryJSON)
    {
        String retour = geometryJSON;
        if(geometryJSON != null)
        {
            if(geometryJSON.contains("MultiPolygon"))
            {
                retour = "MultiPolygon";
            }
            if(geometryJSON.contains("MultiPoint"))
            {
                retour = "MultiPoint";
            }
            if(geometryJSON.contains("LineString"))
            {
                retour = "LineString";
            }
            if(geometryJSON.contains("\"Polygon\""))
            {
                retour = "Polygon";
            }
            if(geometryJSON.contains("GeometryCollection"))
            {
                retour = "GeometryCollection";
            }
            if(geometryJSON.contains("Point"))
            {
                retour = "Point";
            }


        }

        return retour;
    }


    public ArrayList< ArrayList <ArrayList <ArrayList<Double>>>> MultiPolyToObject(String txt){
        txt = find(txt);
        ArrayList<ArrayList<ArrayList<ArrayList<Double>>>> Geom = new ArrayList<ArrayList<ArrayList<ArrayList<Double>>>>();
        //String points;
        //String lines;
        String polygons;


        ArrayList<ArrayList<Double>> Ring=new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<ArrayList<Double>>> Polygon= new ArrayList<ArrayList<ArrayList<Double>>>();

        int level = 3;
        polygons = txt.substring(1,txt.length()-1);
        polygons = txt;
        double x,y;
        String ix,iy;

        int i=4;

        //int count=0;


        boolean RingVide=false;

        while ((level!=0) && (i<polygons.length())) {
            if (level == 3){  // les points
                ArrayList<Double> point = new ArrayList<Double>();
                {
                    // x we look for ,
                    int j=i+1;
                    while( polygons.charAt(j)!=',' ) {
                        j++;
                    }
                    ix=polygons.substring(i, j);
                    x=Double.parseDouble(ix);
                    //		count++;
                    i=j+1;  // i the first digit in y
                    point.add(x);
                    // add y
                    j=i+1;
                    while( polygons.charAt(j)!=']' ) {
                        j++;
                    }
                    iy=polygons.substring(i, j);
                    y=Double.parseDouble(iy);
                    //		count++;
                    point.add(y);

                    i=j+1; // i the , or ]
                }
                Ring.add(point);
                if (polygons.charAt(i)==']') level--;
                else i+=2; //stay in level 3
            }
            else if (level == 2) { //lines
                if (RingVide == false) Polygon.add(Ring); // Ring saved
                i++;  // i the , or ]
                if(polygons.charAt(i)==']') level--;
                else { // new ring and go to level 3  here i is ,
                    Ring=new ArrayList<ArrayList<Double>>();
                    level++;
                    i+=3; // hdchi s7iiiiiiiiiiiiiiiii7
                }
            }
            else if(level == 1) { //polygon
                Geom.add(Polygon); // Polygon saved
                i++;
                if(polygons.charAt(i)==']') level--;
                else {  //hna , new polygon and go to level 2
                    Polygon= new ArrayList<ArrayList<ArrayList<Double>>>();
                    level++ ;
                    RingVide=true;
                }
            }
            else { // Multipolygon here level == 0

            }
        }

        return Geom ;
    }

    public String find(String result) {
        String txt="";
        String coor ="coordinates";
        int i=11;
        while ( !(result.substring(i-11,i)).equals(coor) ){
            i++;
        }
        //result(i-1)==s;  i+3 == [
        txt=result.substring(i+3,result.length()-1);
        return txt;
    }



}
