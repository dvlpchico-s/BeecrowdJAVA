import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TabelaHash {

    static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter outputWriter = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int testCases = readInt(), tableSize, index;
        int[] hashParams;
        String[] elements;
        while (testCases-- > 0) {
            hashParams = readIntArray();
            tableSize = hashParams[0];
            String[] hashTable = new String[tableSize];
            Arrays.fill(hashTable, "");
            elements = readLine().split("\\s");
            for (String element : elements) {
                index = toInt(element) % tableSize;
                hashTable[index] += " -> " + element;
            }
            for (int i = 0; i < tableSize; i++) {
                outputWriter.println(i + hashTable[i] + " -> \\");
            }
            if (testCases != 0) {
                outputWriter.println();
            }
        }
        outputWriter.close();
    }

    private static String readLine() throws IOException {
        return inputReader.readLine();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(inputReader.readLine());
    }

    private static int[] readIntArray() throws IOException {
        String[] line = inputReader.readLine().split("\\s");
        int length = line.length;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(line[i]);
        }
        return intArray;
    }

    private static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
