import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Binario bin = new Binario();
        Scanner scanner = new Scanner(System.in);
        int bits;
        String binario;

        System.out.println("Informe uma quantidade de bits para o binário: ");
        bits = scanner.nextInt();

        System.out.println("Informe um número binário: ");
        binario = "1010";
        bin.configuraBinario(binario, bits);
        System.out.println("//sout bin: "+bin);
        System.out.println("//sout bin.getValor(): "+bin.getValor());

    }
}
