package data;

import exceptions.InvalidDNIDocumException;

public class Nif {

    private final String nif;
    public Nif(String nif) throws InvalidDNIDocumException {
        if(nif == null) {
            throw new IllegalArgumentException("Nif cannot be null");
        }
        if(!validateNif(nif)) {
            throw new InvalidDNIDocumException("Not valid Nif");
        }

        this.nif = nif;
    }

    // Method for validating NIF
    private boolean validateNif(String nif) {
        // Verify correct length NIF
        if (nif.length() != 9) {
            return false;
        }

        // Extract letter and numbers from NIF
        char letter = nif.charAt(8);
        String numberStr = nif.substring(0, 8);

        // Verify it is numeric
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            return false;
        }

        // Calculate the corresponding letter of a number
        char calculatedLetter = calculateLetter(numberStr);

        // Compare the letter to the letter of the NIF
        return letter == calculatedLetter;
    }

    // Method for calculating the corresponding letter
    private char calculateLetter(String numerosStr) {
        char[] letters = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray();

        // Calculate the index
        int numbers = Integer.parseInt(numerosStr);
        int index = numbers % 23;

        return letters[index];
    }
}
