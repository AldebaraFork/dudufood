package br.com.dudu.restaurante.model.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;



@Entity
@Table(name = "categorias")
public class Categoria {

    public Categoria(){

    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;




    public Integer getId() {
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
