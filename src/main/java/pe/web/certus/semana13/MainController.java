package pe.web.certus.semana13;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class MainController {
    @Autowired//Autocarga
    private MessageSource mensajeSaludo;

    //GET: Mensaje de bienvenida y selector de idioma.
    @GetMapping("/")
    public String index (Model model, HttpServletRequest request ){
        Locale ubicacionActual = request.getLocale();
        String mensajeBienvenida = mensajeSaludo.getMessage("mensaje", null, ubicacionActual);
        model.addAttribute("mensaje",mensajeBienvenida);
        String lenguaje = mensajeSaludo.getMessage("frase", null, ubicacionActual);
        model.addAttribute("frase", lenguaje);
        return "index";
    }
    //POST: Enviar los datos al formulario.
    @PostMapping("/idioma_seleccionado")
    public String idiomaSeleccionado (@RequestParam("idioma") String idioma, Model model, HttpServletRequest request){
        Locale ubicacionActual = request.getLocale();
        //Variables geográficas
        String codigoPais = ubicacionActual.getCountry();
        String nombrePais = ubicacionActual.getDisplayCountry();

        String codigoIdioma = ubicacionActual.getLanguage();
        String nombreIdioma = ubicacionActual.getDisplayLanguage();
        //Switch: Casos asociados al combobox
        //en_us: Inglés / es_MX:Español
        switch (idioma) {
            case "en_US":
                String mensaje = mensajeSaludo.getMessage("saludo.pais", null ,Locale.US);
                model.addAttribute("mensaje", mensaje);
                String lenguaje = mensajeSaludo.getMessage("frase", null, Locale.US);
                model.addAttribute("frase", lenguaje);
                /*Obtener en consola la ubicación geográfica
                System.out.println(codigoPais +":"+nombrePais);
                System.out.println(codigoIdioma +":"+nombreIdioma);
                */
                break;
            case "es_MX":
                mensaje = mensajeSaludo.getMessage("saludo.pais", null, ubicacionActual);
                model.addAttribute("mensaje", mensaje);
                lenguaje = mensajeSaludo.getMessage("frase", null, ubicacionActual);
                model.addAttribute("frase", lenguaje);
                /*Obtener en consola la ubicación
                System.out.println(codigoPais +":"+nombrePais);
                System.out.println(codigoIdioma +":"+nombreIdioma);
                */
                break;
        }
        return "index";
    }
}
