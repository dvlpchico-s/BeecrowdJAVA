import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalançodeParêntesesI {
    public static void main(String[] 
 args) throws IOException {
        InputStreamReader 
 inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); 


        while (bufferedReader.ready())  
 {
            char[] expression = bufferedReader.readLine().trim().toCharArray();

            int i;
            int numParentheses = 0;
            for (i = 0; i < expression.length; ++i) {
                if (expression[i] == '(') {
                    numParentheses += 1;
                } else if (expression[i] == ')') {
                    if (numParentheses == 0) {
                        break;
                    }
                    numParentheses -= 1;
                }
            }

            if (i == expression.length && numParentheses == 0) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
    }
}