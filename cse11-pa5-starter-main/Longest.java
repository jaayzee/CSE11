class Longest
{
    public static void main(String[] args)
    {
        if (args.length <= 0) System.out.println("");
        else{
            String word = args[0];
            for (int i = 0; i < args.length; i++)
            {
                if(args[i].length() > word.length())
                {
                    word = args[i];
                }
                else word = word;
            }
            System.out.println(word);
        }
    }
}