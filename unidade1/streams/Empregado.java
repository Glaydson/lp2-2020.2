package unidade1.streams;

public class Empregado {

    private String primeiroNome;
    private String ultimoNome;
    private double salario;
    private String departamento;

    public Empregado(String primeiroNome, String ultimoNome, double salario, String departamento) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNome() {
        return String.format("%s %s", getPrimeiroNome(), getUltimoNome());
    }

    String getUltimoNome() {
        return this.ultimoNome;
    }

    String getPrimeiroNome() {
        return this.primeiroNome;
    }

    String getDepartamento() {
        return this.departamento;
    }

    double getSalario() {
        return this.salario;
    }

    public String toString() {
        return String.format("%-10s %-10s %10.2f    %s", getPrimeiroNome(), getUltimoNome(), getSalario(),
                getDepartamento());
    }

}