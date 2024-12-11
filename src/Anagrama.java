import java.io.*;
import java.util.*;

public class Anagrama {
    public static void main(String[] args) throws IOException {
        String menos = anagramas(15);
        System.out.println(menos);
    }

    public static String anagramas(int minGroupSize) throws IOException {
        StringBuffer buff = new StringBuffer();
        Map<String, List<String>> lista = new HashMap<>();
        BufferedReader lector = null;
            try {
            lector = new BufferedReader(new FileReader("/home/alemunmar2/Escritorio/Arraylist/ArrayListt/src/ficheros/spanish-dict.txt"));
            String word;
            while ((word = lector.readLine()) != null) {
                String alpha = alphabetize(word);
                List<String> l = lista.get(alpha);
                if (l == null)
                    lista.put(alpha, l = new ArrayList<>());
                l.add(word);
            }
        }   catch (IOException fi) {
            System.err.println(fi);
            System.exit(1);
        } finally {
            lector.close();
        }

        for (List<String> l : lista.values())
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
