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
            String[] ar = args[1].split("=");
            ContainsQuery a = new ContainsQuery(ar[1].substring(1,ar[1].length()-1));
            for (String i: lines) {
                if (a.matches(i))
                System.out.println(i);
            }
            
        }
        
    }
}

class ContainsQuery {
    String comp;
    ContainsQuery(String comp) {
        this.comp = comp;
    }
    boolean matches(String s) {
        return s.contains(this.comp);
    }
}