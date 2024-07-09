class R
{
    String a;
    R b;
    R(String a, R b)
    {
        this.a = a;
        this.b = b;
    }
}

class ExamplesR
{
    R example = new R("Ben", b);

    // I was not able to, as a field of type R is required to initialize class R, looping into itself
    // Because the ReplyTo field is of class TextTweet, and ReplyTweet isn't of class TextTweet, it can't funnelled into it
}