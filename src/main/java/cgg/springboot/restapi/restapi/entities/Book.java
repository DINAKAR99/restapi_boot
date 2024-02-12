package cgg.springboot.restapi.restapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue
    public int bookid;
    public String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    public Author author;
}
