import java.util.Scanner;

public class Binario {
    private String valor;
    private int qtdBits;

    public Binario(String valor, int qtdBits) {
        Scanner in = new Scanner(System.in);

        this.qtdBits = qtdBits;

        while (verificaDigitos(valor)){
            System.out.print("Insira um valor BINARIO: ");
            valor = in.nextLine();
            in.nextLine();
        }

        verificaBits(valor);
    }

    private boolean verificaDigitos(String valorBinario){
        int diferentes = 0;
        for (int i = 0; i<= valorBinario.length(); i++){
            char valor = valorBinario.charAt(i);
            if ( valor != "1" || valor !="0"){
                diferentes++;
            }
        }
        if (diferentes>0){
            return true;
        }else{
            return false;
        }
    }
    //Método que verifica se a quantidade de bits no binário e igual a quantidade informada
    private void verificaBits(String valorBinario){
        //Se a quantidade for menor, concatena mais bits ao inicio do binario
        if (valorBinario.length()<this.qtdBits){
            int bits = this.qtdBits - valorBinario.length();
            String bitsSomados = "0";
            for(int i = 1; i <= bits; i++){
                bitsSomados.concat("0");
            }
            bitsSomados.concat(valorBinario);

            this.valor = bitsSomados;
        }
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getQtdBits() {
        return qtdBits;
    }

    public void setQtdBits(int qtdBits) {
        this.qtdBits = qtdBits;
    }
}
