package Controlador;

public class GeneradorSopaLetras {

    private String[][] M;
    private int[][] H;

    public GeneradorSopaLetras() {
        M = new String[20][20];
        H = new int[20][20];
    }

    public int azar(int limite) {
        return (int) Math.floor(Math.random() * limite);
    }

    public void inicializaMatrices() {
        String cadena = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String[] letra = cadena.split("");

        for (int f = 0; f < M.length; f++) {
            for (int c = 0; c < M[0].length; c++) {
                M[f][c] = letra[azar(letra.length)];
                H[f][c] = 0;
            }
        }
    }

    public boolean colocarPalabra0(String[] word) {
        int f = azar(M.length);
        int L = word.length;
        int c = azar(M[0].length - L + 1);

        boolean permitido = true;

        for (int t = 0; t < L; t++) {
            if ((H[f][c + t] == 1) && (!M[f][c + t].equals(word[t]))) {
                permitido = false;
            }
        }

        if (permitido) {
            for (int t = 0; t < L; t++) {
                M[f][c + t] = word[t];
                H[f][c + t] = 1;
            }
        }

        return permitido;
    }

    public boolean colocarPalabra2(String[] word) {
        int L = word.length;
        int f = azar(M.length - L + 1);
        int c = azar(M[0].length);

        boolean permitido = true;

        for (int t = 0; t < L; t++) {
            if ((H[f + t][c] == 1) && (!M[f + t][c].equals(word[t]))) {
                permitido = false;
            }
        }

        if (permitido) {
            for (int t = 0; t < L; t++) {
                M[f + t][c] = word[t];
                H[f + t][c] = 1;
            }
        }

        return permitido;
    }

    public void colocarTodas(String palabras) {
        String[] palabra = palabras.split(",");

        int cuenta = 0;

        while (cuenta < palabra.length) {
            String[] word = palabra[cuenta].trim().toUpperCase().split("");

            boolean colocado = false;

            while (!colocado) {
                int orientacion = azar(2);

                switch (orientacion) {
                    case 0:
                        colocado = colocarPalabra0(word);
                        break;
                    case 1:
                        colocado = colocarPalabra2(word);
                        break;
                }
            }

            cuenta++;
        }
    }

    public String obtenerSopaComoTexto() {
        String texto = "";

        for (int f = 0; f < M.length; f++) {
            for (int c = 0; c < M[0].length; c++) {
                texto += M[f][c] + " ";
            }
            texto += "\n";
        }

        return texto;
    }

    public String generarSopa(String palabras) {
        inicializaMatrices();
        colocarTodas(palabras);
        return obtenerSopaComoTexto();
    }
}
