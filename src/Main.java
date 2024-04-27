import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartão:");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String compra = leitura.next();

            System.out.println("Digite o valor da compra:");
            double valorCompra = leitura.nextDouble();

            Compras compra1 = new Compras(compra, valorCompra);
            boolean compraRealizada = cartao.lancaCompra(compra1);

            if (compraRealizada) {
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = leitura.nextInt();
            } else {
                System.out.println("Limite indisponível!");
                sair = 0;
            }

        }

        System.out.println("****************************");
        System.out.println("COMPRAS REALIZADAS: \n");

        Collections.sort(cartao.getCompras());
        for (Compras c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }

        System.out.println("\n *************************");
        System.out.println("Saldo do cartão: " + cartao.getSaldo());

    }

}