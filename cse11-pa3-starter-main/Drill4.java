class Drill4
{
    String phaseOfWater(int n)
    {
        if (n >= 100)
        {
            return "vapor";
        }
        else if (n > 0)
        {
            return "liquid";
        }
        else
        {
            return "solid";
        }
    }
    int maxDifference(int a, int b, int c)
    {
        return Math.abs(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));
    }
    double ringArea(double inner, double outer)
    {
        return Math.PI * (Math.pow(outer, 2) -  Math.pow(inner, 2));
    }

    String p11 = phaseOfWater(10); //expected "liquid"
    String p12 = phaseOfWater(1000); //expected "gas"
    String p13 = phaseOfWater(-10); //expected "solid"

    int p21 = maxDifference(10, 20, 30); //expected 20
    int p22 = maxDifference(-40, 50,-60); //expected 110
    int p23 = maxDifference(-70, -80, -90); //expected 20

    double p31 = ringArea(10, 20); //expected 942.4777961
    double p32 = ringArea(0.3333333333333333, 0.666666666666666); //expetced 1.047197551
    double p33 = ringArea(1.5, 100.5); //expected 31723.80262
}

