package servicos;

import java.util.ArrayList;
import java.util.Collections;

public class ControlPacientes {
    private ArrayList<Paciente> pacientes;

    //metodos

    public boolean adicionarPaciente(String nome, double peso, String genero, int idade, double altura){
        if(this.pacientes.add(new Paciente(nome, peso, genero, idade, altura))){
            Collections.sort(this.pacientes);
            return true;
        }
        return false;
    }

    public String consultarPaciente(String nome)throws Exception{
        String retorno = null;
        for(Paciente paciente : pacientes){
            if(nome.equals(paciente.getNome())){
                retorno = "Codigo: "+ paciente.getCodigo() + "\n" + "Nome: " + paciente.getNome() + "\n" + "Peso: " + paciente.getPeso() + "\n" + "Genero: " + paciente.getGenero() + "\n" + "Idade: " + paciente.getIdade() + "\n" + "Altura: " + paciente.getAltura();
            }
        }
        if(retorno.equals(null)){
            throw new Exception();
        }
        return retorno;
    }

    public boolean alterarPaciente(String nome, double peso, String genero, int idade, double altura){
        for(int i=0; i<this.pacientes.size()-1; i++){
            if(nome.toLowerCase().equals(this.pacientes.get(i).getNome().toLowerCase())){
                this.pacientes.get(i).setNome(nome);
                this.pacientes.get(i).setPeso(peso);
                this.pacientes.get(i).setGenero(genero);
                this.pacientes.get(i).setIdade(idade);
                this.pacientes.get(i).setAltura(altura);
                Collections.sort(this.pacientes);
                return true;
            }
        }
        return false;
    }

    public boolean excluirPaciente(String nome){
        for(int i=0; i<this.pacientes.size()-1; i++){
            if(nome.toLowerCase().equals(this.pacientes.get(i).getNome().toLowerCase())){
                this.pacientes.remove(i);
                Collections.sort(this.pacientes);
                return true;
            }
        }
        return false;
    }

    public int quantPacientes (){
        int retorno = 0;
        retorno = this.pacientes.size();
        return retorno;
    }

    public double mediaIdadeHomens(){
        int controle = 0;
        double media = 0;
        for(Paciente paciente : this.pacientes){
            if(paciente.getGenero().equals("Masculino")){
                media += paciente.getIdade();
                controle += 1;
            }
        }
        return media/controle;
    }

    public int quantMulheresAlturaPeso(){
        int retorno = 0;
        for(Paciente paciente : this.pacientes){
            if(((paciente.getGenero().equals("Feminino")) && (paciente.getAltura()>=1.60) && (paciente.getAltura()<=1.70) && (paciente.getPeso()>=70))){
                retorno++;
            }
        }
        return retorno;
    }

    public int quantPessoas18a25(){
        int retorno = 0;
        for(Paciente paciente : this.pacientes){
            if((paciente.getIdade()>=18) && (paciente.getIdade()<=25)){
                retorno++;
            }
        }
        return retorno;
    }

    public String nomeMaisVelho(){
        Paciente retorno = this.pacientes.get(0);
        for(Paciente paciente : this.pacientes){
            if(paciente.getIdade()>retorno.getIdade()){
                retorno = paciente;
            }
        }
        return retorno.getNome();
    }

    public String nomeMulherBaixa(){
        Paciente retorno = this.pacientes.get(0);
        for(Paciente paciente : this.pacientes){
            if(paciente.getAltura()<retorno.getAltura()){
                retorno = paciente;
            }
        }
        return retorno.getNome();
    }

    public String ordenarPacientes(){
        String retorno = "";
        Collections.sort(this.pacientes);
        for(Paciente paciente : this.pacientes){
            retorno+=paciente.getNome() + "\n";
        }
        return retorno;
    }

    public ArrayList<Paciente> ordemIdade(){
        Collections.sort(this.pacientes);
        return this.pacientes;
    }


    //construtor
    public ControlPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ControlPacientes(){
        this.pacientes = new ArrayList<>();
    }

    //get and set
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
