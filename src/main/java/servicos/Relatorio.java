package servicos;

import java.util.ArrayList;

public class Relatorio {

    private static String relatorio;
    public static void gerarRelatorio(ControlPacientes pacientes){
        String retorno = "";
        retorno = "Quantidade de Pacientes: " + pacientes.quantPacientes() + "\n" +
                "Media idade genero masculino: " + pacientes.mediaIdadeHomens() + "\n" +
                "Genero feminino grupo 1: " + pacientes.quantMulheresAlturaPeso() + "\n" +
                "Pacientes grupo 2: " + pacientes.quantPessoas18a25() + "\n" +
                "Mais idoso: " + pacientes.nomeMaisVelho() + "\n" +
                "Genero feminino estatura baixa: " + pacientes.nomeMulherBaixa() + "\n" + "\n"+
                "Pacientes:" + "\n" + pacientes.ordenarPacientes();
        relatorio = retorno;
    }

    public static String retornaRelatorio(){
        return relatorio;
    }
}
