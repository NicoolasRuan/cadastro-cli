package Objetos;

import java.io.*;
import java.util.*;

public class Cadastrar {

    private static final Scanner scanner = new Scanner(System.in);

    private static List<Usuario> banco = new ArrayList<Usuario>();

    public static void run() throws IOException {

        // lista de respostas do form
        Map<String, String> respostas = new HashMap<>();

        readForm("formulario.txt", respostas);

        banco.add(new Usuario(respostas.get("nome"), respostas.get("email"), respostas.get("idade"),respostas.get("altura")));

        System.out.println(banco.stream().count());

        System.out.println(log(respostas));

    }

    private static void readForm(String filePath, Map respostas) throws IOException {
        // leitura do arquivo txt do form
        InputStream is = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine(); //primeira linha

        while (s != null) {
            System.out.println(s);

            char q = s.charAt(0);

            switch (q) {
                case '1':
                    respostas.put("nome", scanner.nextLine());
                    break;
                case '2':
                    respostas.put("email", scanner.nextLine());
                    break;
                case '3':
                    respostas.put("idade", scanner.nextLine());
                    break;
                case '4':
                    respostas.put("altura", scanner.nextLine());
                    break;
            }
            s = br.readLine();
        }
        br.close();

    }

    private static String log(Map r) {
        return r.get("nome") + "\n" + r.get("email") + "\n" + r.get("idade") + "\n" + r.get("altura");
    }

    public static List<Usuario> getBanco() {
        return banco;
    }

    public static void save() {
    }
}
