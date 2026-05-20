package sopadeletras;

import Modelo.ModeloSopa;
import Vista.GUISopa;
import Controlador.ControladorSopa;


public class SopaDeLetras {

    public static void main(String[] args) {
         ModeloSopa modelo = new ModeloSopa();

        modelo.crearBaseDatosYTabla();

        GUISopa vista = new GUISopa();

        ControladorSopa controlador = new ControladorSopa(vista, modelo);

        vista.setVisible(true);

    }

}
