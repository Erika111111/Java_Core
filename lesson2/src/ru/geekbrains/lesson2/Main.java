package ru.geekbrains.lesson2;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final char DOT_HUMAN = 'X'; // фишка игрока
    private static final char DOT_AI = '0'; // фишка компьютера
    private static final char DOT_EMPTY = '*'; // пустая ячейка
    private static final Scanner scanner = new Scanner(System.in); //переменная типа сканер используется для хода игрока
    private static final Random random = new Random();
    private static char[][] field; // игровое поле
    private static int fieldSizeX; // размер игрового поля х
    private static int fieldSizeY; // размер игрового поля y
    private static final int WIN_COUNT = 4; // выиграшная комбинация

    public static void main(String[] args) {
        while (true){
            initialize(); // инициализировали игру
            printField(); // распечатали игровое поле
            while (true){ // внутренний игровой цикл
                humanTurn(); // ход игрока
                printField(); // печать поля
                if (checkState(DOT_HUMAN, "Ура! Вы победили!"))
                    break;
                aiTurn(); // ход компьютера
                printField(); // печать поля
                if (checkState(DOT_AI, "Победил компьютер"))
                    break;
            }
            System.out.print("Желаете продолжить? (Y - да, N - нет)");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeX][fieldSizeY]; // инициализация игрового поля


        /**
         * заполняем наш массив пустыми элемениами
         */
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * метод печати текущего состояния игрового поля
     */
    static void printField() { // метод хедер
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");


        // распечатывание ячеек
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * метод хода игрока (человека)
     */
    static void humanTurn(){
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y\n (от 1 до 3) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x,y) || !isCellEmpty(x,y));
        field[x][y] = DOT_HUMAN; // проставили крестик на наш ход
    }

    /**
     * метод хода игрока (компьютера)
     */
    static void aiTurn(){
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y\n (от 1 до 3) через пробел: ");
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x,y));
        field[x][y] = DOT_AI; // проставили нолик на ход компьютера

    }

    /**
     * проверка является ли яцейка игрового поля пустой
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;

    }

    /**
     * Проверка валидности координат хода
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x <= fieldSizeX && y >= 0 && y <= fieldSizeY;
    }

    /**
     * Проверка на ничью(все поля заполнены фишками человпка и компютера)
     * @return
     */
    static boolean cheekDraw(){
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x,y)) return false;
            }
        }
        return true;
}

    /**
     * метод проверки победы
     * @param dot фишка игрока
     * @return результат проверки победы
     */
/*static boolean checkWin(char dot){
    // проверка по трем гаризонталям
    if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
    if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
    if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;

    // проверка по трем вертикалям
    if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
    if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
    if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;

    // проверка по 2 диагоналям
    if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
    if (field[2][0] == dot && field[1][1] == dot && field[0][2] == dot) return true;

    return  false;
    }

 */

    /**
     * проверка на победу по горизонтали вправо
     * @param x координата
     * @param y координата
     * @param dot фишка игрока

     * @return результат проверки победы
     */
    static boolean check1(int x, int y, char dot) {
        for (x = 0; x < fieldSizeX; x++) {
            for (y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == dot && field[x][y + 1] == dot && field[x][y + 2] == dot && field[x][y + 3] == dot)
                    return true;
            }
        }
        return false;
     }
    /**
     * проверка на победу по вертикали вниз
     * @param x координата
     * @param y координата
     * @param dot фишка игрока

     * @return результат
     */
     static boolean check2(int x, int y, char dot){
            for (x = 0; x < fieldSizeX; x++) {
                for (y = 0; y < fieldSizeY; y++) {
                    if (field[x][y] == dot && field[x + 1][y] == dot && field[x + 2][y] == dot && field[x + 3][y] == dot)
                        return true;
                }
            }
         return false;
        }
    /**
     * проверка на победу по диагонали
     * @param x координата
     * @param y координата
     * @param dot фишка игрока

     */
        static boolean check3(int x, int y, char dot){
        for (x = 0; x < fieldSizeX; x++) {
            for (y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == dot && field[x + 1][y + 1] == dot && field[x + 2][y + 2] == dot && field[x + 3][y + 3] == dot)
                    return true;
            }
        }
        return false;
    }

    static boolean check4(int x, int y, char dot) {
        for (x = 0; x < fieldSizeX; x++) {
            for (y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == dot && field[x + 1][y - 1] == dot && field[x + 2][y - 2] == dot && field[x + 3][y - 3] == dot)
                    return true;
            }
        }
        return false;
    }
    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param s победный слоган
     * @return состояние игры
     */
   /* static boolean checkState(char dot, String s){
        if (checkWin(dot)){
            System.out.println(s);
            return true;
        }
        else if (cheekDraw()){
            System.out.println("Ничья");
            return true;
        }
        // игра продолжается
        return false;
    }
    */

    static boolean checkState(char dot, String s){
        if(check1(int x, int y, char dot){
            System.out.println(s);
            return true;
        }
        if (check2(int x, int y, char dot){
            System.out.println(s);
            return true;
        }
        if (check3(int x, int y, char dot){
            System.out.println(s);
            return true;
        }
        if (check4(int x, int y, char dot){
            System.out.println(s);
            return true;
        }
        return false;
        }

    }


