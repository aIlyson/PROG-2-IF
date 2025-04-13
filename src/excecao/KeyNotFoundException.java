package excecao;

import cores.Color;

public class KeyNotFoundException extends Exception {

    public KeyNotFoundException() {
        super(Color.RED_BACKGROUND+"ERROR Teacher not found!"+Color.RESET);
    }
}

