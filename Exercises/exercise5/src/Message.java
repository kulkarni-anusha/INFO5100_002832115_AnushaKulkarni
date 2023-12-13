import java.util.ArrayList;
import java.util.List;

// Singleton Pattern
class MessagingService {
    private static MessagingService instance;
    private List<MessageSubscriber> subscribers;

    private MessagingService() {
        subscribers = new ArrayList<>();
    }

    // Singleton: Ensures a single instance of MessagingService
    public static MessagingService getInstance() {
        if (instance == null) {
            instance = new MessagingService();
        }
        return instance;
    }

    // Adds a subscriber to the list
    public void subscribe(MessageSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Removes a subscriber from the list
    public void unsubscribe(MessageSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // Sends a message to all subscribers
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
        notifySubscribers(message);
    }

    // Notifies all subscribers with the received message
    private void notifySubscribers(String message) {
        for (MessageSubscriber subscriber : subscribers) {
            subscriber.receiveMessage(message);
        }
    }
}

// Observer Pattern
interface MessageSubscriber {
    // Method to receive and process a message
    void receiveMessage(String message);
}

// Concrete implementation of MessageSubscriber for Email
class EmailSubscriber implements MessageSubscriber {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    // Receives and processes an email message
    @Override
    public void receiveMessage(String message) {
        System.out.println("Email Subscriber " + name + " received message: " + message);
    }
}

// Concrete implementation of MessageSubscriber for SMS
class SMSSubscriber implements MessageSubscriber {
    private String phoneNumber;

    public SMSSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Receives and processes an SMS message
    @Override
    public void receiveMessage(String message) {
        System.out.println("SMS Subscriber " + phoneNumber + " received message: " + message);
    }
}

// Facade Pattern
class MessagingFacade {
    private MessagingService messagingService;

    // Facade constructor, initializes the messaging service
    public MessagingFacade() {
        this.messagingService = MessagingService.getInstance();
    }

    // Facade method to subscribe an email subscriber
    public void subscribeEmail(String name) {
        EmailSubscriber emailSubscriber = new EmailSubscriber(name);
        messagingService.subscribe(emailSubscriber);
    }

    // Facade method to subscribe an SMS subscriber
    public void subscribeSMS(String phoneNumber) {
        SMSSubscriber smsSubscriber = new SMSSubscriber(phoneNumber);
        messagingService.subscribe(smsSubscriber);
    }

    // Facade method to unsubscribe an email subscriber
    public void unsubscribeEmail(String name) {
        EmailSubscriber emailSubscriber = new EmailSubscriber(name);
        messagingService.unsubscribe(emailSubscriber);
    }

    // Facade method to unsubscribe an SMS subscriber
    public void unsubscribeSMS(String phoneNumber) {
        SMSSubscriber smsSubscriber = new SMSSubscriber(phoneNumber);
        messagingService.unsubscribe(smsSubscriber);
    }

    // Facade method to send a message using the messaging service
    public void sendMessage(String message) {
        messagingService.sendMessage(message);
    }
}

public class Message {
    public static void main(String[] args) {
        // Facade Pattern
        MessagingFacade messagingFacade = new MessagingFacade();

        // Subscribing users
        messagingFacade.subscribeEmail("john@example.com");
        messagingFacade.subscribeSMS("+123456789");

        // Sending a message
        messagingFacade.sendMessage("Hello, world!");

        // Unsubscribing a user
        messagingFacade.unsubscribeEmail("john@example.com");

        // Sending another message
        messagingFacade.sendMessage("How are you?");
    }
}
