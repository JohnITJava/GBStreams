package NIO;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

public class MainNio {
    public static void main(String[] args) throws IOException {
        //Описание пути к файлу
        File file = new File("1/a.txt");
        //Через НИО
        Path path = Paths.get("1/2/../a.txt");
        System.out.println(path);
        System.out.println("hey " + path.getFileName());
        System.out.println(path.normalize());
        System.out.println(path.getName(0));
        System.out.println(path.getName(1));
        System.out.println(path.getName(2));
        System.out.println(path.getName(3));
        System.out.println(path.getNameCount());
        System.out.println(path.getName(path.getNameCount()-1));

        //Files.createDirectory(path);
        //Files.copy(Paths.get("a.txt"), Paths.get("b.txt"), StandardCopyOption.REPLACE_EXISTING);
        //Files.move(Paths.get("a.txt"), Paths.get("b.txt"), StandardCopyOption.REPLACE_EXISTING);

        //Рекурсивное чтение дерева каталогов
        /*Files.walkFileTree(Paths.get("../src"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file.getFileName());
                if (file.getFileName().toString().equals("d.txt")){
                    System.out.println("Finded");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });*/

        //Рекурсивное удаление дерева каталога
        /*Files.walkFileTree(Paths.get("/"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });*/

        //Из каталога собрать список файлов
        List<Path> pathList = Files.list(Paths.get("/")).collect(Collectors.toList());

        //Построчное чтение всего файла
        List<String> data = Files.lines(Paths.get("hw1.txt"), StandardCharsets.UTF_8).collect(Collectors.toList());
        List<String> data1 = Files.readAllLines(Paths.get("hw1.txt"));

        //Чтение сразу всех байтов
        byte[] data2 = Files.readAllBytes(Paths.get("hw1.txt"));
        Files.write(Paths.get("z.txt"), data2, StandardOpenOption.CREATE);

    }
}
