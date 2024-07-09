class User
{
    String username;
    String displayName;
    int followers;
    User(String username, String displayName, int followers)
    {
        this.username = username;
        this.displayName = displayName;
        this.followers = followers;
    }
    String toText()
    {
        return this.displayName + " @" + this.username;
    }
}
class Tweet
{
    String content;
    User source;
    int likes;
    String id;
    Tweet(String content, User source , int likes, String id)
    {
        this.content = content;
        this.source = source;
        this.likes = likes;
        this.id = id;
    }
    boolean longerThan(Tweet other)
    {
        if (this.content.length() > other.content.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    boolean moreLikes(Tweet other)
    {
        if (this.likes > other.likes)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    String toText()
    {
        return this.source.displayName + " @" + this.source.username + " : " + this.content + " : " + this.likes + " Likes";
    }
    String toLink()
    {
        return "https://twitter.com/" + this.source.username + "/status/" + this.id;
    }
}
class ExampleTweets
{
    //ALL OF THEM can't represented date, time, retweets, quote tweets, and comments
    
    //https://twitter.com/carterjwm/status/849813577770778624?ref_src=twsrc%5Etfw%7Ctwcamp%5Etweetembed%7Ctwterm%5E849813577770778624%7Ctwgr%5E1e6f38c9a27855a80035c11949c9db6950550c41%7Ctwcon%5Es1_&ref_url=https%3A%2F%2Fwww.brandwatch.com%2Fblog%2Fmost-retweeted-tweets%2F
    // ^^^ + Couldn't represent the picture attached
    User cw = new User("carterjwm", "Carter Wilkerson", 73200);
    Tweet cwT = new Tweet("HELP ME PLEASE. A MAN NEEDS HIS NUGGS", cw , 902900, "849813577770778624?ref_src=twsrc%5Etfw%7Ctwcamp%5Etweetembed%7Ctwterm%5E849813577770778624%7Ctwgr%5E1e6f38c9a27855a80035c11949c9db6950550c41%7Ctwcon%5Es1_&ref_url=https%3A%2F%2Fwww.brandwatch.com%2Fblog%2Fmost-retweeted-tweets%2F");
    
    //https://twitter.com/peachesanscream/status/413261444646326272?ref_src=twsrc%5Etfw%7Ctwcamp%5Etweetembed%7Ctwterm%5E413261444646326272%7Ctwgr%5E8fb92d292ff4e5720829939287cd8f9c893a390f%7Ctwcon%5Es1_&ref_url=https%3A%2F%2Fwww.pocket-lint.com%2Fapps%2Fnews%2Ftwitter%2F141024-37-of-the-most-retweeted-and-funniest-tweets-of-all-time%2F
    //^^^ + Couldn't represent the picture :(
    User pj = new User("peachesanscream", "Periwinkle Jones", 21100);
    Tweet pjT = new Tweet("You've seen nothing until you've seen a picture of a pigeon having a job interview to become a pigeon:", pj, 11200, "413261444646326272?ref_src=twsrc%5Etfw%7Ctwcamp%5Etweetembed%7Ctwterm%5E413261444646326272%7Ctwgr%5E8fb92d292ff4e5720829939287cd8f9c893a390f%7Ctwcon%5Es1_&ref_url=https%3A%2F%2Fwww.pocket-lint.com%2Fapps%2Fnews%2Ftwitter%2F141024-37-of-the-most-retweeted-and-funniest-tweets-of-all-time%2F");
    
    //https://twitter.com/McDonalds/status/1590706995442888705?cxt=HHwWgsDR0bPlqZMsAAAA
    //^^^ + Nothing
    User mcd = new User("Mcdonalds", "Mcdonald's", 4700000);
    Tweet mcdT = new Tweet("link in bioooooooooooooooooooooooooooooooooooooooooooooooooooo", mcd, 26700, "1590708029380362240?cxt=HHwWgICgicuhqpMsAAAA");
    
    //https://twitter.com/McDonalds/status/1590706995442888705?cxt=HHwWgsDR0bPlqZMsAAAA
    //^^^ + Nothing
    Tweet mcdT2 = new Tweet("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", mcd, 559900, "1590706995442888705?cxt=HHwWgsDR0bPlqZMsAAAA");

    //calling methods
    
    //User toText()
    String p1 = mcd.toText(); //expected "Mcdonald's @Mcdonalds"
    String p2 = cw.toText(); //expected "Carter Wilkerson @carterjwm"
    //Tweet longerThan()
    boolean p3 = cwT.longerThan(mcdT2); //expected false
    boolean p4 = mcdT.longerThan(pjT); //expected false
    //Tweet moreLikes()
    boolean p5 = mcdT2.moreLikes(mcdT); //expected true
    boolean p6 = pjT.moreLikes(cwT); //expected false
    //Tweet toText()
    String p7 = pjT.toText(); //expected "Periwinkle Jones @peachesanscream : You've seen nothing until you've seen a picture of a pigeon having a job interview to become a pigeon: : 11200 Likes"
    String p8 = mcdT.toText(); //expected "Mcdonald's @Mcdonalds : link in bioooooooooooooooooooooooooooooooooooooooooooooooooooo : 26700 Likes"
    //Tweet toLink()
    String p9 = mcdT.toLink(); //expected "https://twitter.com/Mcdonalds/status/1590708029380362240?cxt=HHwWgICgicuhqpMsAAAA"
    String p10 = mcdT2.toLink(); //expected "https://twitter.com/Mcdonalds/status/1590706995442888705?cxt=HHwWgsDR0bPlqZMsAAAA"
}