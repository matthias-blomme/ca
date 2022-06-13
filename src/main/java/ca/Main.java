package ca;

import java.io.IOException;

import ca.adapters.cli.CliClient;
import ca.infrastructure.factories.ExecutableFactory;

public class Main {

   public static void main(String[] args) throws IOException {

        CliClient cli = ExecutableFactory.createCli();
        cli.init();

   } 
    
}
