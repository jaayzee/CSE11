import tester.*;

interface Number {
    int numerator();
    int denominator();
    Number add(Number other);
    Number multiply(Number other);
    String toString();
    double toDouble();
}
class WholeNumber implements Number
{
    int n;
    WholeNumber(int n)
    {
        this.n = n;
    }
    public int numerator()
    {
        return this.n;
    }
    public int denominator()
    {
        return 1;
    }
    public Number add(Number other)
    {
        return new Fraction((other.numerator() + this.numerator()*other.denominator()) , other.denominator());
    }
    public Number multiply(Number other)
    {
        return new Fraction((this.numerator() * other.numerator()) , other.denominator());
    }
    public String toString()
    {
        return String.valueOf(this.n);
    }
    public double toDouble()
    {
        return Double.valueOf(this.n);
    }
}

class Fraction implements Number
{
    int n;
    int d;
    Fraction(int n, int d)
    {
        this.n = n;
        this.d = d;
    }
    public int numerator()
    {
        return this.n;
    }
    public int denominator()
    {
        return this.d;
    }
    public Number add(Number other)
    {
        return new Fraction(((this.denominator() * other.numerator()) + (this.numerator() * other.denominator())) , (this.denominator() * other.denominator()));
    }
    public Number multiply(Number other)
    {
        return new Fraction((this.numerator() * other.numerator()) , (this.denominator() * other.denominator()));
    }
    public String toString()
    {
        return this.n + "/" + this.d;
    }
    public double toDouble()
    {
        return Double.valueOf(n)/Double.valueOf(d);
    }
}

class ExamplesNumber{
    //EXPLORATION 
        double p1 = 0.1 + 0.2 + 0.3 ;
        double p2 = 0.1 + (0.2 + 0.3);
            Number a = new Fraction(1, 10);
            Number b = new Fraction(2, 10);
            Number c = new Fraction(3, 10);
        String p3 = (a.add(b).add(c)).toString();
        String p4 = (a.add(b.add(c))).toString();
}
