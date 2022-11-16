package ru.batrakov;

public class Main {
    public static void main(String[] args) {
        //объявляем по каждому типу данных
        boolean varBoolean = true;
        byte varByte = 100;
        short varShort = 10000;
        int varInteger = 1000000;
        long varLong = 1000000000L;
        float varFloat = 1000.99f;
        double varDouble = 10000.99d;
        char varChar = '!';
        //операции с типами данных
        System.out.println(varByte+varShort);
        System.out.println(varInteger*varLong);
        System.out.println(varInteger%varFloat);
        System.out.println(varDouble/varByte);
        //переполнение
        System.out.println((byte)(varByte+127));
        System.out.println((short)(varShort+32768));
        System.out.println(varInteger+Integer.MAX_VALUE);
        //упражняемся с логическими опретаторами + условные конструкции
        int a = 21;
        if (a>20){
            System.out.println("a больше 20");
        }
        else if (a==20){
            System.out.println("a равно 20");
        }
        else {
            System.out.println("a меньше 20");
        }
    }
}