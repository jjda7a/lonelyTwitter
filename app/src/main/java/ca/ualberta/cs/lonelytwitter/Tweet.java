package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 *
 * Main class that allows user to store a string message.
 *
 * @see ImportantTweet
 * @see NormalTweet
 * @version 2.3 2016/02/01
 *
 *
 */
public abstract class Tweet {
    protected Date date;
    protected String message;

    public abstract Boolean isImportant();

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    /**
     *
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return Date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return date.toString() + "|" +message;
    }

}
