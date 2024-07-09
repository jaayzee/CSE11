class Stats
{
    public static void main(String[] args)
    {
        if (args[0].equals("--product"))
        {
            double result = 1;
            for (int i = 1; i < args.length; i++)
            {
                result *= Double.parseDouble(args[i]);
            }
            System.out.println(result);
        }
        else if (args[0].equals("--mean"))
        {
            double result = 0;
            for (int i = 1; i < args.length; i++)
            {
                result += Double.parseDouble(args[i]);
            }
            result /= args.length-1;
            System.out.println(result);
        }
        else if (args[0].equals("--total"))
        {
            double result = 0;
            for (int i = 1; i < args.length; i++)
            {
                result += Double.parseDouble(args[i]);
            }
            System.out.println(result);
        }
        else if (args[0].equals("--max"))
        {
            double result = Double.parseDouble(args[1]);
            for (int i = 2; i < args.length; i++)
            {
                if (Double.parseDouble(args[i]) > result)
                result = Double.parseDouble(args[i]);
            }
            System.out.println(result);
        }
        else if (args[0].equals("--min"))
        {
            double result = Double.parseDouble(args[1]);
            for (int i = 2; i < args.length; i++)
            {
                if (Double.parseDouble(args[i]) < result)
                result = Double.parseDouble(args[i]);
            }
            System.out.println(result);
        }
        else System.out.println("Bad option " + args[0]);
    }
}