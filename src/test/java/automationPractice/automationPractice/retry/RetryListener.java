package automationPractice.automationPractice.retry;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Remya on 1/10/2018.
 */
public class RetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retry=annotation.getRetryAnalyzer();
        if (retry==null){
            annotation.setRetryAnalyzer(Retry.class);
        }
    }
}
