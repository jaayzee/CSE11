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

interface Query {
    boolean matches(String s);
}

