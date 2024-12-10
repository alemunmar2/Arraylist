import java.io.*;
import java.util.*;

public class Anagrama {
    public static void main(String[] args) throws IOException {
        String menos = anagrams(15);
        System.out.println(menos);
    }

    public static String anagrams(int minGroupSize) throws IOException {
        StringBuffer buff = new StringBuffer();
        Map<String, List<String>> m = new HashMap<>();
        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader("/home/alemunmar2/Escritorio/Arraylist/ArrayListt/src/ficheros/spanish-dict.txt"));
            String word;
            while ((word = lector.readLine()) != null) {
                String alpha = alphabetize(word);
                List<String> l = m.get(alpha);
                if (l == null)
                    m.put(alpha, l = new ArrayList<>());
                l.add(word);
            }
        } catch (IOException fi) {
            System.err.println(fi);
            System.exit(1);
        } finally {
            lector.close();
        }

        for (List<String> l : m.values())
            if (l.size() >= minGroupSize)
                buff.append(l.size() + ": " + l + "\n");

        return buff.toString();
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
