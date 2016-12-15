package com.boogiesoftware.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;
import java.util.Map;

/**
 * Amazon Web Services: hello Lambda functions
 */
public class Hello implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(final Map<String, String> keyValues, final Context context) {
        // The context -object provides following information:
        // https://docs.aws.amazon.com/lambda/latest/dg/java-context-object.html
        //
        // Memory limit, in MB, you configured for the Lambda function.
        context.getMemoryLimitInMB();
        // Name of the Lambda function that is running.
        context.getFunctionName();
        //The Lambda function version that is executing. If an alias is used to invoke the function, then
        // getFunctionVersion will be the version the alias points to.
        context.getFunctionVersion();
        // The ARN used to invoke this function. It can be function ARN or alias ARN. An unqualified ARN executes the
        // $LATEST version and aliases execute the function version it is pointing to.
        context.getInvokedFunctionArn();
        //AWS request ID associated with the request. This is the ID returned to the client called the invoke(). You
        // can use the request ID for any follow up enquiry with AWS support. Note that if AWS Lambda retries
        // the function (for example, in a situation where the Lambda function processing Amazon Kinesis records throw
        // an exception), the request ID remains the same.
        context.getAwsRequestId();
        // The CloudWatch log stream name for the particular Lambda function execution. It can be null if the IAM user
        // provided does not have permission for CloudWatch actions.
        context.getLogStreamName();
        // The CloudWatch log group name associated with the Lambda function invoked. It can be null if the IAM user
        // provided does not have permission for CloudWatch actions.
        context.getLogGroupName();
        // Information about the client application and device when invoked through the AWS Mobile SDK. It can be null.
        // Client context provides client information such as client ID, application title, version name, version code,
        // and the application package name.
        context.getClientContext();
        // Information about the Amazon Cognito identity provider when invoked through the AWS Mobile SDK. It can be null.
        context.getIdentity();

        // Remaining execution time till the function will be terminated, in milliseconds. At the time you create the Lambda function you set maximum time limit, at which time AWS Lambda will terminate the function execution. Information about the remaining time of function execution can be used to specify function behavior when nearing the timeout.
        context.getRemainingTimeInMillis();
        // Returns the Lambda logger associated with the Context object. For more information, se
        context.getLogger();


        LambdaLogger logger = context.getLogger();
        for (String key : keyValues.keySet()) {
            logger.log(String.format("received key=%s value=%s", key, keyValues.get(key)));
        }

        return String.valueOf(keyValues.get("key1"));
    }
}