package domain;

public class Usuario {

    private String usuario;
    private String id_usuario;
    private String password;

    public Usuario() {
    }

    public Usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
        
    public Usuario(String usuario, String id_usuario, String password) {
        this.usuario = usuario;
        this.id_usuario = id_usuario;
        this.password = password;
    }
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", id_usuario=" + id_usuario + ", password=" + password + '}';
    }
    

}
