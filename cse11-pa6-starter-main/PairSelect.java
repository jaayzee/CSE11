import tester.*;

class Pair {
    int a;
    int b;
    Pair (int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class PairSelect {
    int[] getAs(Pair[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].a;
        }
        return newArr;
    }

    boolean tests(Tester f) {
        Pair num1 = new Pair(1, 2);
        Pair num2 = new Pair(2, 3);
        Pair num3 = new Pair(3, 4);
        Pair num4 = new Pair(4, 5);
        Pair num5 = new Pair(5, 6);
        Pair num0 = new Pair(0, 0);
        Pair num100 = new Pair(100,1);
        Pair numneg100 = new Pair(-100,-1);
        Pair[] a = {num1, num2, num3, num4, num5};
        Pair[] b = {num5, num4, num3, num2, num1, num2, num3, num4, num5};
        Pair[] c = {num100, num0, num0, num0, numneg100};
        Pair[] d = {num0, num0, num0, num0, num0};
        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {5, 4, 3, 2, 1, 2, 3, 4, 5};
        int[] c1 = {100, 0, 0, 0, -100};
        int[] d1 = {0, 0, 0, 0, 0};
        return f.checkExpect(this.getAs(a), a1) &&
        f.checkExpect(this.getAs(b), b1) &&
        f.checkExpect(this.getAs(c), c1) &&
        f.checkExpect(this.getAs(d), d1);
    }
}