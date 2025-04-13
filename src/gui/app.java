package gui;


import cores.Color;
import dados.Key;
import dados.Reserve;
import dados.Teacher;
import excecao.*;
import fachada.Sae;

import java.util.Scanner;

public class app {

    // presets
    static String tableFormatReserve = "%-8s %-15s %-10s %-8s %-10s %-8s%n";
    static String tableFormatTeacher = "%-10s %-15s %-12s %n";
    static String tableFormatKey = "%-10s %-15s %-12s %n";

    // color + background
    static String successOp = Color.GREEN_BACKGROUND + "Operação realizada com sucesso" + Color.RESET;
    static String invalidOp = Color.RED_BACKGROUND + "Invalid option!" + Color.RESET;
    static String canceledOp = Color.RED_BACKGROUND + "Operação cancelada!" + Color.RESET;

    public static String newId() { // function for create a new id unique
        String id = String.valueOf(System.currentTimeMillis());
        return id;
    }

    // max teachers, keys and reserves.
    private static final int MAX = 100;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op;
        String newValue, name, SIAPE, accessLevel, keyNum, keyRoom, id, goal, solHour, devHour;
        Reserve re;
        Teacher te;
        Key key;
        Sae sae = new Sae();

        do {
            System.out.print(Color.GREEN_BOLD);
            System.out.println("================================");
            System.out.println("0 - Exit");
            System.out.println("1 - Register (Teacher)");
            System.out.println("2 - Register (Key)");
            System.out.println("3 - Register (Reserve)");
            System.out.println("==============================");
            System.out.println("4 - Remove (Teacher)");
            System.out.println("5 - Remove (Key)");
            System.out.println("6 - Remove (Reserve)");
            System.out.println("==============================");
            System.out.println("7 - Change (Teacher)");
            System.out.println("8 - Change (Key)");
            System.out.println("9 - Change (Reserve)");
            System.out.println("==============================");
            System.out.println("10 - Consult (Teacher)");
            System.out.println("11 - Consult (Key)");
            System.out.println("12 - Consult (Reserve)");
            System.out.println("==============================");
            System.out.println("13 - List (Teacher)");
            System.out.println("14 - List (Key)");
            System.out.println("15 - List (Reserves)");
            System.out.print(Color.RESET);
            System.out.print(Color.BLUE_BOLD + "Enter your option: " + Color.RESET);
            op = input.nextInt();
            input.nextLine();

            switch (op) {
                case 0:
                    System.out.println(Color.WHITE_BOLD + "Saindo...");
                    break;
                case 1: // insert Teacher
                    System.out.println(Color.BLUE_BOLD + "REGISTRAR PROFESSOR");
                    try {
                        System.out.print("Digite o Nome do professor: ");
                        name = input.nextLine();
                        System.out.print("Digite o SIAPE: ");
                        SIAPE = input.nextLine();
                        System.out.print("Digite o Nivel de Acesso: ");
                        accessLevel = input.nextLine();
                        te = new Teacher(name, SIAPE, accessLevel);
                        sae.insertTeacher(te);
                        System.out.println(Color.WHITE_BOLD + successOp);
                    } catch (FullVectorException | SiapeIsInUseException | TeacherNotFoundException |
                             EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println(Color.BLUE_BOLD + "REGISTRAR CHAVE");
                    try {
                        System.out.print("Digite o número da chave: ");
                        keyNum = input.nextLine();
                        System.out.print("Informe a sala correspondente: ");
                        keyRoom = input.nextLine();
                        System.out.print("Informe o nível minímo de acesso: ");
                        accessLevel = input.nextLine();
                        key = new Key(keyNum, keyRoom, accessLevel);
                        sae.insertKey(key);
                        System.out.println(Color.WHITE_BOLD + successOp);
                    } catch (FullVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    System.out.println(Color.BLUE_BOLD + "REGISTRAR RESERVA");
                    try {
                        System.out.print("Informe o SIAPE do requisitante: ");
                        SIAPE = input.nextLine();
                        System.out.print("Informe o número da chave: ");
                        keyNum = input.nextLine();
                        System.out.print("Informe a atividade que será realizada: ");
                        goal = input.nextLine();
                        System.out.print("Informe a hora inicial de uso (ex: 12:00): ");
                        solHour = input.nextLine();
                        System.out.print("Informe a hora de entrega (ex: 14:30): ");
                        devHour = input.nextLine();
                        id = newId();
                        sae.insertReserve(SIAPE, keyNum, goal, solHour, devHour, id);
                        System.out.println(Color.WHITE_BOLD + successOp);
                        System.out.println(Color.GREEN_BOLD + "RESERVE ID: " + id);
                    } catch (TeacherNotFoundException | EmptyVectorException | FullVectorException |
                             KeyNotFoundException | NoLevelException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println(Color.BLUE_BOLD + "REMOVER PROFESSOR");
                    try {
                        System.out.print("Informe o SIAPE do professor: ");
                        SIAPE = input.nextLine();
                        te = sae.consultTeacher(SIAPE);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "         PROFESSOR CORRESPONDENTE         " + Color.RESET);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO");
                        System.out.printf("----------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatTeacher, te.getSiape(), te.getName(), te.getAccessLevel());
                        System.out.printf("----------------------------------------%n");
                        System.out.println();
                        System.out.println("| 1 - CONFIRMAR | 2 - CANCELAR | : ");
                        op = input.nextInt();
                        if (op == 1) {
                            sae.removeTeacher(SIAPE);
                            System.out.println(Color.WHITE_BOLD + successOp);
                        } else {
                            System.out.println(canceledOp);
                        }
                    } catch (TeacherNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    System.out.println(Color.BLUE_BOLD + "REMOVER CHAVE");
                    try {
                        System.out.print("Informe o número da chave");
                        keyNum = input.nextLine();
                        key = sae.consultKey(keyNum);

                        System.out.printf("----------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "          CHAVE CORRESPONDENTE          %n" + Color.RESET);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(tableFormatKey, "NUMERO", "SALA DE ACESSO", "NIVEL DE ACESSO");
                        System.out.printf("----------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatKey, key.getNumber(), key.getRoom(), key.getMinLevel());
                        System.out.printf("----------------------------------------%n");
                        System.out.println();
                        System.out.println("| 1 - CONFIRMAR | 2 - CANCELAR | : ");
                        op = input.nextInt();
                        if (op == 1) {
                            sae.removeKey(keyNum);
                            System.out.println(Color.WHITE_BOLD + successOp);
                        } else {
                            System.out.println(canceledOp);
                        }
                    } catch (KeyNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 6:
                    System.out.println(Color.BLUE_BOLD + "REMOVER RESERVA");
                    try {
                        System.out.print("Informe o ID da reserva");
                        id = input.nextLine();
                        re = sae.consultReserve(id);

                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "                     RESERVA CORRESPONDENTE                     %n" + Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(tableFormatReserve, "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatReserve,
                                re.getId(), re.getTeacher().getName(), re.getActivity(), re.getKey().getNumber(),
                                re.getSolicitation_hour(), re.getDevolution_hour() + Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.println();
                        System.out.println("| 1 - CONFIRMAR | 2 - CANCELAR | : ");
                        op = input.nextInt();
                        if (op == 1) {
                            sae.removeReserve(id);
                            System.out.println(Color.WHITE_BOLD + successOp);
                        } else {
                            System.out.println(canceledOp);
                        }

                    } catch (ReserveNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 7:
                    System.out.println(Color.BLUE_BOLD + "ALTERAR PROFESSOR");
                    try {
                        System.out.print("Informe o SIAPE do professor: ");
                        SIAPE = input.nextLine();
                        te = sae.consultTeacher(SIAPE);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "         PROFESSOR CORRESPONDENTE         " + Color.RESET);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO");
                        System.out.printf("----------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatTeacher,
                                te.getSiape(), te.getName(), te.getAccessLevel());
                        System.out.printf("----------------------------------------%n");


                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - NOME");
                        System.out.println("2 - SIAPE");
                        System.out.println("3 - NIVEL DE ACESSO");
                        op = input.nextInt();
                        input.nextLine();

                        switch (op) {
                            case 1: // name
                                System.out.print("Digite o nome: ");
                                newValue = input.nextLine();
                                sae.changeTeacher(SIAPE, op, newValue);
                                break;
                            case 2: // SIAPE
                                System.out.print("Digite o SIAPE: ");
                                newValue = input.nextLine();
                                sae.changeTeacher(SIAPE, op, newValue);
                                break;
                            case 3: // Access Level
                                System.out.print("Digite o nivel de acesso: ");
                                newValue = input.nextLine();
                                sae.changeTeacher(SIAPE, op, newValue);
                                break;
                            default:
                                System.out.println(Color.WHITE_BOLD + invalidOp);
                        }

                        System.out.println(Color.WHITE_BOLD + successOp);
                    } catch (TeacherNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 8:
                    System.out.println(Color.BLUE_BOLD + "ALTERAR CHAVE");
                    try {
                        System.out.print("Informe o número da chave:  ");
                        keyNum = input.nextLine();
                        key = sae.consultKey(keyNum);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "          CHAVE CORRESPONDENTE          %n" + Color.RESET);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(tableFormatKey, "NUMERO", "SALA DE ACESSO", "NIVEL DE ACESSO");
                        System.out.printf("----------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatKey,
                                key.getNumber(), key.getRoom(), key.getMinLevel());
                        System.out.printf("----------------------------------------%n");

                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - NÚMERO");
                        System.out.println("2 - SALA CORRESPONDENTE");
                        System.out.println("3 - NIVEL MÍNIMO DE ACESSO");
                        op = input.nextInt();
                        input.nextLine();

                        switch (op) {
                            case 1: // name
                                System.out.print("Digite o número: ");
                                newValue = input.nextLine();
                                sae.changeKey(keyNum, op, newValue);
                                break;
                            case 2: // SIAPE
                                System.out.print("Informe a sala correspondente: ");
                                newValue = input.nextLine();
                                sae.changeKey(keyNum, op, newValue);
                                break;
                            case 3: // Access Level
                                System.out.print("Digite o nivel mínimo de acesso: ");
                                newValue = input.nextLine();
                                sae.changeKey(keyNum, op, newValue);
                                break;
                            default:
                                System.out.println(Color.WHITE_BOLD + invalidOp);
                        }

                        System.out.println(Color.WHITE_BOLD + successOp);
                    } catch (KeyNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 9:
                    System.out.println(Color.BLUE_BOLD + "ALTERAR RESERVA");
                    try {
                        System.out.print("Informe o ID da reserva:  ");
                        id = input.nextLine();
                        Reserve reserve = sae.consultReserve(id); // validação

                        System.out.printf("-----------------------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "                          RESERVA ATUAL                          %n" + Color.RESET);
                        System.out.printf("-----------------------------------------------------------------%n");
                        System.out.printf(tableFormatReserve, "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("-----------------------------------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatReserve,
                                reserve.getId(), reserve.getTeacher().getName(), reserve.getActivity(),
                                reserve.getKey().getNumber(), reserve.getSolicitation_hour(), reserve.getDevolution_hour());
                        System.out.printf("-----------------------------------------------------------------%n");
                        System.out.println("Escolha uma opção: ");
                        System.out.println("1 - PROFESSOR");
                        System.out.println("2 - CHAVE");
                        System.out.println("3 - ATIVIDADE");
                        System.out.println("4 - HORA DE SOLICITAÇÃO");
                        System.out.println("5 - HORA DE DEVOLUÇÃO");
                        op = input.nextInt();
                        input.nextLine();

                        switch (op) {
                            case 1: //
                                System.out.print("Digite o SIAPE do professor: ");
                                newValue = input.nextLine();
                                sae.changeReserve(id, op, newValue);
                                break;
                            case 2: // SIAPE
                                System.out.print("Informe o número da chave: ");
                                newValue = input.nextLine();
                                sae.changeReserve(id, op, newValue);
                                break;
                            case 3: // Access Level
                                System.out.print("Digite a atividade que será realizada: ");
                                newValue = input.nextLine();
                                sae.changeReserve(id, op, newValue);
                                break;
                            case 4: // Access Level
                                System.out.print("Informe a hora inicial de uso (ex: 12:00): ");
                                newValue = input.nextLine();
                                sae.changeReserve(id, op, newValue);
                                break;
                            case 5: // Access Level
                                System.out.print("Informe a hora de devolução (ex: 14:30): ");
                                newValue = input.nextLine();
                                sae.changeReserve(id, op, newValue);
                                break;
                            default:
                                System.out.println(Color.WHITE_BOLD + invalidOp);
                        }

                        System.out.println(Color.WHITE_BOLD + successOp);
                    } catch (ReserveNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 10:
                    System.out.println(Color.BLUE_BOLD + "CONSULTAR PROFESSOR");
                    try {
                        System.out.println("Informe o SIAPE do professor: ");
                        SIAPE = input.nextLine();
                        te = sae.consultTeacher(SIAPE);

                        System.out.printf("----------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "         PROFESSOR CORRESPONDENTE         " + Color.RESET);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO");
                        System.out.printf("----------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatTeacher,
                                te.getSiape(), te.getName(), te.getAccessLevel());
                        System.out.printf("----------------------------------------%n");
                    } catch (TeacherNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 11:
                    System.out.println(Color.BLUE_BOLD + "CONSULTAR CHAVE");
                    try {
                        System.out.println("Informe o número da chave: ");
                        keyNum = input.nextLine();
                        key = sae.consultKey(keyNum);

                        System.out.printf("----------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "          CHAVE CORRESPONDENTE          %n" + Color.RESET);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(tableFormatKey, "NUMERO", "SALA DE ACESSO", "NIVEL DE ACESSO");
                        System.out.printf("----------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatKey,
                                key.getNumber(), key.getRoom(), key.getMinLevel());
                        System.out.printf("----------------------------------------%n");
                    } catch (KeyNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 12:
                    System.out.println(Color.BLUE_BOLD + "CONSULTAR RESERVA");
                    try {
                        System.out.println("Informe o ID da reserva: ");
                        id = input.nextLine();
                        re = sae.consultReserve(id);

                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "                     RESERVA CORRESPONDENTE                     %n" + Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(tableFormatReserve, "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.print(Color.CYAN);
                        System.out.printf(tableFormatReserve,
                                re.getId(), re.getTeacher().getName(), re.getActivity(), re.getKey().getNumber(),
                                re.getSolicitation_hour(), re.getDevolution_hour() + Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");

                        System.out.println(re);
                    } catch (ReserveNotFoundException | EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 13:
                    try {
                        Teacher[] teacherList = sae.listTeachers();
                        System.out.printf("---------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "                LISTAR PROFESSORES                %n" + Color.RESET);
                        System.out.printf("---------------------------------------------%n");
                        System.out.printf(tableFormatTeacher, "SIAPE", "PROFESSOR", "NVL. ACESSO");
                        System.out.printf("---------------------------------------------%n");
                        for (int i = 0; i < teacherList.length; i++) {
                            System.out.print(Color.CYAN);
                            System.out.printf(tableFormatTeacher,
                                    teacherList[i].getSiape(), teacherList[i].getName(), teacherList[i].getAccessLevel()
                                    /*metodos get*/);
                        }
                        System.out.printf("---------------------------------------------%n");
                    } catch (EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 14:
                    try {
                        Key[] keyList = sae.listKeys();

                        System.out.printf("----------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "             LISTAR CHAVES              %n" + Color.RESET);
                        System.out.printf("----------------------------------------%n");
                        System.out.printf(tableFormatKey, "NUMERO", "SALA DE ACESSO", "NIVEL DE ACESSO");
                        System.out.printf("----------------------------------------%n");
                        for (int i = 0; i < keyList.length; i++) {
                            System.out.print(Color.CYAN);
                            System.out.printf(tableFormatKey,
                                    keyList[i].getNumber(), keyList[i].getRoom(), keyList[i].getMinLevel());
                        }
                        System.out.printf("----------------------------------------%n");
                    } catch (EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 15:
                    try {
                        Reserve[] res = sae.listReserves();
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(Color.GREEN_BOLD +
                                "                         LISTAR RESERVAS                        %n" + Color.RESET);
                        System.out.printf("----------------------------------------------------------------%n");
                        System.out.printf(tableFormatReserve, "ID", "PROFESSOR", "ATIVIDADE", "CHAVE", "H. SOLIC", "H. DEVOL");
                        System.out.printf("----------------------------------------------------------------%n");
                        for (int i = 0; i < res.length; i++) {
                            System.out.print(Color.CYAN);
                            System.out.printf(tableFormatReserve,
                                    res[i].getId(), res[i].getTeacher().getName(), res[i].getActivity(),
                                    res[i].getKey().getNumber(), res[i].getSolicitation_hour(), res[i].getDevolution_hour()
                                            + Color.RESET);
                        }
                        System.out.printf("----------------------------------------------------------------%n");
                    } catch (EmptyVectorException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println(Color.WHITE_BOLD + invalidOp);
            }

        } while (op != 0);
    }
}
