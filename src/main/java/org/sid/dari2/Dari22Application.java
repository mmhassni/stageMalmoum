package org.sid.dari2;

import org.sid.dari2.dao.TitresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Dari22Application implements CommandLineRunner
{


    @Autowired
    public TitresRepository titresRepository;


    @Override
    public void run(String... arg0) throws Exception
    {
        //utilisateurRepository.save(new Utilisateur("losaduosa","tilifeureus","mhassni","mohamed","0654994890",	"jpeg"));
        //utilisateurRepository.save(new Utilisateur("kimo","exterminator","auouirem","mohamed","0654994890",	"jpeg"));
        //utilisateurRepository.save(new Utilisateur("samiox","azertyuiop","chadad","mohamed","0654994890",	"jpeg"));

        //maisonRepository.save(new Maison("Maison R+2","Après la vente de la première tranche des maisons individuelles, ORIENTAL MULTI SERVICES lance la vente de la 2ème tranche des maisons individuelles R+2"));
        //ratingRepository.save(new Rating(50,56,2));
        //utilisateurRepository.findAll().forEach(x-> System.out.println(x.getNom()));
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Dari22Application.class, args);
    }
}
