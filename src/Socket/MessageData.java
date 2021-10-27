package Socket;

import java.io.Serializable;
import java.util.Date;

public class MessageData implements Serializable {
    String userName;
    String messageText;
    Date sentDate;

    public MessageData() {
    }

    public MessageData(String userName, String messageText, Date sentDate) {
        this.userName = userName;
        this.messageText = messageText;
        this.sentDate = sentDate;
    }

    public MessageData(String userName, String messageText) {
        this.userName = userName;
        this.messageText = messageText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return messageText + " from " + userName + " at " + sentDate;
    }
}
