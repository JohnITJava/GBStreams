package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStream {
    static class Person {
        private int age;
        private String name;
        private String position;
        private int id;

        public Person(int id, int age, String name, String position) {
            this.age = age;
            this.name = name;
            this.position = position;
            this.id = id;
        }

        public void info() {
            System.out.println(id + " " + name + " " + age + " " + position);
        }
    }

    public static void main(String[] args) {
        //firstExample();
        //filterExam();
        
        String[] str = {"Aaa", "Bb", "Cccc"};
        Arrays.stream(str).map(s -> s.length()).forEach(i -> System.out.println(i));
        Arrays.stream(str).map(String::length).forEach(System.out::println);
        System.out.println("--------------");

        Arrays.stream(new int[] {1, 2, 3, 4}).map(n -> n * 2).forEach(n -> System.out.print(n));
        System.out.println();
        Arrays.stream(new int[] {1, 2, 3, 4}).map(n -> n * 2).limit(2).forEach(n -> System.out.print(n));

        System.out.println("--------------");

        List<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 4, 1, 2, 23, 1, 5, 6, 5, 3, 3));
        data.stream().distinct().forEach(System.out::println);
        data.stream().distinct().skip(2).limit(3).forEach(System.out::println);
        Optional<Integer> optI = data.stream().filter(n -> n % 2 != 0).findAny();
        if (optI.isPresent()){
            System.out.println(optI.get());
        }

        System.out.println("--------------");

        List<Integer> data1 = new ArrayList<>(Arrays.asList(1, 2, 4, 1, 2, 23, 1, 5, 6, 5, 3, 3));
        data1.stream().reduce(0, (a, b) -> a + b);

        System.out.println("--------------");
        System.out.println(data.stream().mapToInt(n -> n).sum());

        IntStream.rangeClosed(50, 100).filter(n -> n %2 == 0).sum();
        IntStream s1 = Arrays.stream(new int[] {1, 2, 3});
        Stream<String> s2 = new ArrayList<String>(Arrays.asList("A", "B")).stream();
        Stream<String> s3 = Stream.of("A", "B", "C");


    }

    private static void filterExam() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> onlyEvents = integers.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());

        List<Integer> onlyLess5 = integers.stream().filter(integer -> integer < 5).collect(Collectors.toList());

        System.out.println(integers);
        System.out.println(onlyEvents);
        System.out.println(onlyLess5);
    }

    private static void firstExample() {
        List<Person> list = new ArrayList<>(Arrays.asList(
           new Person(1, 32, "Bob1", "Manager"),
           new Person(2, 44, "Bob2", "Engineer"),
           new Person(3, 25, "Bob3", "Manager"),
           new Person(4, 54, "Bob4", "Director"),
           new Person(5, 47, "Bob5", "Engineer"),
           new Person(6, 11, "Bob6", "Engineer")
        ));

        List<Person> engineers = new ArrayList<>();

        for (Person o: list) {
            if (o.position.equals("Engineer")){
                engineers.add(o);
            }
        }
        engineers.sort((o1, o2) -> o1.age - o2.age);
        List <Integer> engineersIdSortedByAge = new ArrayList<>();
        for (Person o : engineers) {
            engineersIdSortedByAge.add(o.id);
        }
        System.out.println(engineersIdSortedByAge);

        System.out.println("----------------------------");

        System.out.println(list.stream()
                .filter(person -> person.position.equals("Engineer"))
                .sorted((o1, o2) -> o1.age - o2.age)
                .map(person -> person.id)
                .collect(Collectors.toList()));

        //Stream API
    }
}
