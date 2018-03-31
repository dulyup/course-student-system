package org.lyup.coursesystem.courserservice.lambda;

import java.util.Map;

import org.lyup.coursesystem.courserservice.model.Course;
import org.lyup.coursesystem.courserservice.model.Professor;
import org.lyup.coursesystem.courserservice.service.impl.CourseServiceImpl;
import org.lyup.coursesystem.courseweb.manager.impl.CourseManagerImpl;
import org.lyup.coursesystem.courseweb.manager.impl.ProfessorManagerImpl;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.UnsubscribeRequest;

public class EmailStudentAnnouncement implements RequestHandler<DynamodbEvent, String> {

	private static AmazonSNS SNS_CLIENT = AmazonSNSClientBuilder.standard().withRegion(Regions.US_WEST_2).build();

	@Override
	public String handleRequest(DynamodbEvent input, Context context) {
		String message = "";
		// Read DDB Records
		if (input.getRecords() != null) {
			for (DynamodbEvent.DynamodbStreamRecord record : input.getRecords()) {
				if (record == null || record.getEventName().equals("REMOVE")) {
					continue;
				}
				context.getLogger().log("Record: " + record);
				// Send notification
				message = formatMessage(record);		
				String subject = formatSubject(record);
				// Business Logic to decide to send a notification

				// send Notification
				String courseId = record.getDynamodb().getNewImage().get("course_id").getS();
				String topicArn = getTopicArnByCourseId(courseId);
				sendEmailNotification(topicArn, message, subject);
			}
		}
		return message;
	}

	/**
	 * Call this function to create topic once a new course created
	 * 
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
		SNS_CLIENT.unsubscribe(new UnsubscribeRequest(topicArn));
		return true;
	}

	private String getTopicArnByCourseId(String courseId) {
		return new CourseServiceImpl().getCourseById(courseId).getTopicArn();
	}

	private String formatSubject(DynamodbStreamRecord record) {
		System.out.println("map:" + record.getDynamodb().getNewImage());
		Map<String, AttributeValue> map = record.getDynamodb().getNewImage();
		String courseId = map.get("course_id").getS();
		StringBuilder sb = new StringBuilder();
		sb.append("Message from Course ");
		sb.append(courseId);
		return sb.toString();
	}

	private String formatMessage(DynamodbStreamRecord record) {
		Map<String, AttributeValue> map = record.getDynamodb().getNewImage();
		StringBuilder sb = new StringBuilder();
		if (map != null) {
			System.out.println("courseId: "+ map.get("course_id").getS());
			System.out.println("message: "+ map.get("message").getS());
			String message = map.get("message").getS();
			String courseId = map.get("course_id").getS();
			Course course = new CourseManagerImpl().getCourseById(courseId);
			String courseName = course.getCourseName();
			String profId = course.getProfId();
			Professor prof = new ProfessorManagerImpl().getProfessorById(profId);
			String profName = "To Be Announced";
			String profEmail = "To Be Announced";
			if (prof != null) {
				profName = prof.getPFirstName() + " " + prof.getPLastName();
				profEmail = prof.getEmail();
			}
			sb.append("You have new message from Course: ");
			sb.append(courseId);
			sb.append("\n");
			sb.append("Course Name: ");
			sb.append(courseName);
			sb.append("\n");
			sb.append("Professor: ");
			sb.append(profName);
			sb.append("\n");
			sb.append("Email: ");
			sb.append(profEmail);
			sb.append("\n");
			sb.append("Announcement: ");
			sb.append(message);
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	private void sendEmailNotification(String topicArn, final String message, final String subject) {
		// Message Object
		PublishRequest publishRequest = new PublishRequest(topicArn, message, subject);
		// Call Client.publishMessage
		SNS_CLIENT.publish(publishRequest);
	}

}
