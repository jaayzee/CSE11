import tester.*;

interface Tweet
{
    public boolean isStartOfThreadBy(String author);
    public int totalLikes();
    public String unrollThread();
}

class TextTweet implements Tweet
{
    String contents, author;
    int likes;
        TextTweet(String contents, int likes, String author)
        {
            this.contents = contents;
            this.likes = likes;
            this.author = author;
        }
        public boolean isStartOfThreadBy(String author)
        {
            return author == this.author;
        }
        public int totalLikes()
        {
            return this.likes;
        }
        public String unrollThread()
        {
            return this.author + "\n" 
            + this.likes + " likes" + "\n" 
            + this.contents + "\n";
        }
}

class ReplyTweet implements Tweet
{
    String contents, author;
    int likes;
    Tweet replyTo;
        ReplyTweet(String contents, int likes, String author, Tweet replyTo)
        {
            this.contents = contents;
            this.likes = likes;
            this.author = author;
            this.replyTo = replyTo;
        }
        public boolean isStartOfThreadBy(String author)
        {
            return ((author == this.author) && this.replyTo.isStartOfThreadBy(author));
        }
        public int totalLikes()
        {
            return this.likes + this.replyTo.totalLikes();
        }
        public String unrollThread()
        {
            return this.replyTo.unrollThread()
            + this.author + "\n" 
            + this.likes + " likes" + "\n" 
            + this.contents + "\n";
        }
}

class Tweets
{
    Tweet a = new TextTweet("AYOOOOOOOOOOOOOOOOOO", 12, "benjamin");
    Tweet a1 = new TextTweet("IM UNRELATED BUT HELLO", 30, "anon");
    Tweet a2 = new ReplyTweet("BUT IM RELATED", 0, "benjamin", a);
    Tweet b = new ReplyTweet("WHATD I DOOOOOOOOO", 10, "sam", a);
    Tweet c = new ReplyTweet("YOU KNOW", 8, "greg", b);
    Tweet d = new ReplyTweet("HI GREG", 6, "greg2", c);
    Tweet e= new ReplyTweet("HI GREG", 4, "benjamin", d);

    boolean testing(Tester f)
    {
        //ALL TEXTTWEET TESTS
        return f.checkExpect(this.a.isStartOfThreadBy("benjamin"), true) &&
        f.checkExpect(this.a1.isStartOfThreadBy("benjamin"), false) &&
        f.checkExpect(this.a.totalLikes(), 12) &&
        f.checkExpect(this.a1.totalLikes(), 30) &&
        f.checkExpect(this.a.unrollThread(), "benjamin" + "\n" 
            + 12 + " likes" + "\n" 
            + "AYOOOOOOOOOOOOOOOOOO" + "\n")&&
        f.checkExpect(this.a1.unrollThread(), "anon" + "\n" 
            + 30 + " likes" + "\n" 
            + "IM UNRELATED BUT HELLO" + "\n")&&
        //ALL REPLYTWEET TESTS
        f.checkExpect(this.a2.isStartOfThreadBy("benjamin"), true) &&
        f.checkExpect(this.b.isStartOfThreadBy("sam"), false) &&
        f.checkExpect(this.e.totalLikes(), 40) &&
        f.checkExpect(this.b.totalLikes(), 22) &&
        f.checkExpect(this.e.unrollThread(), "benjamin" + "\n" 
            + 12 + " likes" + "\n" 
            + "AYOOOOOOOOOOOOOOOOOO" + "\n"
            + "sam" + "\n"
            + 10 + " likes" + "\n"
            + "WHATD I DOOOOOOOOO" + "\n"
            + "greg" + "\n"
            + 8 + " likes" + "\n"
            + "YOU KNOW" + "\n"
            + "greg2" + "\n"
            + 6 + " likes" + "\n"
            + "HI GREG" + "\n"
            + "benjamin" + "\n"
            + 4 + " likes" + "\n"
            + "HI GREG" + "\n")&&
        f.checkExpect(this.b.unrollThread(), "benjamin" + "\n" 
            + 12 + " likes" + "\n" 
            + "AYOOOOOOOOOOOOOOOOOO" + "\n"
            + "sam" + "\n"
            + 10 + " likes" + "\n"
            + "WHATD I DOOOOOOOOO" + "\n");
    }
}