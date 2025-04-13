package excecao;

import cores.Color;

public class FullVectorException extends Exception {

    public FullVectorException() {
        super(Color.RED_BACKGROUND+"ERROR Full vector!"+Color.RESET);
    }
}
