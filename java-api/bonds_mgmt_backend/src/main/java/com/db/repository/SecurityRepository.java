package com.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;


import com.db.model.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long>  {

}