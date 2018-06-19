/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba18.controller;

import inacap.webcomponent.prueba18.model.AlumnoModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Benja
 */
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    
    @GetMapping()
    public List<AlumnoModel> list() {
        AlumnoModel alumno = new AlumnoModel();
        
        alumno.nuevoAlumno("Gonzalo","Maquina");
        alumno.nuevoAlumno("Chino","Homero");
        alumno.nuevoAlumno("Basti","Mostrox");
        alumno.nuevoAlumno("Garabatito","Garabatito");
        alumno.nuevoAlumno("Nacho","SexMachine");
        
        
        
        
        return AlumnoModel.alumnos;
    }
    
    @GetMapping("/{id}")
    public AlumnoModel get(@PathVariable String id) {
        
        AlumnoModel a = new AlumnoModel();
        
        Optional<AlumnoModel> aOptional = alumnoRepositiry.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()){
            AlumnoModel aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
  
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoModel> put(@PathVariable String id, @RequestBody AlumnoModel alumno) {
        
      Optional<AlumnoModel> aOptional = alumnoRepositiry.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()){
            AlumnoModel aEncontrado = aOptional.get();
            
            alumnoEditar.setIdAlumno(aEncontrado.getIdAlumno());
            
            alumnoRepository.save(alumnoEditar);
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
    }
    
    @PostMapping
    public ResponseEntity<AlumnoModel> post(@RequestBody AlumnoModel alumno) {
        
       Optional<AlumnoModel> aOptional = alumnoRepositiry.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()){
            AlumnoModel aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
        
        
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
       Optional<AlumnoModel> aOptional = alumnoRepositiry.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()){
            AlumnoModel aEncontrado = aOptional.get();
            
            alumnoRepository.deleteId(aEcontrado, getIdAlumno());
            
            return new ResponseEntity<>(aEncontrado, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
