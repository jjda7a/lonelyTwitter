package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinjo on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) {
        Tweet returnedTweet = getTweet(0);
        if(returnedTweet == tweet){
            throw new IllegalArgumentException();
        }

        tweets.add(tweet);

    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);

    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public void removeTweet(Tweet tweet) {

    }
    public int getCount(){
        int count = 1;
        return count;
    }

    public String getTweets() {
        return null;
    }
}
