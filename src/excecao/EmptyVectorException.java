package excecao;

import cores.Color;

public class EmptyVectorException extends Exception{

    public EmptyVectorException() {
        super(Color.RED_BACKGROUND+"ERROR Vector is empty!"+Color.RESET);
    }
}
