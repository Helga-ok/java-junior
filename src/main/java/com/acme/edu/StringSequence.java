package com.acme.edu;

class StringSequence {
    private String result = "";
    private String string = "";
    private int counter;

    String getResult() {
        if (counter > 1) {
            result += string + " (x" + counter + ")" ;
        } else if (counter == 1){
            result += string;
        }
        String finishResult = result + System.lineSeparator();
        reset();
        return finishResult;
    }

    void add(String message) {
        if(message.equals(string)){
            counter++;
            return;
        }
        switch(counter) {
            case 0: result += message;
                break;
            case 1: result += System.lineSeparator();
                break;
            default: result += " (x" + counter + ")" + System.lineSeparator();
                break;
        }
        counter = 1;
        string = message;
    }

    private void reset(){
        result = "";
        string = "";
        counter = 0;
    }
}
