//Необходимо написать проект, для розыгрыша в магазине игрушек. 
//Функционал должен содержать добавление новых игрушек и задания веса для выпадения игрушек.
// Напишите класс-конструктор у которого принимает минимум 3 строки, содержащие три поля id игрушки, текстовое название и частоту выпадения игрушки
// Из принятой строки id и частоты выпадения(веса) заполнить минимум три массива.
// Используя API коллекцию: java.util.PriorityQueue добавить элементы в коллекцию
// Организовать общую очередь
// Вызвать Get 10 раз и записать результат в файл

 package Raffle6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {
        public static final String TEXT_RED = "\u001B[31m";
        public static final String TEXT_BLACK = "\u001B[30m";
        public static final String TEXT_GREEN = "\u001B[32m";
        public static final String TEXT_BLUE = "\u001B[34m";
        public static final String TEXT_RESET = "\u001B[0m";
        public static final String TEXT_PURPLE = "\u001B[35m";
        public static final String TEXT_CYAN = "\u001B[36m";
        public static final String TEXT_YELLOW = "\u001B[33m";
        public static final String TEXT_WHITE = "\u001B[37m";

        public static void main(String[] args) {
                String[] toyName = new String[] { "bear", "yula", "ball", "car", "doll", "boardGame", "gun", "bike",
                                "monopoly", "bunny"};
                int arraysize = 10;
                ArrayList<Toy> toys = new ArrayList<Toy>();
                int[] toyWeight = new int[] { 2, 2, 1, 3, 1, 1, 2, 8, 1, 1};
                int[] toyId = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                int basketWeight = 0;
                int idlast=arraysize;
                Random rnd = new Random();
                int addToy;
                String toysStrPrize;
                String toysStrAdd;
//                Basket basket = new Basket(basketWeight);
                PriorityQueue<Toy> queueToys = new PriorityQueue<>();

                //формируем начальный массив и очередь
                for (int i = 0; i <= arraysize - 1; i++) {
                        toys.add(new Toy(toyId[i], toyName[i], toyWeight[i]));
                        queueToys.add(new Toy(toyId[i], toyName[i], toyWeight[i]));
                        basketWeight = basketWeight + toyWeight[i];
                }
                System.out.println(queueToys);
                Toy currentToy = null;

                //запускаем розыгрыш 10 призов
                for (int i=0; i<10; i++){
                        int numberRaf=i+1;
                        System.out.printf(TEXT_BLUE+ "Розыгрыш № " + numberRaf);
                        System.out.println(" В корзине " + basketWeight +"кг"+ TEXT_RESET);
                        System.out.println(queueToys);
                // выдаем приз из заголовка очереди
                        currentToy=queueToys.peek();
                        System.out.printf(TEXT_GREEN + "Приз : ");
                        System.out.printf("id: " + currentToy.getId());
                        System.out.printf(" - Toy: " + currentToy.getName() );
                        System.out.println(" - Weight: " + currentToy.getWeidht() +TEXT_RESET);
                        basketWeight=basketWeight-currentToy.getWeidht();
                        toysStrPrize=queueToys.peek().toString();
                        queueToys.poll();
                //добавляем игрушку в очередь
                        idlast=idlast+1;
                        addToy=rnd.nextInt(10);
                        queueToys.add(new Toy(idlast, toyName[addToy], toyWeight[addToy]));
                        System.out.printf(TEXT_YELLOW + "Добавляем игрушку в корзину : " );
                        System.out.printf(toys.get(addToy)+" New id : "+ idlast + TEXT_RESET);
//                        System.out.printf(" New id : "+ idlast + TEXT_RESET);
                        System.out.println();
                        toysStrAdd=toys.get(addToy).toString();
                        basketWeight=basketWeight+toyWeight[addToy];
                // запись в файл
                        try(FileWriter writer = new FileWriter("Raffle6\\result.txt", true))
                    {
                       // запись всей строки
                        writer.write("Приз выдан ");
                        writer.write(toysStrPrize);
                        writer.append('\n');
                        writer.write("В корзину добавлена игрушка "); 
                        writer.write(toysStrAdd);
                        writer.append('\n');
                        writer.flush();
                    }
                    catch(IOException ex){
                        System.out.println("Ошибка записи");
                    }
                }                        
        }
}
