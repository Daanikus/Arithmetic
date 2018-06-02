package arithmetic;

import java.util.ArrayList;

public class Arithmetic {

    private final int NUM_MAX = 3;
    private ArrayList<Character> operators = new ArrayList<>();

    public ArrayList<Character> handleLines(String[] eq) {
        String[] inputsStr = eq[0].split(" ");
        String[] resultStr = eq[1].split(" ");
        String type = resultStr[1];
        int[] input = new int[NUM_MAX];
        int result = Integer.parseInt(resultStr[0]);
        try {
            input[0] = Integer.parseInt(inputsStr[0]);
            input[1] = Integer.parseInt(inputsStr[1]);
            input[2] = Integer.parseInt(inputsStr[2]);
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Boolean isSolvable = solve(input, 1, input[0], result);
        System.out.println(isSolvable);
        return isSolvable ? this.operators : new ArrayList<Character>('x');
        
    }

    public Boolean solve(int[] operands, int pos, int total, int target) {
        int currNum = operands[pos];
        if (pos > operands.length - 1 || currNum * total > target || currNum + total > target) {
            //this.operators.remove(operators.size() - 1);
            return false;
        }

        if (pos == operands.length - 1) {
            if (currNum + total == target) {
                
                return true;
            }
            if (currNum * total == target) {
                
                return true;
            }
        } else {
            if (currNum + total < target) {
                
                if (solve(operands, ++pos, currNum + total, target)) {
                    this.operators.add('+');
                    return true;
                }
            }
            if (currNum * total < target) {
                
                if (solve(operands, ++pos, currNum * total, target)) {
                    this.operators.add('*');
                    return true;
                }
            }
        }
        return false;
    }
}