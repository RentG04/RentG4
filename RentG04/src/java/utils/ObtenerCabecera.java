/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import bean.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Iker Lopez
 */
public class ObtenerCabecera {
    public static String get(HttpServletRequest request, String type){
         String str="";
        if(type.equals("empleado")){
            str += " <header class='main-header'>";
            str += "    <a'>";
            str += "        <img alt='logo' src='images/logoTrans.png' width='100'/>";
            str += "        <img alt='logo1' class='logo1' id='logo1' src='images/logoTrans2.png' width='200'>";
            str += "    </a>";    
            str += "    <nav>";
            str += "        <ul id='botones'>";
            str+= "                        <li><a href='Logout' ><button type='button' class='button' value='logout'>Logout</button></a></li>";

            str += "        </ul>";
            str += "    </nav>";
        }else{
       
        str += " <header class='main-header'>";
        str += "    <a href='index.jsp'>";
        str += "        <img alt='logo' src='images/logoTrans.png' width='100'/>";
        str += "        <img alt='logo1' class='logo1' id='logo1' src='images/logoTrans2.png' width='200'>";
        str += "    </a>";           
        str += "    <nav>";
        str += "        <ul id='botones'>";
        if(type.equals("index") || type.equals("miReserva") || type.equals("perfil")){
            HttpSession s = request.getSession();
            try{
                Usuario u = (Usuario)s.getAttribute("usr");
                if(u==null){
                    str+= "                        <li><button type='button' class='button' value='login' onclick='location.href=\"login.jsp\"'>Login</button></li>";
                    str+= "                        <li><button type='button' class='button' value='registro' onclick='location.href=\"registro.jsp\"'>Registro</button></li>";
                }else{
                    str+= "                        <li><button type='button' class='button' value='perfil' onclick='location.href=\"perfil.jsp\"'>Bienvenido <strong>"+u.getUsuario()+"</strong></button></li>";
                    str+= "                        <img src='"+u.getFoto()+"' width='45px' align='center'>";
                    str+= "                        <li><button type='button' class='button' value='perfil' onclick='location.href=\"miReserva.jsp\"'>Mis reservas</button></li>";
                    str+= "                        <li><a href='Logout' ><button type='button' class='button' value='logout'>Logout</button></a></li>";
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(type.equals("login")){
              str += "<li><button type=\"button\" class=\"button\" value=\"registro\" onclick=\"location.href='registro.jsp'\">Registro</button></li>     ";
        }
        else if(type.equals("loginEmpleado")){
            str+="<li><button type=\"button\" class=\"button\" value=\"salir\" onclick=\"location.href='index.jsp'\">Volver</button></li>";
        }
        else if(type.equals("registro")){
            str+="<li><button type=\"button\" class=\"button\" value=\"login\" onclick=\"location.href='login.jsp'\">Login</button></li>\n";
        }
        str +="         </ul>";
        str +="     </nav>";
        str +="</header>";
        
        
    }
        
        return str;
    }
}
