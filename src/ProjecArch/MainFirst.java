package ProjecArch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainFirst {

    static class Cat implements Serializable{
        private String name;
        private int age;

        public Cat(String name, int age) {
            System.out.println("Cat constructor call");
            this.name = name;
            this.age = age;
        }

        public void info(){
            System.out.println(name + " " + age);
        }
    }

    public static void main(String[] args) throws Exception {

        //Java IO
        File f = new File("cat.ser"); //Указываем путь к файлу
        byte[] arr = new byte[(int)f.length()]; // Создаем байтовый массив
        String fn = f.getName(); //Запоминаем имя файла
        FileInputStream in = new FileInputStream(f); //Открываем поток
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) in.read();
        }
        in.close();

        //Java NIO
        byte[] myData = Files.readAllBytes(Paths.get("1.txt"));

        //Сериализация
        Cat cat = new Cat("Barsik", 1);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cat.ser"));
        oos.writeObject(cat);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cat.ser"));
        Cat cat2 = (Cat) ois.readObject();
        cat.info();
        cat2.info();

    }
}
