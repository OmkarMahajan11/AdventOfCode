import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

class DayTwo {

    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();
    }

    public static void partOne() throws IOException {
        System.out.println(
                Files.lines(Paths.get("day2-input.txt"))
                        .filter(DayTwo::isValidPartOne)
                        .count());
    }

    public static boolean isValidPartOne(String s) {
        int min, max;
        char letter;
        String password;

        String[] splitString = s.split(" ");
        String[] numString = splitString[0].split("-");

        min = Integer.parseInt(numString[0]);
        max = Integer.parseInt(numString[1]);
        letter = splitString[1].charAt(0);
        password = splitString[2];

        long count = password.chars().filter(ch -> ch == letter).count();

        return min <= count && count <= max;
    }

    public static void partTwo() throws IOException {
        System.out.println(
                Files.lines(Paths.get("day2-input.txt"))
                        .filter(DayTwo::isValidPartTwo)
                        .count());
    }

    public static boolean isValidPartTwo(String s) {
        int i1, i2;
        char letter;
        String password;

        String[] splitString = s.split(" ");
        String[] numString = splitString[0].split("-");

        i1 = Integer.parseInt(numString[0]) - 1;
        i2 = Integer.parseInt(numString[1]) - 1;
        letter = splitString[1].charAt(0);
        password = splitString[2];

        return ((password.charAt(i1) == letter) ? 1 : 0) + ((password.charAt(i2) == letter) ? 1 : 0) == 1;
    }
}