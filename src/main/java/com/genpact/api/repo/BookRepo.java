package com.genpact.api.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.genpact.api.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

	 @Query(value="FROM Book WHERE library_id = :library_id")
	List<Book> getBookByLibraryId(@Param("library_id") Long library_id);
}
