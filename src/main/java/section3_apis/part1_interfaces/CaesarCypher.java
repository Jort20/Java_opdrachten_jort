package section3_apis.part1_interfaces;

public class CaesarCypher implements EncryptionEngine {

    @Override
    public String encrypt(String message) {
        int shift = 3; // Vaste verschuiving van 3 posities naar links
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            // Controleer of het een letter is
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                // Verschuif de letter
                c = (char) ((c - base - shift + 26) % 26 + base);
            }

            // Voeg het gewijzigde karakter toe aan het resultaat
            result.append(c);
        }

        return result.toString();
        }

    @Override
    public String decrypt(String encryptedMessage) {
        int shift = 3; // Dezelfde verschuiving, maar nu omgekeerd
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char c = encryptedMessage.charAt(i);

            // Controleer of het een letter is
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                // Verschuif de letter in de tegenovergestelde richting
                c = (char) ((c - base + shift + 26) % 26 + base);
            }

            // Voeg het gewijzigde karakter toe aan het resultaat
            result.append(c);
        }

        return result.toString();
    }
}
