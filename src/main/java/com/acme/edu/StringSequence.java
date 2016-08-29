package com.acme.edu;

public class StringSequence {
    private String result = "";
    private String string = "";
    private int counter;

    public String getResult() {
        add("");
        String finishResult = result;
        reset();
        return finishResult;
    }

    public void add(String message) {
        if(message.equals(string)){
            counter++;
            return;
        }

        if (counter > 1) {
            result += " (x" + counter + ")";
        }
        if (counter > 0) {
            result += System.lineSeparator();
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
