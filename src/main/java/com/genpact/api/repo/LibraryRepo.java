package com.genpact.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genpact.api.model.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>{

}
