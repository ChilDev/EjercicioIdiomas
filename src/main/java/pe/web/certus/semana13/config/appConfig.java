//Configuración para cargar mensajes de acuerdo al idioma gestionado (i18n)
//Esta configuración permite adaptar la aplicación a diferentes idiomas, incluido el inglés.
package pe.web.certus.semana13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration //Contexto de configuración para generar Beans

public class appConfig {
    @Bean //Configuración para cargar mensajes al iniciar el proyecto
    //ResourceBundleMessageSource = Método para gestionar mensajes localizados
    public ResourceBundleMessageSource messageSource(){
        // Objeto para gestionar mensajes localizados (source)
        var source = new ResourceBundleMessageSource();
        source.setBasename("i18n/message");//Ubicación de archivos
        //Nota: El nombre de la property debe coincidir con la ruta.
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}
