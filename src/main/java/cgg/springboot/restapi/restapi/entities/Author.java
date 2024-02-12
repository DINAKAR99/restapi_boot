package cgg.springboot.restapi.restapi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue
    public int authorid;
    public String first_name;
    public String last_name;
    public String language;
    @JsonBackReference
    @OneToOne(mappedBy = "author")
    public Book book;

}
