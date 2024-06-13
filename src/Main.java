import Objetos.Cadastrar;
import Objetos.Usuario;

import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        List<Usuario> banco = Cadastrar.getBanco();
        Scanner sc = new Scanner(System.in);

        String opção = "";
        while(!opção.equals("0")) {
            System.out.println("Bem vindo! Escolha uma das opções abaixo:");
            System.out.println("0 - sair | 1 - cadastrar | 2 - excluir | 3 - atualizar | 4 - listar");
            opção = sc.nextLine();

            switch (opção){
                case "0":
                    System.out.println("até a próxima :)");
                    break;
                case "1":
                    Cadastrar.run();
                    break;
                case "4":
                    banco = Cadastrar.getBanco();
                    if(!banco.isEmpty()) {
                        for (Usuario usuario : banco) {
                            System.out.println(usuario);
                        }
                    } else {
                        System.out.println("Desculpe, mas não temos nenhum usuario cadastrado ainda :(");
                    }
                    break;

            }
        }


        //Cadastrar.run();
    }
}