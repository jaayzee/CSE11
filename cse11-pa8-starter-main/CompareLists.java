import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class PointCompare implements Comparator<Point> {
  public int compare(Point a, Point b) {
    int ycomp = a.y-b.y;
    int xcomp = a.x-b.x;
    if(ycomp != 0) { return ycomp; }
    else { return xcomp; }
  }
}

class PointDistanceCompare implements Comparator<Point> {
  public int compare(Point a, Point b) {
    double a_dist = Math.sqrt(Math.pow(a.x, 2) + Math.pow(a.y, 2));
    double b_dist = Math.sqrt(Math.pow(b.x, 2) + Math.pow(b.y, 2));
    if (a_dist < b_dist) { return -1; }
    else if (a_dist == b_dist) { return 0; }
    else { return 1; }
  }
}

class StringCompare implements Comparator<String> {
  public int compare(String a, String b) {
    return a.compareTo(b);
  }
}

class StringLengthCompare implements Comparator<String> {
  public int compare(String a, String b) {
    return a.length() - b.length();
  }
}

class BooleanCompare implements Comparator<Boolean> {
  public int compare(Boolean a, Boolean b) {
    if (a && !b) { return 1; }
    else if (!a && b) { return -1; }
    else { return 0; }
  }
}

class CompareLists {
  public <E> E minimum(List<E> stuff, Comparator<E> term) {
    // if(stuff == null) { return null; }
    E min = null;
    for(E i : stuff) {
      if(min == null || term.compare(min, i) > 0) {
        min = i;
      }
    }
    return min;
  }

  public <E> E minimum(E[] arr, Comparator<E> term) {
    E min = null;
    for(E i : arr) {
      if(min == null || term.compare(min, i) > 0) {
        min = i;
      }
    }
    return min;
  }

  public <E> List<E> greaterThan(List<E> stuff, Comparator<E> term, E elem) {
    List<E> ans = new ArrayList<E>();
    for(E i : stuff) {
      if(term.compare(i, elem) > 0) {
        ans.add(i);
      }
    }
    return ans;
  }

  public <E> boolean inOrder(List<E> stuff, Comparator<E> term) {
    E temp = null;
    for (E i : stuff) {
      if(i == null) { throw new IllegalArgumentException("null value in list"); }
      else if(temp != null && term.compare(temp, i) > 0) { return false; }
      else { temp = i; }
    }
    return true;
  }

  public <E> boolean inOrder(E[] arr, Comparator<E> term) {
    E temp = null;
    for (E i : arr) {
      if(i == null) { throw new IllegalArgumentException("null value in array"); }
      else if(temp != null && term.compare(temp, i) > 0) { return false; }
      else { temp = i; }
    }
    return true;
  }

  public <E> List<E> merge(Comparator<E> term, List<E> a, List<E> b) {
    List<E> ans = new ArrayList();
    int i = 0, j = 0;
    while(i < a.size() || j < b.size()) {
      if(i < a.size() && j < b.size()) {
        if(a.get(i) == null) { throw new IllegalArgumentException("null value in first list"); }
        if(b.get(j) == null) { throw new IllegalArgumentException("null value in second list"); }
        if(term.compare(a.get(i), b.get(j)) <= 0) {
          ans.add(a.get(i));
          i++;
        } else {
          ans.add(b.get(j));
          j++;
        }
      } else if(i < a.size()) {
        if(a.get(i) == null) { throw new IllegalArgumentException("null value in first list"); }
          ans.add(a.get(i));
          i++;
      } else {
        if(b.get(j) == null) { throw new IllegalArgumentException("null value in second list"); }
          ans.add(b.get(j));
          j++;
      }
    }
    return ans;
  }

