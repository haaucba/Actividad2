package ar.edu.udeci.pv;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.cli.*;

public class Main {
    // Logger de Log4j
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        // Configurar Log4j (archivo log4j.properties en classpath)
        PropertyConfigurator.configure(Main.class.getClassLoader()
                .getResource("log4j.properties"));

        // Definición de opciones
        Options options = new Options();
        options.addOption("n", "name", true, "Nombre de usuario");
        options.addOption("h", "help", false, "Muestra ayuda");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);

            if (cmd.hasOption("h")) {
                formatter.printHelp("Actividad2", options);
                return;
            }

            String name = cmd.getOptionValue("n", "Invitado");
            logger.info("Hola, " + name + "!");
            System.out.println("Hola, " + name + "!");

        } catch (ParseException e) {
            logger.error("Error al parsear los argumentos: " + e.getMessage());
            System.err.println("Argumentos inválidos.");
            formatter.printHelp("Actividad2", options);
            System.exit(1);
        }
    }
}