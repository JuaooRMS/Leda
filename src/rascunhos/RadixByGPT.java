package rascunhos;

import java.util.*;

public class RadixByGPT {

    public static void main(String[] args) {

        int[] seq = {170, 45, 75, 90, 802, 24, 2, 66};

        radixSort(seq);

        System.out.println(Arrays.toString(seq));
    }

    public static int maior(int[] seq) {

        int maior = seq[0];

        for (int i = 1; i < seq.length; i++) {

            if (seq[i] > maior) {
                maior = seq[i];
            }
        }

        return maior;
    }

    public static void radixSort(int[] seq) {

        int maior = maior(seq);

        for (int pos = 1; maior / pos > 0; pos *= 10) {
            countingSort(seq, pos);
        }
    }

    public static void countingSort(int[] seq, int pos) {

        int[] resultado = new int[seq.length];
        int[] contagem = new int[10];

        // Conta os dígitos
        for (int i = 0; i < seq.length; i++) {

            int digito = (seq[i] / pos) % 10;

            contagem[digito]++;
        }

        // Acumula as contagens
        for (int i = 1; i < 10; i++) {

            contagem[i] += contagem[i - 1];
        }

        // Coloca os elementos no resultado
        for (int i = seq.length - 1; i >= 0; i--) {

            int digito = (seq[i] / pos) % 10;

            resultado[contagem[digito] - 1] = seq[i];

            contagem[digito]--;
        }

        // Copia para o array original
        for (int i = 0; i < seq.length; i++) {

            seq[i] = resultado[i];
        }
    }
}
