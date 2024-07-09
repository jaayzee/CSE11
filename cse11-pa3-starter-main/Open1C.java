class Ctype
{
    String uhoh(String oh, int yeah)
    {
        return oh + " is around " + yeah + " feet tall"; 
    }
    String booboo(String oh, int yeah)
    {
        return oh + " is around " + yeah + " feet tall"; 
    }
}

class Open1C
{
    Ctype a = new Ctype();
    String b = a.uhoh("Ben",7);
    String c = a.booboo("Sam",13);
}
