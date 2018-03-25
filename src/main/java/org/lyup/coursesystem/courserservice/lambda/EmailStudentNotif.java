package org.lyup.coursesystem.courserservice.lambda;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.lyup.coursesystem.courserservice.db.ConnectDB;
import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courserservice.service.impl.CourseServiceImpl;
import org.lyup.coursesystem.courseweb.manager.impl.CourseManagerImpl;
import org.lyup.coursesystem.courseweb.manager.impl.ProfessorManagerImpl;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;

public class EmailStudentNotif implements RequestHandler<DynamodbEvent, String> {

	private static AmazonSNS SNS_CLIENT = AmazonSNSClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
	
	
    @Override
    public String handleRequest(DynamodbEvent input, Context context) {
    	String subject = "";
        // Read DDB Records
        for (DynamodbEvent.DynamodbStreamRecord record: input.getRecords()) {
            if (record == null) {
                continue;
            }
            
//            record.getDynamodb().getKeys();
            //your code here
            
//            String inputString = record.toString();
//            context.getLogger().log("Input:" + input);

            //Send notification
            String message = formatMessage(record);
            subject = formatSubject(record);

            // Business Logic to decide to send a notification
            
            // send Notification
            String courseId = record.getDynamodb().getNewImage().get("courseId").getS();
            String topicArn = getTopicArnByCourseId(courseId);
            sendEmailNotification(topicArn,subject, message);

        }
        return subject;
    }

    /**
     * Call this function to create topic once a new course created 
     * @param topicName
     * @return
     */
    public static String createTopic(String topicName) {
    	return SNS_CLIENT.createTopic(topicName).getTopicArn();
    }
    	
    /**
     * end point: The end point that you want to receive notifications.
     */
    public static Boolean subscribe(String topicArn, String email) {
        SNS_CLIENT.subscribe(topicArn, "email", email);
        return true;
    }
    
    public static Boolean unsubscribe(String topicArn) {
    	SNS_CLIENT.unsubscribe(topicArn);
    	return true;
    }
    
    private String getTopicArnByCourseId(String courseId) {
    	return new CourseServiceImpl().getCourseById(courseId).getTopicArn();
    }
    
    private String formatSubject(DynamodbStreamRecord record) {
    	Map<String, AttributeValue> announ = record.getDynamodb().getNewImage();
    	String courseId = announ.get("courseId").getS();
    	String profId = new CourseManagerImpl().getCourseById(courseId).getProfId();
    	Professor prof = new ProfessorManagerImpl().getProfessorById(profId);
    	String profName = prof.getPFirstName() + " " + prof.getPLastName();
    	StringBuilder sb = new StringBuilder();
    	sb.append("News from ");
    	sb.append(courseId);
    	sb.append("- Professor");
    	sb.append(profName);
    	return sb.toString();
    }
    
    private String formatMessage(DynamodbStreamRecord record) {
    	Map<String, AttributeValue> announ = record.getDynamodb().getNewImage();
    	String anId = announ.get("anId").getS();
    	String message = announ.get("message").getS();
    	String courseId = announ.get("courseId").getS();
    	String profId = new CourseManagerImpl().getCourseById(courseId).getProfId();
    	Professor prof = new ProfessorManagerImpl().getProfessorById(profId);
    	String profName = prof.getPFirstName() + " " + prof.getPLastName();
    	String profEmail = prof.getEmail();
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("Announcement: ");
    	sb.append(anId);
    	sb.append("from Course:");
    	sb.append(courseId);
    	sb.append("\n");
    	sb.append("Professor ");
    	sb.append(profName);
    	sb.append("\n");
    	sb.append(message);
    	sb.append("\n");
    	sb.append("Email: ");
    	sb.append(profEmail);
    	sb.append("to contact the professor if you have any questions");
    	sb.append("\n");
    	return sb.toString();
	}
    
    /**
     * Get an attribute value of a item from table it belongs to 
     * @param tableName
     * @param keyName
     * @param keyValue
     * @return
     */
//    private Item getItemByKey(String tableName, String keyName, String keyValue) {
//		return ConnectDB.getTableByName(tableName).getItem(keyName, keyValue);
//	}

    private void sendEmailNotification(String topicArn, final String subject, final String message) {
        // Message Object
        PublishRequest publishRequest = new PublishRequest(topicArn, message, subject);
        // Call Client.publishMessage
        SNS_CLIENT.publish(publishRequest);
    }
}
