package modelos;

/**
 * Created by bpastene on 20-05-16.
 */

public class Usuario {
    private String idUsuario;
    private String nombreUser;
    private String mailUser;
    private String contrasenaUser;

    public Usuario(String user, String pass, String mail){
        this.setContrasenaUser(pass);
        this.setIdUsuario("");
        this.setMailUser(mail);
        this.setNombreUser(user);
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getContrasenaUser() {
        return contrasenaUser;
    }

    public void setContrasenaUser(String contrasenaUser) {
        this.contrasenaUser = contrasenaUser;
    }
}

