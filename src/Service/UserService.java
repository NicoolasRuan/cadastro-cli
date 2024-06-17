package Service;

import Model.User;

import java.io.*;
import java.util.*;

public class UserService {
    public Map<String, String> readQuestions(String filePath) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> questions = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                char q = line.charAt(0);

                switch (q) {
                    case '1':
                        questions.put("name", scanner.nextLine());
                        break;
                    case '2':
                        questions.put("email", scanner.nextLine());
                        break;
                    case '3':
                        questions.put("age", scanner.nextLine());
                        break;
                    case '4':
                        questions.put("height", scanner.nextLine());
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public void saveOnDb(String path, List<User> users) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.close();

    }

    public void saveOnDb(String path, User user) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();

    }

    public List<User> readFromDb(String path) {
        List<User> users = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Lendo o objeto (que é uma lista de usuários)
            System.out.println(ois.readByte());
            if(ois.available()>0) {
                users = (List<User>) ois.readObject();
            }

            // Fechando o stream
            ois.close();
        } catch (EOFException e) {
            System.out.println("nenhum usuario cadastrado no banco.");
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred: IO exception.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("An error occurred: Class not found.");
            e.printStackTrace();
        }

        return users;


    }

    public String convertWithIteration(Map<String, String> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
}
