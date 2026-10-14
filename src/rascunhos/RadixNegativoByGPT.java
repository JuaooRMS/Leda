package rascunhos;

public class RadixNegativoByGPT {
	public void radixSort(int[] seq) {

	    int negativos = 0;

	    // Conta quantos números negativos existem
	    for (int i = 0; i < seq.length; i++) {
	        if (seq[i] < 0) {
	            negativos++;
	        }
	    }

	    int[] neg = new int[negativos];
	    int[] pos = new int[seq.length - negativos];

	    int n = 0;
	    int p = 0;

	    // Separa negativos e positivos
	    for (int i = 0; i < seq.length; i++) {

	        if (seq[i] < 0) {
	            neg[n] = -seq[i];
	            n++;
	        } else {
	            pos[p] = seq[i];
	            p++;
	        }
	    }

	    // Ordena negativos e positivos
	    if (neg.length > 0) {
	        radixSortPositivo(neg);
	    }

	    if (pos.length > 0) {
	        radixSortPositivo(pos);
	    }

	    // Coloca os negativos de trás para frente
	    int k = 0;

	    for (int i = neg.length - 1; i >= 0; i--) {
	        seq[k] = -neg[i];
	        k++;
	    }

	    // Coloca os positivos
	    for (int i = 0; i < pos.length; i++) {
	        seq[k] = pos[i];
	        k++;
	    }
	}
	private void radixSortPositivo(int[] seq) {

	    int maxNum = getMax(seq);
	    int qtyDigits = ("" + maxNum).length();

	    for (int nthDigit = 1; nthDigit <= qtyDigits; nthDigit++) {
	        sort(seq, nthDigit);
	    }
	}
}
