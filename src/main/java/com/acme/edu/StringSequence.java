package com.acme.edu;

public class StringSequence {
    private String result = "";
    private String string = "";
    private int counter;

    public String getResult() {
        add("");
        String finishResult = result + System.lineSeparator();
        reset();
        return finishResult;
    }

    public void add(String message) {
        if(message.equals(string)){
            counter++;
            return;
        }
        switch(counter) {
            case 0: //result += message;
                break;
            case 1: result += System.lineSeparator();
                break;
            default: result += " (x" + counter + ")" + System.lineSeparator();
                break;
        }
        counter = 1;
        string = message;
        result += message;
    }

    private void reset(){
        result = "";
        string = "";
        counter = 0;
    }
}
