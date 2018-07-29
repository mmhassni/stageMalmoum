package org.sid.dari2.dao;

import org.sid.dari2.entities.titres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public interface TitresRepository extends JpaRepository<titres,Serializable>
{

}
