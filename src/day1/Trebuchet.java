package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Trebuchet {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/day1/input.txt"));
        int sum = 0;
        for (String line : lines) {
            char firstDigit = getFirstDigit(line);
            char lastDigit = getLastDigit(line);
            int result = Integer.parseInt("" + firstDigit + lastDigit);
            sum += result;
        }
        System.out.println(sum);
    }

    private static char getFirstDigit(String line) {
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return 0;
    }

    private static char getLastDigit(String line) {
        char[] charArray = line.toCharArray();
        for (int i = charArray.length - 1; i > -1; i--) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                return c;
            }
        }
        return 0;
    }
}
