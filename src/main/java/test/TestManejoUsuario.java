package test;

import data.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestManejoUsuario {

    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();

        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario -> {
            System.out.println("Usuario: "+ usuario);
        });

    }

}
