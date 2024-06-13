package Objetos;

public class Usuario {
    private String nome;
    private String email;
    private Integer idade;
    private Double altura;

    @Override
    public String toString() {
        return nome  + "\n" + email + "\n" + idade + "\n" + altura;
    }

    public Usuario(String nome, String email, String idade, String altura) {
        this.nome = nome;
        this.email = email;
        this.idade = Integer.valueOf(idade);
        this.altura = Double.valueOf(altura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }
}
