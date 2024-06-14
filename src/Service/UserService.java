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

    public String convertWithIteration(Map<String, String> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
}
