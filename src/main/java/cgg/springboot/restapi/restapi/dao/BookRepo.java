package cgg.springboot.restapi.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cgg.springboot.restapi.restapi.entities.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {

}
