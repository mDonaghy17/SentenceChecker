public class sentenceChecker{


public static void main(String args[]){

//testing 

String test1 = "The quick brown fox said \"hello Mr lazy dog\"."; //this is a valid sentence and tests for a capital letter at the start, a fullstop at the end and having an even amoutn of speech marks
ValidityCheckTest(test1);


String test2 = "One lazy dog is too few, 13 is too many."; // this is a valid sentence, this test checks the number
ValidityCheckTest(test2);

String test3 = "How many \"Lazy dogs\" are there?"; //this sentence is valid, this test checks the ending for the ? makr
ValidityCheckTest(test3);

String test4 = "The quick brown fox said \"hello Mr. lazy dog\"."; //this sentence is invalid as it has 2 "." in it
ValidityCheckTest(test4);

String test5 = "the quick brown fox said \"hello Mr lazy dog\"."; //this sentence is invalid as the first letter is not a capital
ValidityCheckTest(test5);


String test6 = "\"The quick brown fox said \"hello Mr lazy dog.\""; //this sentence is invalid as it ends in a " rather than a .
ValidityCheckTest(test6);


String test7 = "One lazy dog is too few, 12 is too many."; //this sentence is invalid as 12 should be twelve
ValidityCheckTest(test7);

String test8 = "Are there 11, 12, or 13 lazy dogs?"; //this sentence is invalid as 11, 12 and 13 should be written in a text format
ValidityCheckTest(test8);

String test9 = "Are \"there 16, 17, or 18 lazy dogs?"; //this sentence is invalid as it has an uneven amount of "
ValidityCheckTest(test9);






}

public static void ValidityCheckTest(String test){
    System.out.println("Test sentence: "+test);
    System.out.print("The result: ");
    CallTest(test);  
    System.out.println();
}


public static void CallTest(String userInput){

ValidityCheckCapital(userInput);//1) String starts with a capital letter

ValidityCheckQuotations(userInput);//2) String has an even number of quotation marks

ValidityCheckTermination(userInput);//3) String ends with one of the following sentence termination characters ".", "?", "!"

ValidityCheckPeriod(userInput);//4) String has no period characters other than the last character.

ValidityCheckNumber(userInput);//5) numbers below 13 are spelled out.
}

public static void ValidityCheckCapital(String userInput){
//1)
//need to get first letter to check if it is a capital (first character may not be a letter)
char firstLetter =0;

    //finds first letter of string
    for(int i=0; i<userInput.length();i++){
        if(Character.isLetter(userInput.charAt(i))){
            firstLetter=userInput.charAt(i);
            break;
        }        
    }
    //checks if the letter is a capital
    if(firstLetter != 0){
    if(Character.isUpperCase(firstLetter)==false){ //change to == later
        //SENTENCE IS NOT VALID
        System.out.println("This sentence is invalid, the first letter is not a capital letter.");
        return;
        

    }}else{//if a first letter can't be found then the sentence is not valid.
        //The sentenc is not valid
        System.out.println("This sentence is invalid, this sentence contains no letters.");
        return;
    }
}


public static void ValidityCheckQuotations(String userInput){
//2) 
//Checking how many quotation marks there is
int noQuotationMarks=0; //for "
int noQuotationMarks2=0; // for '
for(int i=0; i<userInput.length();i++){
    if(userInput.charAt(i)=='"' ){
        noQuotationMarks++;
    } 
    if(userInput.charAt(i)=='\'' ){
        noQuotationMarks2++;
    } 
    
}
//check if there's an even amount of "
if(noQuotationMarks%2!=0 && noQuotationMarks2%2!=0){
    //SENTENCE IS NOT VALID
    System.out.println("This sentence is invalid. There are not enough quotation marks.");
        return;
}



}


public static void ValidityCheckTermination(String userInput){
//3)
//Checking the last character to ensure it is an approriate termination.
if(userInput.charAt(userInput.length()-1)!='.' && userInput.charAt(userInput.length()-1)!='!'&& userInput.charAt(userInput.length()-1)!='?' ){
    //SENTENCE IS NOT VALID
    System.out.println("This sentence is invalid. This sentence is not terminated with appropriatte punctuation.");
       
}


}


public static void ValidityCheckPeriod(String userInput){
//4)
//String has only one . 
int noFullStops=0;

for(int i=0; i<userInput.length()-1;i++){ 
    if(userInput.charAt(i)=='.'){
             noFullStops++;
    }        
}

if(noFullStops>0){
    //SENTENCE IS NOT VALID
    System.out.println("This sentence is invalid. This sentence has too many full stops.");
        
}
}


public static void ValidityCheckNumber(String userInput){
//5)
//checking if numbers <13 are in a string format

String numberCheckTemp = "";
int numberCheckTempInt =-1;
//searches through the string and if a number is found it is added to the end of a string
for(int i=0; i<userInput.length();i++){
    if(  Character.isDigit(userInput.charAt(i)  )){
        numberCheckTemp = numberCheckTemp + String.valueOf(userInput.charAt(i));
        
    }else{ //once the number ends (once the next char is a string) it will take the string of numbers to validate whether it's less than 13
       if(userInput.charAt(i)!=','){ //ignores instances were numbers are formatted as 1,000.

        if(numberCheckTemp!=""){
        numberCheckTempInt = Integer.valueOf(numberCheckTemp);
        numberCheckTemp = "";

        if(-1<numberCheckTempInt && numberCheckTempInt<13){
            //SENTENCE IS NOT VALID
            System.out.println("This sentence is invalid.  Numbers aren't properly fomatted");
        return;
        }
        else{numberCheckTempInt=-1;}

            }

        }


    }

}


}




}
