package br.com.dudu.restaurante.model.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;



@Entity
@Table(name = "categoria")
public class Categoria {

    private  EntityManager entityManager;

    public Categoria(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private boolean disponibilidade;

    @Column(name = "data_de_registro")
    private LocalDateTime dataDeRegistro = LocalDateTime.now();





    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public Integer getId() {
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public LocalDateTime getDataDeRegistro(){
        return this.dataDeRegistro;
    }

    //SETTERS
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }


    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", dataDeRegistro=" + dataDeRegistro +
                '}';
    }

    public void cadastrarCategoria(final Categoria categoria){
        entityManager.persist(categoria);
        System.out.println(categoria.toString());
    }
    public Categoria visualizarCategoria(final Integer id){
        return entityManager.find(Categoria.class,id);
    }
    public void atualizarCategoria(final Categoria categoria){
        entityManager.merge(categoria);
    }
    public void excluirCategoria(final Categoria categoria){
        entityManager.remove(categoria);
    }
}
