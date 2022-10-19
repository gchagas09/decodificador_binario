import java.util.Scanner;

public class Binario {
    private String valor;
    private int qtdBits;

    public String toString(){
        return this.valor;
    }

    public void configuraBinario(String valor, int qtdBits) {
        Scanner in = new Scanner(System.in);

        this.qtdBits = qtdBits;

        while (this.verificaDigitos(valor)){
            System.out.print("Insira um valor BINARIO: ");
            valor = in.nextLine();
        }
        verificaBits(valor);
    }

    public static boolean verificaDigitos(String valorBinario){
        int diferentes = 0;
        int valor;
        for (int i = 0; i< valorBinario.length(); i++){
            
            valor = valorBinario.charAt(i) - '0';
            if ( valor<0 || valor>1){
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
        if (valorBinario.length() < this.qtdBits){
            valorBinario = somaBinario(valorBinario);
        }else if(valorBinario.length()>this.qtdBits){
            valorBinario = null;
        }

        this.valor = valorBinario;
    }
    private String somaBinario(String valorBinario){
        int bits = this.qtdBits - valorBinario.length();
            String bitsSomados = "0";

            for(int i = 1; i < bits; i++){
                bitsSomados = bitsSomados+"0";
            }
            valorBinario = bitsSomados+valorBinario;
            return valorBinario;
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