  boolean tests6(Tester t6) {
      Point a1 = new Point(1, 1);
      Point a2 = new Point(2, 2);
      Point a3 = new Point(200, 200);
      Point a4 = new Point(200, 100);
      Point a5 = new Point(-3, 3);
      List p1 = new ArrayList<Point>();
      p1.add(a1); p1.add(a2); p1.add(a3); p1.add(a4); p1.add(a5);
      List temp = new ArrayList<Point>();
      temp.add(a3); temp.add(a4);
      //
      List p2 = new ArrayList<String>();
      p2.add("Pickaxe");p2.add("Shear");p2.add("Minecart");p2.add("Sign");p2.add("Bucket");
      List temp2 = new ArrayList<String>();
      temp2.add("Minecart");
      Point[] p3 = { a1, a2, a3, a4, a5 };
      String[] p4 = { "Pickaxe", "Shear", "Minecart", "Sign", "Bucket"};
      //
      Point a6 = new Point(3, 3);
      Point a7 = new Point(6, 6);
      Point a8 = new Point(7, 7);
      Point a9 = new Point(4, 4);
      Point a10 = new Point(5, 5);
      Point a11 = new Point(8, 8);
      List L1 = new ArrayList<Point>();
      L1.add(a1); L1.add(a2); L1.add(a6); L1.add(a7); L1.add(a8);
      List L2 = new ArrayList<Point>();
      L2.add(a9); L2.add(a10); L2.add(a11); L2.add(a3);
      List L3 = new ArrayList<String>();
      L3.add("a"); L3.add("abc"); L3.add("abcde"); L3.add("abcdefg"); L3.add("abcdefghi");
      List L5 = new ArrayList<String>();
      L5.add("ab"); L5.add("abcd"); L5.add("abcdef"); L5.add("abcdefgh"); L5.add("abcdefghij");
      List L4 = new ArrayList<Point>();
      L4.add(a1); L4.add(a2); L4.add(null); L4.add(a7); L4.add(a8);
      List tAns = new ArrayList<Point>();
      tAns.add(a1); tAns.add(a2); tAns.add(a6); tAns.add(a9); tAns.add(a10); tAns.add(a7); tAns.add(a8); tAns.add(a11); tAns.add(a3);
      List tAns2 = new ArrayList<String>();
      tAns2.add("a"); tAns2.add("ab"); tAns2.add("abc"); tAns2.add("abcd"); tAns2.add("abcde"); tAns2.add("abcdef"); tAns2.add("abcdefg"); tAns2.add("abcdefgh"); tAns2.add("abcdefghi"); tAns2.add("abcdefghij");
    Comparator pComp = new PointCompare();
    Comparator pdComp = new PointDistanceCompare();
    Comparator slComp = new StringLengthCompare();
    return t6.checkExpect(minimum(p1, pComp), a1) &&
    t6.checkExpect(minimum(p1, pdComp), a1) &&
    t6.checkExpect(minimum(p2, slComp), "Sign") &&
    t6.checkExpect(minimum(p3, pComp), a1) &&
    t6.checkExpect(minimum(p3, pdComp), a1) &&
    t6.checkExpect(minimum(p4, slComp), "Sign") &&
    t6.checkExpect(greaterThan(p1, pComp, a5), temp) &&
    t6.checkExpect(greaterThan(p1, pdComp, a5), temp) &&
    t6.checkExpect(greaterThan(p2, slComp, "Pickaxe"), temp2) &&
    t6.checkExpect(inOrder(p1, pComp), false) &&
    t6.checkExpect(inOrder(p1, pdComp), false) &&
    t6.checkExpect(inOrder(p2, slComp), false) &&
    t6.checkExpect(inOrder(p3, pComp), false) &&
    t6.checkExpect(inOrder(p3, pdComp), false) &&
    t6.checkExpect(inOrder(p4, slComp), false) &&
    t6.checkExpect(merge(pComp, L1, L2), tAns) &&
    t6.checkException(new IllegalArgumentException("null value in second list"), this, "merge", pdComp, L1, L4) &&
    t6.checkExpect(merge(slComp, L3, L5), tAns2);
  }
  boolean tests(Tester t1) {
    PointCompare i = new PointCompare();
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(200, 200);
    Point p4 = new Point(200, 100);
    return t1.checkExpect(i.compare(p1, p2), -1) &&
    t1.checkExpect(i.compare(p1, p1), 0) &&
    t1.checkExpect(i.compare(p4, p3), -100) &&
    t1.checkExpect(i.compare(p3, p2), 198);
  }
  boolean tests2(Tester t2) {
    PointDistanceCompare i = new PointDistanceCompare();
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(100, 100);
    Point p4 = new Point(200, 200);
    return t2.checkExpect(i.compare(p1, p2), -1) &&
    t2.checkExpect(i.compare(p1, p1), 0) &&
    t2.checkExpect(i.compare(p4, p3), 1) &&
    t2.checkExpect(i.compare(p1, p3), -1);
  }
  boolean tests3(Tester t3) {
    StringCompare i = new StringCompare();
    return t3.checkExpect(i.compare("true", "true"), 0) &&
    t3.checkExpect(i.compare("false", "false"), 0) &&
    t3.checkExpect(i.compare("Sheep", "Cow"), 16) &&
    t3.checkExpect(i.compare("Carl", "Shear"), -16);
  }
  boolean tests4(Tester t4) {
    StringLengthCompare i = new StringLengthCompare();
    return t4.checkExpect(i.compare("true", "true"), 0) &&
    t4.checkExpect(i.compare("false", "false"), 0) &&
    t4.checkExpect(i.compare("Carl", "Shear"), -1) &&
    t4.checkExpect(i.compare("Sheep", "Cow"), 2);
  }
  boolean tests5(Tester t5) {
    BooleanCompare i = new BooleanCompare();
    return t5.checkExpect(i.compare(true, true), 0) &&
    t5.checkExpect(i.compare(false, false), 0) &&
    t5.checkExpect(i.compare(true, false), 1) &&
    t5.checkExpect(i.compare(false, true), -1);
  }
}