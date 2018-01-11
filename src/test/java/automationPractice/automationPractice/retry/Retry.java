package automationPractice.automationPractice.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Created by Remya on 1/10/2018.
 */
public class Retry implements IRetryAnalyzer{
    private int retryCount=0;
    private int maxRetryCount=3;
    public boolean retry(ITestResult result){
        if(retryCount<maxRetryCount){
            System.out.println("Retrying Test " + result.getName() + "with status" + getResultStatusName(result.getStatus()));
            retryCount++;
            return true;
        }
        return false;
    }
    public String getResultStatusName(int status){
        String resultName=null;
        if(status==1){
            resultName="Success";

        }
        if (status==2){
            resultName="Failure";
        }
        if(status==3){
            resultName="Skip";

        }
        return resultName;
    }
}
