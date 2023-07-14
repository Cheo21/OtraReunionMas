/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author jg211
 */
@Table(name = "persona")
@Entity
public class Persona {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true)
    private String numeroEmpleado;
    
    private String nombre;
    
    private String apellido;

    @ManyToMany
    private Set<Reunion> reuniones;
    
    public Persona() {
        reuniones = new HashSet();
    }

    
    
    public Persona(String numeroEmpleado, String nombre, String apellido) {
        this();
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("id=").append(id);
        sb.append(", numeroEmpleado=").append(numeroEmpleado);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append('}');
        return sb.toString();
    }

    public Set<Reunion> getReuniones() {
        return reuniones;
    }
    
    
    public void addReunion(Reunion reunion){
        reuniones.add(reunion);
        if(!reunion.getParticipantes().contains(this)){
            reunion.addParticipante(this);
        }
    }
    
    
    
    
    
}
