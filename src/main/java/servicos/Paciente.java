package servicos;

import java.util.ArrayList;
import java.util.Collections;

public class Paciente implements Comparable<Paciente> {
    private static int codControl;
    private int codigo;
    private String nome;
    private double peso;
    private String genero;
    private int idade;
    private double altura;

    //metodos
    @Override
    public int compareTo(Paciente o) {
        if (this.idade < o.getIdade()) {
            return -1;
        } if (this.idade > o.getIdade()) {
            return 1;
        }
        return 0;
    }

    //construtor

    public Paciente(String nome, double peso, String genero, int idade, double altura) {
        super();
        codControl++;
        this.codigo = codControl;
        this.nome = nome;
        this.peso = peso;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
    }

    public Paciente(int codigo, String nome, double peso, String genero, int idade, double altura) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.peso = peso;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
        codControl++;
    }
    //get and set

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}