package es.pablo.ritmic.TO;

import java.io.Serializable;

public enum TipoPerfilUsuario implements Serializable{
    ALUMNO("Alumno"),
    PROFESOR("Profesor");
     
    String userProfileType;
     
    private TipoPerfilUsuario(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
}
