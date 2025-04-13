package excecao;

import cores.Color;

public class NoLevelException extends Exception{

    public NoLevelException() {
        super(Color.RED_BACKGROUND+"ERROR Teacher no have the minimum level for get this key!"+Color.RESET);
    }
}
