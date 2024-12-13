import java.util.Scanner;
public class AcampamentodeFérias {
    static class Crianca {
        String nome;
        int valor;
        Crianca anterior;
        Crianca proxima;
    }

    static class ListaDuplamenteEncadeada {
        Crianca primeira;
        Crianca ultima;
        int tamanho;

        void adicionar(Crianca crianca) {
            if (primeira == null) {
                primeira = ultima = crianca;
                crianca.proxima = crianca.anterior = crianca;
            } else {
                ultima.proxima = crianca;
                crianca.anterior = ultima;
                crianca.proxima = primeira;
                primeira.anterior = crianca;
                ultima = crianca;
            }
            tamanho++;
        }

        void remover(Crianca crianca) {
            if (tamanho == 1) {
                primeira = ultima = null;
            } else {
                crianca.anterior.proxima = crianca.proxima;
                crianca.proxima.anterior = crianca.anterior;
                if (crianca == primeira) {
                    primeira = crianca.proxima;
                }
                if (crianca == ultima) {
                    ultima = crianca.anterior;
                }
            }
            tamanho--;
        }

        Crianca obter(int indice) {
            Crianca atual = primeira;
            for (int i = 0; i < indice; i++) {
                atual = atual.proxima;
            }
            return atual;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int quantidadeCriancas, criancasRemovidas, valorAtual, proximoValor;

        while ((quantidadeCriancas = entrada.nextInt()) != 0) {
            ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
            for (int i = 0; i < quantidadeCriancas; i++) {
                Crianca crianca = new Crianca();
                crianca.nome = entrada.next();
                crianca.valor = entrada.nextInt();
                lista.adicionar(crianca);
            }

            criancasRemovidas = 0;
            valorAtual = lista.obter(0).valor;
            int restantes = quantidadeCriancas - 1;
            Crianca criancaAtual = lista.primeira;

            while (criancasRemovidas != restantes && quantidadeCriancas >= 2) {
                if (valorAtual % 2 != 0) {
                    for (int k = 0; k < valorAtual; k++) {
                        criancaAtual = criancaAtual.proxima;
                    }
                } else {
                    for (int k = 0; k < valorAtual; k++) {
                        criancaAtual = criancaAtual.anterior;
                    }
                }
                proximoValor = criancaAtual.valor;
                lista.remover(criancaAtual);
                criancasRemovidas++;
                quantidadeCriancas--;
                valorAtual = proximoValor;
            }
            System.out.println("Vencedor(a): " + lista.primeira.nome);
        }
        entrada.close();
    } 
}
