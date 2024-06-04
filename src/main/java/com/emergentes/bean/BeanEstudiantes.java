
package com.emergentes.bean;

import com.emergentes.Estudiantes;
import com.emergentes.jpa.EstudiantesJpaController;
import com.emergentes.jpa.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BeanEstudiantes {
    
    private EntityManagerFactory emf;
    private EstudiantesJpaController daoEstudiantes;

    public BeanEstudiantes () {
        this.emf = Persistence.createEntityManagerFactory("UPseguimiento");
        this.daoEstudiantes = new EstudiantesJpaController(emf);
    }
    
    public List<Estudiantes> listarTodos(){
        return daoEstudiantes.findEstudiantesEntities();
    }
    
    public void insertar(Estudiantes es){
        daoEstudiantes.create(es);
    }
    
    public void editar(Estudiantes es){
        try {
            daoEstudiantes.edit(es);
        } catch (Exception e) {
            Logger.getLogger(BeanEstudiantes.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void eliminar(Integer id){
        try {
            daoEstudiantes.destroy(id);
        } catch (NonexistentEntityException e) {
            Logger.getLogger(BeanEstudiantes.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Estudiantes buscar(Integer id){
        Estudiantes es = new Estudiantes();
        es=daoEstudiantes.findEstudiantes(id);
        return es;
    }
}
