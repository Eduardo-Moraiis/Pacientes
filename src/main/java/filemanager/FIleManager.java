package filemanager;

import servicos.Paciente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class FIleManager {

    public static ArrayList<Paciente> lerBanco(String arquivo){
    ArrayList<Paciente> retorno = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(Paths.get(arquivo));
            while (scanner.hasNext()){
                String[] linha = scanner.nextLine().split(";");
                retorno.add(new Paciente(Integer.parseInt(linha[0]),linha[1], Double.parseDouble(linha[2]), linha[3], Integer.parseInt(linha[4]), Double.parseDouble(linha[5])));
            }
            scanner.close();
            return retorno;
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("Arquivo nao aberto!");
            System.exit(1);
        }
    return null;
    }
    public static void gravarBanco(String arquivo, ArrayList<Paciente> pacientes){
        try{
            Formatter formatter = new Formatter(arquivo);
            for(Paciente paciente : pacientes){
                formatter.format("%s;%s;%s;%s;%s;%s\n", paciente.getCodigo(), paciente.getNome(), paciente.getPeso(), paciente.getGenero(), paciente.getIdade(), paciente.getAltura());
            }
            formatter.close();
        }catch (FileNotFoundException | FormatterClosedException e){
            System.err.println("Não foi possível gravar os pacientes");
            System.exit(1);
        }
    }
}
