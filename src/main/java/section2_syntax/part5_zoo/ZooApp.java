package section2_syntax.part5_zoo;

import java.util.List;

public class ZooApp {

    public static void main(String[] args) {
        ZooApp zooApp = new ZooApp();
        zooApp.processZooData(args);
        zooApp.printZooSummary();
    }

    /**
     * Processes the command line data.
     * @param args
     */
    void processZooData(String[] args) {
        for (String species : args) {
            // Registreer elk dier via de static method in ZooSpecies
            ZooSpecies.registerSpeciesFromString(species);
        }
    }
        /**
         * Prints a summary of the zoo.
         */
        void printZooSummary () {
            // Haal alle geregistreerde soorten op
            final List<ZooSpecies> allSpecies = ZooSpecies.getAllSpecies();

            // Print het aantal verschillende soorten
            System.out.println("The zoo has " + allSpecies.size() + " species.");

            // Print de titel voor de soortenlijst
            System.out.println("These are the species counts:");

            // Loop door alle soorten en print het aantal dieren per soort
            for (ZooSpecies species : allSpecies) {
                System.out.println("    " + species.getSpeciesName() + ": " + species.getIndividualCount());
            }
        }
    }