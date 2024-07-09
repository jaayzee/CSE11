class TextTweet
{
    String contents;
    int likes;
    TextTweet(String contents, int likes)
    {
        this.contents = contents;
        this.likes = likes;
    }
    Boolean hasMention(String username)
    {   
        if(this.contents.contains("@" + username))
        {
            int indexAfter = this.contents.indexOf("@") + username.length() + 1;
            if(indexAfter >= this.contents.length())
            {
                return this.contents.length() == (indexAfter - 1);
            }
            else
            {
                char comp = this.contents.charAt(indexAfter);
                return comp == ' ';
            }
        }
        else
        {
            return false;
        }
    }
    Boolean hasLike()
    {
        return (this.likes > 0);
    }
    String firstMention()
    {
        if(this.contents.contains("@"))
        {
            int left = this.contents.indexOf("@");
            int right = this.contents.substring(left).indexOf(" ") + left;
            if(right > left)
            {
                return this.contents.substring(left + 1,right);
            }
            else
            {
                return "";
            }
        }
        else
        {
            return "";
        }
    }
}

class ReplyTweet
{
    TextTweet ReplyTo;
    String contents;
    int likes;
    ReplyTweet(TextTweet ReplyTo, String contents, int likes)
    {
        this.ReplyTo = ReplyTo;
        this.contents = contents;
        this.likes = likes;
    }
    Boolean morePopularReply()
    {
        return this.likes > this.ReplyTo.likes;
    }
    int allLikes()
    {
        return this.likes + this.ReplyTo.likes;
    }
    Boolean hasMention(String username)
    {
        TextTweet a = new TextTweet(this.contents, this.likes);
        return (a.hasMention(username) || this.ReplyTo.hasMention(username));
    }
}
class Drill3
{
    TextTweet test = new TextTweet("YOHOHO BROTHER @SANTA WHATS GOOD",200);
    Boolean no = test.hasMention("Santa");
    Boolean yes = test.hasMention("SANTA");
    Boolean yes2 = test.hasLike();
    String santa = test.firstMention();
    TextTweet test1 = new TextTweet("YOHOHO BROTHER WHATS GOOD @SANTA",200);
    String nosanta = test1.firstMention();
    ReplyTweet reply = new ReplyTweet(test,"MY BOOOOOOY @CHRISPAUL",50);
    ReplyTweet reply1 = new ReplyTweet(test,"MY BOOOOOOY @BEYONCE",500);
    Boolean contest = reply.morePopularReply();
    Boolean contest1 = reply1.morePopularReply();
    int everything = reply.allLikes();
    Boolean involved = reply.hasMention("CHRISPAUL");
    Boolean involved1 = reply.hasMention("JBond");    
}