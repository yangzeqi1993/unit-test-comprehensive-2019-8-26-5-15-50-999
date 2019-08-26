package tw;

import tw.commands.CalculationNumber;
import tw.commands.GuessInputCommand;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

    private static final int RUN_TIMES = 6;

    public static void main(String[] args) throws Exception {
        CalculationNumber calculationNumber = new CalculationNumber();
        calculationNumber.setAnswerNumber();
        calculationNumber.printAnswerNumber();
        for (int i = 0; i < RUN_TIMES; i++) {
            String input = new GuessInputCommand().input();
            System.out.println(input);
            int[] inputArray = calculationNumber.getInputNumberArray(input);
            if(inputArray.length==0){
                System.out.println("请输入正确的数据");
                i--;
                continue;
            }
            String prompt = calculationNumber.getPromptByCalculation(inputArray);
            if(prompt.equals("4A4B")){
                System.out.println("Victory");
                break;
            }
            System.out.println(prompt);
        }
        System.out.println("Game Over");
    }
}
