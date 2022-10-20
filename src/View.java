import java.util.Scanner;

public class View {
    Scanner in = new Scanner(System.in);
    String nomeUsuario;
    Binario binario = new Binario();
    Decodificador decodificador = new Decodificador();

    private int imprimeOpcoes(){
        int opt=0;
        do{
            try {
                System.out.println("\n1. Digite 0 para sair\n2. Digite qualquer outro número para continuar convertendo");
                System.out.print("\nDigite um número: ");
                opt = in.nextInt();
                in.nextLine();
            } catch (Exception e) {
                System.out.println("\n<INFORME UM VALOR INTEIRO MAIOR QUE ZERO>");
                opt = -1;
                in.nextLine();
            }
        }while(opt<0);
        return opt;
    }
    
    private void menu(){
        System.out.println("Olá, como é seu nome?");
        nomeUsuario = this.in.nextLine();
        System.out.printf("\nBem vindo %s,  ao DECODIFICADOR DE BINÁRIO", nomeUsuario);
        
    }

    private void imprimeNumeros(){
        System.out.printf("\nO valor binário %s, convertido para número decimal, equivale aos seguintes valores: ", binario.getValor());
        System.out.printf("\nBINÁRIO INTEIRO SEM SINAL: %d", decodificador.binarioSemSinal());
        System.out.printf("\nCOMPLEMENTO DE 2: %d", decodificador.complementoDois());
        if (binario.getQtdBits()<=8){
            System.out.printf("\nCARACTERE REPRESENTADO PELO BINÁRIO: %s", decodificador.retornaAscii());
        }else{
            System.out.println("\nESTE BINÁRIO NÃO TEM NENHUM CARACTERE ASSOCIADO");
        }
        
    }

    private void naoImprimeNumeros(){
        System.out.println("<OVERFLOW - O VALOR INFORMADO TEM MAIS BITS DO QUE O SUPORTADO>");
    }

    private void informaBinario(){
        int bits =0;
        String bin;
       
        do{
            try {
                System.out.print("\nInforme uma quantidade de bits para o binário: ");
                bits = in.nextInt();
                in.nextLine();
            } catch (Exception e) {
                System.out.println("\n<INFORME UM VALOR INTEIRO MAIOR QUE ZERO>");
                in.nextLine();
            }
        }while(bits<=0);
        
        System.out.print("\nInforme um número binário: ");
        bin = in.nextLine();

        this.binario.configuraBinario(bin, bits);
        if(binario.getValor()!=null){
            this.decodificador.configuraDecodificador(binario.getValor());
        }        
    }

    public void tela(){
        int opt =0;
        menu();
        do{
            informaBinario();
            if(binario.getValor()==null){
                naoImprimeNumeros();
            }else{
                imprimeNumeros();
            }
            opt = imprimeOpcoes();
            
        }while(opt>0);
    }

}
