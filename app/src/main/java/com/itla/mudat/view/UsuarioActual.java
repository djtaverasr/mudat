package com.itla.mudat.view;

import com.itla.mudat.Entity.Usuario;

/**
 * Created by Diony Taveras on 15/12/2017.
 */

public class UsuarioActual {

    private static Usuario USUARIO;

    public static Usuario getUsuario(){
        return USUARIO;
    }

    public static void setUsuario(Usuario usuario){
        UsuarioActual.USUARIO = usuario;
    }
}
