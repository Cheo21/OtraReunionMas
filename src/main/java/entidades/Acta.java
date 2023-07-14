/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import javax.persistence.*;

/**
 *
 * @author jg211
 */

@Table(name = "acta")
@Entity
public class Acta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "contenido")
    private String contenido;
    
    @OneToOne
    @JoinColumn
    private Reunion reunion;

    public Acta() {
    }

    
    
    public Acta(String contenido, Reunion reunion) {
        this.contenido = contenido;
        this.reunion = reunion;
        reunion.setActa(this);
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Acta{");
        sb.append("id=").append(id);
        sb.append(", contenido=").append(contenido);
        sb.append('}');
        return sb.toString();
    }
    
    
}
