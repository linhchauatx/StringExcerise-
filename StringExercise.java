import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StringExercise {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a string: ");
        String stringInput = scanner.nextLine();

        System.out.print("enter a character: ");
        String characterInput = scanner.nextLine();

        System.out.println("The number of times the character " +
            characterInput +
            " appeared in the String " + stringInput + ": " +
            countTheWantedCharacter(stringInput,characterInput) );

        countDifferentCharacters(stringInput);
    }

    public static int countTheWantedCharacter(String stringInput, String characterInput) {
        String arr[] = stringInput.split("");

        return countCharacterInArray(arr, characterInput);
    }

    public static void countDifferentCharacters (String stringInput) {
        // Arrays.sort has no effect with array of Strings - don't do this
        // String [] arr = stringInput.split("");
        // Strings Arrays.sort(arr);

        String [] arr = sortString(stringInput).split("");

        ArrayList<String> arr1 = new ArrayList<>();

        // At the beginning, we have zero character
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            // Always count the first char
            if (i == 0) {
              count++;
              arr1.add(arr[i]);
            }
            // if current char is different than the previous, count it
            else if (!(arr[i].equals(arr[i-1]))) {
               count++;
               arr1.add(arr[i]);
            }
        }

        System.out.println("The number of different characters in the String: " + count);

        for (int i = 0; i < arr1.size(); i++) {
            String characterInput = arr1.get(i);
            System.out.println("Character: " + characterInput);
            int charCount = countCharacterInArray(arr, characterInput);

            System.out.println("The number of times that " + characterInput + " shows up: " + charCount);
        }


    }

    public static int countCharacterInArray(String[] arr, String characterInput) {
        int count = 0;

        for(String a : arr) {
            if (a.equals(characterInput)) {
                count++;
            }
        }

        return count;
    }

    // Method to sort a string alphabetically
    public static String sortStringToArray(String stringInput) {
        // convert input string to char array
        char tempArray[] = stringInput.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }
}

