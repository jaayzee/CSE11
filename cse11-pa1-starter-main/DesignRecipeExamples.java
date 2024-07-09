import tester.*;

class DesignRecipeExamples {
    int perimeter(int width, int height) //calculates perimeter of box
    {
        return (2 * width) + (2 * height);
    } 
    int p1p1 = this.perimeter(10,10); //expected 40
    int p1p2 = this.perimeter(12,14); //expected 52

    int borderArea(int width, int height, int inwidth, int inheight)
    {
        return (width * height) - (inwidth * inheight);
    }
    int p2p1 = this.borderArea(10,10,5,5); //expected 75
    int p2p2 = this.borderArea(20,20,10,10); //expected 300

    // Using a calculator it gives me an unappended number vs the rounded number in my code
    double MYCHOICE(double usd) //converts usd (double) to the lowest price I could find for a Big Mac Coin at https://www.ebay.com/itm/263897771653
    {
        return Math.round(usd / 19.99 * 100.0)/100.0; //rounds to two decimal places the conversion
    }
    double p3p1 = this.MYCHOICE(12.12); // expected 0.6063031516 rounded to 0.61
    double p3p2 = this.MYCHOICE(15.16); //expected 0.7583791896 rounded to 0.76

    // combines a "stack" (64) items with remaining items (capped at 64)
    int SWITCHEROO(int itemStacks, int items)//takes only integers
    {
        if(items > 64)
        {
            itemStacks += items/64;
            items = items%64;
        }
        return (itemStacks * 64) + items;
    }
    int p4p1 = this.SWITCHEROO(10,12); //expected 652
    int p4p2 = this.SWITCHEROO(10,92); //expected 732
    //int p4p3 = this.SWITCHEROO(10.5,15); // Won't work using double
}

