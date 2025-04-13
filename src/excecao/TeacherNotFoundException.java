package excecao;

import cores.Color;

public class TeacherNotFoundException extends Exception {

    public TeacherNotFoundException() {
        super(Color.RED_BACKGROUND+"ERROR Teacher not found!"+Color.RESET);
    }
}
