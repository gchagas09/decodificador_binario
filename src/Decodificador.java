public class Decodificador {
    String binarioInvertido;
    

    private String inverteBinario(String valorBinario){
        StringBuilder inverso = new StringBuilder(valorBinario).reverse();
        return inverso.toString();
    }

    public void configuraDecodificador(String valorBinario){
        System.out.println("//Valor binario: "+ valorBinario);
        if (!Binario.verificaDigitos(valorBinario)){
            this.binarioInvertido = inverteBinario(valorBinario);
        }else{
            this.binarioInvertido = null;
        }
    }

    public int binarioSemSinal(){
        int valor = 0;
        for (int i=0; i < this.binarioInvertido.length(); i++){
            if (this.binarioInvertido.charAt(i) == '1'){
                valor = valor + (int)Math.pow(2, i);
            }
        }
        return valor;
    }

    public int binarioSemSinalParse(String valorBinario){
        return Integer.parseInt(valorBinario, 2);
    }

    public int complementoDois(){
        int valor = 0;
        for (int i=0; i < (this.binarioInvertido.length() - 1 ); i++){
            if (this.binarioInvertido.charAt(i) == '1'){
                valor = valor + (int)Math.pow(2, i);
            }
        }
        if (this.binarioInvertido.charAt(this.binarioInvertido.length()-1) == '1'){
            valor = valor - (int)Math.pow(2, this.binarioInvertido.length()-1);
        }
        return valor;
    }

    public String retornaAscii(){
        if (binarioSemSinal()==0){
            return caractereNaoImprimivel();
        }else if(binarioSemSinal()>=7 && binarioSemSinal()<=15){
            return caractereNaoImprimivel();
        }else if(binarioSemSinal() == 27){
            return caractereNaoImprimivel();
        }else if (binarioSemSinal()>=127 && binarioSemSinal()<=160){
            return caractereNaoImprimivel();
        }
        else{
            return String.valueOf((char) binarioSemSinal());
        }
    }
    
    public char testeRetornaAscii(int valor){
        return (char)valor;
    }

    public String getBinarioInvertido(){
        return this.binarioInvertido;
    }

    private String caractereNaoImprimivel(){
        return "CARACTERE NÃO IMPRIMIVEL";
    }
    //public int binarioSemSinal(String valorBinario){
    //    String valorInvertido = ;
    
}
