import java.nio.file.*;
import java.io.IOException;
class FileHelper {
    static String[] getLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).toArray(String[]::new);
        }
        catch(IOException e) {
            System.err.println("Error reading file " + path + ": " + e);
            return new String[]{"Error reading file " + path + ": " + e};
        }
    }
}

class StringSearch {
    public static void main(String[] args)
    {
        String[] lines = FileHelper.getLines(args[0]);
        if (args.length == 1) {
            for (String i: lines) {
                System.out.println(i);
            }
        } else if (args.length == 2) {
            Query a = readQuery(args[1]);
            for (String i: lines) {
                if (a.matches(i)) {
                    System.out.println(i);
                }
            }
        } else if (args.length == 3) {
            Query b = readQuery(args[1]);
            for (String i: lines) {
                if (b.matches(i)) {
                    Transform a = readTransform(args[2]);
                    System.out.println(a.transform(i));
                }
            }
            
            
        }
        
    }

    static Query readQuery(String q) {
        Query a = new ContainsQuery("placeholder");
            boolean not = false;
            if (q.substring(0,4).equals("not(")) {
                not = true;
                q = q.substring(4, q.length()-1);
            }
            String[] v = q.split("=");
            switch(v[0]) {
                case "length":
                    a = new LengthQuery(v[1]);
                break;
                case "greater":
                    a = new GreaterQuery(v[1]);
                break;
                case "less":
                    a = new LessQuery(v[1]);
                break;
                case "contains":
                    a = new ContainsQuery(v[1]);
                break;
                case "starts":
                    a = new StartsQuery(v[1]);
                break;
                case "ends":
                    a = new EndsQuery(v[1]);
                break;
            }
            if (not) { a = new NotQuery(a); }
        return a;
    }

    static Transform readTransform(String t) {
        Transform b = new UpperTransform();
            String v = t;
            String cond = "";
            String repl = "";
            if(v.contains(";")) {
                String[] vt = v.split("[=;]");
                v = vt[0];
                cond = vt[1];
                repl = vt[2];
            } else if(v.contains("=")) {
                String[] vt = v.split("=");
                v = vt[0];
                cond = vt[1];
            }
            switch(v) {
                case "upper":
                    b = new UpperTransform();
                break;
                case "lower":
                    b = new LowerTransform();
                break;
                case "first":
                    b = new FirstTransform(cond);
                break;
                case "last":
                    b = new LastTransform(cond);
                break;
                case "replace":
                    b = new ReplaceTransform(cond, repl);
                break;
            }
        return b;
    }
}

class LengthQuery implements Query {
    int comp;
    LengthQuery(String comp) {
        this.comp = Integer.parseInt(comp);
    }
    public boolean matches(String s) {
        return this.comp == (s.length());
    }
}

class GreaterQuery implements Query {
    int comp;
    GreaterQuery(String comp) {
        this.comp = Integer.parseInt(comp);
    }
    public boolean matches(String s) {
        return (this.comp < s.length());
    }
}

class LessQuery implements Query {
    int comp;
    LessQuery(String comp) {
        this.comp = Integer.parseInt(comp);
    }
    public boolean matches(String s) {
        return (this.comp > s.length());
    }
}

class ContainsQuery implements Query {
    String comp;
    ContainsQuery(String comp) {
        this.comp = comp.substring(1,comp.length()-1);
    }
    public boolean matches(String s) {
        return s.contains(this.comp);
    }
}

class StartsQuery implements Query {
    String comp;
    StartsQuery(String comp) {
        this.comp = comp.substring(1,comp.length()-1);
    }
    public boolean matches(String s) {
        String first = s.substring(0, this.comp.length());
        return first.equals(this.comp);
    }
}

class EndsQuery implements Query {
    String comp;
    EndsQuery(String comp) {
        this.comp = comp.substring(1,comp.length()-1);
    }
    public boolean matches(String s) {
        String last = s.substring(s.length() - this.comp.length(), s.length());
        return last.equals(this.comp);
    }
}

class NotQuery implements Query {
    Query sub;
    NotQuery(Query sub) {
        this.sub = sub;
    }
    public boolean matches(String s) {
        return !sub.matches(s);
    }
}

class UpperTransform implements Transform {
    public String transform(String s) {
        return s.toUpperCase();
    }
}

class LowerTransform implements Transform {
    public String transform(String s) {
        return s.toLowerCase();
    }
}

class FirstTransform implements Transform {
    int comp;
    FirstTransform(String comp) {
        this.comp = Integer.parseInt(comp);
    }
    public String transform(String s) {
        if(this.comp > s.length()) { return s; }
        String val = s.substring(0, this.comp);
        return val;
    }
}

class LastTransform implements Transform {
    int comp;
    LastTransform(String comp) {
        this.comp = Integer.parseInt(comp);
    }
    public String transform(String s) {
        if(this.comp > s.length()) { return s; }
        String val = s.substring(s.length() - this.comp, s.length());
        return val;
    }
}

class ReplaceTransform implements Transform {
    String comp1;
    String comp2;
    ReplaceTransform(String comp1, String comp2) {
        this.comp1 = comp1.substring(1,comp1.length()-1);
        this.comp2 = comp2.substring(1,comp2.length()-1);
    }
    public String transform(String s) {
        String val = s.replace(this.comp1, this.comp2); 
        return val;
    }
}

interface Query {
    boolean matches(String s);
}

interface Transform {
    String transform(String s);
}

