package ss16.thuc_hanh.find_max;

import java.util.List;

import static ss16.thuc_hanh.find_max.ReadAndWriteFile.findMax;

public class Main {
    public static void main(String[] args) {
        String Path="numbers.txt";
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile(Path);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
}
