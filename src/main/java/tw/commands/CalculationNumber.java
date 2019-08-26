package tw.commands;

public class CalculationNumber {
    private int[] answerNumber;

    public boolean isInt(String num){
        return true;
    }

    public int[] getInputNumberArray(String inputNumber){
        String[] numberString = inputNumber.split(" ");
        if(numberString.length!=4){return null;}
        int[] numberInt = new int[numberString.length];
        for(int i=0;i<numberString.length;i++){
            numberInt[i] = Integer.parseInt(numberString[i]);
        }
        return numberInt;
    }

    public void setAnswerNumber(){
        answerNumber = new int[4];
        for(int i=0; i<4;i++){
            int getNumber = (int)(Math.random()*10);
            boolean repeatFag = true;
            for (int j=0; j<=i;j++){
                if(answerNumber[j] == getNumber){
                    repeatFag = false;
                    i--;
                }
            }
            if (repeatFag){
                this.answerNumber[i] = getNumber;
            }
        }
    }

    public void printAnswerNumber(){
        StringBuffer answer = new StringBuffer();
        for(int i=0; i<answerNumber.length;i++){
            String delimiter = "";
            if(i<answerNumber.length-1){
                delimiter = " ";
            }
            answer.append(answerNumber[i]);
            answer.append(delimiter);
        }
        System.out.println(answer);
    }

    public String getPromptByCalculation(int[] inputNumber){
        int numA = 0;
        int numB = 0;
        for(int i=0; i<inputNumber.length; i++){
            for(int j=0; j<answerNumber.length;j++){
                if(inputNumber[i]==answerNumber[j]){
                    numB++;
                    if(i == j){
                        numA++;
                    }
                }
            }
        }
        return numA + "A" + numB + "B";
    }
}
