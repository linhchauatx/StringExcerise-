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
        int count = 0;

        for(String a : arr) {
            if (a.equals(characterInput)) {
                count++;

            }
        }
        return count;
    }

    public static void countDifferentCharacters (String stringInput) {
        String [] arr = stringInput.split("");

        // Arrays.sort has no effect with array of Stringss - don't need this
        // Strings Arrays.sort(arr);

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

        int numberOfEachCharacter = 0;

        for (int i = 0; i < arr1.size(); i++) {
            System.out.println("Character: " + arr1.get(i));

            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals(arr1.get(i))) {
                    numberOfEachCharacter++;
                }
            }

            System.out.println("The number of times that " + arr1.get(i) + " shows up: " + numberOfEachCharacter);
            numberOfEachCharacter = 0;
        }


    }
}

