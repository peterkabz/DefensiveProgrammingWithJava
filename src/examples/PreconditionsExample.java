package examples;

import static java.lang.System.out;

public class PreconditionsExample {
    private static final String className = "PreconditionsExample";


    /*PRECONDITIONS ENABLE YOU TO CHECK THAT CERTAIN CONDITIONS ARE MET BEFORE EXECUTION PROCEEDS*/
    public static void main(String[] args) {

    }
    /*

    THIS METHOD DEMONSTRATES THE USE OF GUARDS OR PRECONDITIONS TO DEVELOP ROBUST SOFTWARE

    */

    /*

    USE THE "throws" KEYWORD TO INDICATE THAT AS THIS METHOD EXECUTES, IT MAY THROW AN EXCEPTION OF THE SPECIFIED TYPE,
    THIS WILL FORCE ANY USER OF THIS CLASS TO PUT "try AND catch" BLOCKS TO HANDLE ANY EXCEPTION THAT MIGHT BE THROWN

    */
    public static void executeMethod(SampleData sampleData) throws Exception {

        /*
        PUTTING ALL YOUR CODE IN A "try catch" BLOCK WILL ENSURE NO UN-EXPECTED RUNTIME EXCEPTION BREAKS YOUR SOFTWARE!
        THIS MEANS YOU WILL INTERCEPT ANY ERRORS THAT HAPPEN AND PROVIDE FOR A GRACEFUL TERMINATION IF NEED BE
        */

        try {
            //BEFORE USING ANY VARIABLE, WE MAKE SURE IT IS NOT NULL TO AVOID JAVA THROWING 'NullPointerException'!
            if (!(sampleData == null)) {

                //AFTER THAT WE MAKE SURE THE DATA ELEMENTS THAT WE NAY WANT TO USE OF THIS VARIABLE  ARE NOT NULL
                //PAY ATTENTION THE ORDER OF THESE PRECONDITIONS, WE STARTED WITH CHECKING DATA IS NOT NULL THEN CHECKING IF DATA
                //IS NOT AN EMPTY STRING USING THE length() METHOD
                //SINCE && OPERATOR IS SHORT CIRCUIT, WHEN THE FIRST EXPRESSION EVALUATES TO FALSE, THE SECOND ONE WONT BE EXECUTED!
                //WE USE THIS FEATURE TO PREVENT THE SECOND EXPRESSION FROM BEING EXECUTED IF 'sampleData.data' IS NULL
                //SINCE IT(sampleData.data.length()) WOULD THROW A NullPointerException IF 'sampleData.data' WAS NULL

                if ((sampleData.data != null && sampleData.data.length() > 0)) {
                    sampleData.sampleMethod();
                } else {

                    //HERE WE THROW A IllegalArgumentException  THIS AN INVALID VALUE WAS PASSED
                    //WE USE A CUSTOM MESSAGE TO LET THE USERS OF THIS METHOD KNOW WHAT WENT WRONG
                    throw new IllegalArgumentException("ARGUMENT PASSED TO 'executeMethod()' SHOULD NOT HAVE NULL DATA");
                }
            } else {

                //HERE WE ALSO THROW AN IllegalArgumentException BECAUSE A NULL WAS PASSED
                throw new IllegalArgumentException("ARGUMENT PASSED TO 'executeMethod()' SHOULD NOT BE NULL, NULL WAS PASSED ");
            }

        } catch (Exception exception) {

           /*
           1) LOG THE ERRORS
           2) RETHROW THE EXCEPTION TO ALLOW THE USER HANDLE IT THE WAY THEY CHOOSE

            */
            out.println("************************************************");
            out.println("ERROR OCCURRED WHILE EXECUTING THE METHOD 'executeMethod()'  WITH MESSAGE:\n");
            out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            out.println(exception.getMessage());
            out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            out.println("************************************************");
            throw exception;

        }


    }

}


class SampleData {
    String data;

    public SampleData(String data) {
        this.data = data;
    }

    public void sampleMethod() {
        out.println("******************************************************");
        out.println("METHOD HAS BEEN SUCCESSFULLY EXECUTED!");
        out.println("******************************************************");

    }
}



