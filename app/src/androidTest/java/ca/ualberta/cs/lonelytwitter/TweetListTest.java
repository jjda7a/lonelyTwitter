package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinjo on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));

    }
    public void testAddTweetException() {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("Test tweet");
        Tweet tweet2 = new NormalTweet("Test tweet");
        try {
            tweets.addTweet(tweet1);
            tweets.addTweet(tweet2);
        } catch(IllegalArgumentException e){

        }
        fail();
    }
    public void testhasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("Hello");
        Tweet tweet2 = new NormalTweet("Goodbye");
        Tweet tweet3 = new NormalTweet("Hello");
        //assertFalse(tweets.hasTweet(tweet));

        tweets.addTweet(tweet1);

        tweets.addTweet(tweet2);
        tweets.hasTweet(tweet2);
        assertFalse(tweets.hasTweet(tweet2));

        tweets.addTweet(tweet3);
        tweets.hasTweet(tweet3);
        assertTrue(tweets.hasTweet(tweet3));
    }
    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        tweets.addTweet(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));

    }
    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());

    }
    public void testGetTweets() {
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("Hello");
        Tweet tweet2 = new NormalTweet("Goodbye");

        assertTrue(tweets.getTweets().isEmpty());
        tweets.addTweet(tweet1);
        tweets.addTweet(tweet2);
        assertTrue(tweet1.getDate().before(tweet2.getDate()));

    }
    public void testRemoveTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        tweets.addTweet(tweet);
        tweets.delete(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }
    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");
        int count = 1;

        tweets.addTweet(tweet);
        assertEquals(count, tweets.getCount());
    }
}
