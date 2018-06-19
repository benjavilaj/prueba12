
package inacap.webcomponent.prueba18.model;

import java.util.ArrayList;


@Entity


public class AlumnoModel {
    
    private int idAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    
    public static ArrayList<AlumnoModel> alumnos = new ArrayList<> ();

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public AlumnoModel() {
    }

    public AlumnoModel(String nombreAlumno, String apellidoAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
    }

    private AlumnoModel(int idAlumno, String nombreAlumno, String apellidoAlumno) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
    }
    
    
    public void nuevoAlumno(String nombre, String apellido){
        
        int idMayor = 0;
        
        if(!alumnos.isEmpty()){
            for (AlumnoModel a : alumnos){
                if (a.getIdAlumno()> idMayor ){
                    idMayor = a.getIdAlumno();
                }
            }
        }
        
          idMayor++;
    alumnos.add(new AlumnoModel(idMayor, nombre, apellido));
    
    }
    
    public AlumnoModel buscaAlumno(int idAlumno){
        
        AlumnoModel alumnoEncontrado = null;
        
        for (AlumnoModel a : alumnos){
            if (a.getIdAlumno()== idAlumno){
                alumnoEncontrado = a;
                
            }
        }
        
        return alumnoEncontrado;
    }
  
    public AlumnoModel editarAlumno(int idAlumno, AlumnoModel alumno){
        AlumnoModel alum = null;
        
        for(AlumnoModel a : alumnos){
            
            if(a.getIdAlumno() == idAlumno){
                
                a.setNombreAlumno(alumno.getNombreAlumno());
                a.setApellidoAlumno(alumno.getApellidoAlumno());
                
                alum = a;
            }
        }
        return alum;
    }
    
    public void eliminarAlumno(int id){
        
        AlumnoModel alumnoDelete = new AlumnoModel();
        
        for (AlumnoModel a : alumnos){
            if(a.getIdAlumno()== id){
                
                alumnoDelete = a;
            }
        }
        
        alumnos.remove(alumnoDelete);
    }
}
