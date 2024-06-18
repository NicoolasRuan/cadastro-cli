import Controller.UserController;
import Model.User;
import Objetos.Cadastrar;
import Objetos.Usuario;
import Service.UserService;
import View.UserView;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        //local db
        List<User> users = new ArrayList<>();

        UserView view = new UserView();
        UserService service = new UserService();
        UserController userController = new UserController(view, service, users);


        List<Usuario> banco = Cadastrar.getBanco();
        Scanner sc = new Scanner(System.in);

        String opção = "";
        while(!opção.equals("0")) {
            System.out.println("Bem vindo! Escolha uma das opções abaixo:");
            System.out.println("0 - sair | 1 - cadastrar | 2 - excluir | 3 - listar");
            opção = sc.nextLine();

            switch (opção){
                case "0":
//                    if(!userController.getUsers().isEmpty()) {
//                        System.out.println("deseja salvar usuarios? (S/N)");
//                        if(sc.nextLine().toUpperCase().equals("S")) {
//                            userController.saveUsers();
//                        }
//                    }
                    break;
                case "1":
                    //Map<String, String > questions = UserService.readQuestions("formulario.txt");
                    //System.out.println(questions);
                    userController.createUser();
                    //Cadastrar.run();
                    break;
                case "3":
                    userController.listUsers();


//                    if(!userController.getUsers().isEmpty()) {
//                        userController.listUsers();
//                    } else {
//                        System.out.println("Desculpe, mas não temos nenhum usuario cadastrado ainda :(");
//                    }
                    break;

            }
        }


        //Cadastrar.run();
    }
}