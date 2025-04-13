package excecao;

import cores.Color;

public class ReserveNotFoundException extends Exception{

    public ReserveNotFoundException() {
        super(Color.RED_BACKGROUND+"ERROR Reserve not found!"+Color.RESET);
    }
}
