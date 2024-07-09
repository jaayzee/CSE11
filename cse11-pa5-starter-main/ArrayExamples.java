import tester.*;

class Pair
{
    int a;
    int b;
    Pair (int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}
class ArrayExamples
{
    String joinWith(String[] arr, String separator)
    {
        if (arr.length <= 0) return ""; 
        else if (arr.length == 1) return arr[0];
        else
        {
            String arr1 = arr[0];
            for (int i = 1; i < arr.length; i++)
            {
                arr1 = arr1 + separator + arr[i];
            }
            return arr1;
        }
    }
    boolean allTrue(boolean[] arr)
    {
        for(Boolean b : arr) 
        {
            if(!b) return false;
        }
        return true;
    }
    boolean allWithinRange(double[] arr, double low, double high)
    {
        int within = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if ((arr[i] > low) && (arr[i] <= high))
            {
                within += 1;
            }
            else return false;
        }
        return (within == arr.length);
    }
    Pair maxmin(int[] arr)
    {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        Pair c = new Pair(min,max);
        return c;
    }
    String earliest(String[] arr)
    {
        String first = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i].compareTo(first) < 0)
            {
                first = arr[i];
            }
            else first = first;
        }
        return first;
    }
    int lookup(String[] keys, int[] values, String key)
    {
        int selection = -1;
        for (int i = 0; i < keys.length; i++)
        {
            if(keys[i].equals(key))
            {
                selection = values[i];
                break;
            }
        }
        return selection;
    }

    boolean testjoinWith(Tester f)
    {
        String[] a = {"a", "b", "c"};
        String[] b = {};
        return f.checkExpect(this.joinWith(a, ":"), "a:b:c") &&
        f.checkExpect(this.joinWith(a, " and "), "a and b and c") &&
        f.checkExpect(this.joinWith(b, ":"), "");
    }
    boolean testalltrue(Tester f)
    {
        boolean[] a = {true, true, true, true, true, true};
        boolean[] b = {true, true, false, true, true, true};
        boolean[] c = {};
        return f.checkExpect(this.allTrue(a), true) &&
        f.checkExpect(this.allTrue(b), false) &&
        f.checkExpect(this.allTrue(c), true);
    }
    boolean testallWithinRange(Tester f)
    {
        double[] a = {2.2,3.3,4.4,5.5,6.6};
        double[] b = {2.2,3.3,4.4,5.5,6.6};
        double[] c = {};
        return f.checkExpect(this.allWithinRange(a ,1.0 ,7.0), true) &&
        f.checkExpect(this.allWithinRange(b ,5.5 ,7.0), false) &&
        f.checkExpect(this.allWithinRange(c ,1.0 ,7.0), true);
    }
    boolean testmaxmin(Tester f)
    {
        Pair a = new Pair(1,6);
        Pair b = new Pair(-2,6);
        Pair c = new Pair(1,1);
        int[] a1 = {1,2,3,4,5,6};
        int[] b1 = {-2,4,5,6};
        int[] c1 = {1};
        return f.checkExpect(this.maxmin(a1), a) &&
        f.checkExpect(this.maxmin(b1), b) &&
        f.checkExpect(this.maxmin(c1), c);
    }
    boolean testearliest(Tester f)
    {
        String[] a = {"abcd", "zdfe", "ktla"};
        String[] b = {"xyz", "ijk", "ijz"};
        String[] c = {"sam"};
        return f.checkExpect(this.earliest(a), "abcd") &&
        f.checkExpect(this.earliest(b), "ijk") &&
        f.checkExpect(this.earliest(c), "sam");
    }
    boolean testlookup(Tester f)
    {
        String[] a = {"a","b","c"};
        int[] a1 = {1,2,3};
        int[] a2 = {100,200,300};
        return f.checkExpect(this.lookup(a,a1,"a"), 1) &&
        f.checkExpect(this.lookup(a,a2,"c"), 300) &&
        f.checkExpect(this.lookup(a,a1,"JAMES"), -1);
    }
}