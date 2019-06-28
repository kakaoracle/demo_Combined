package jdk8.函数式接口;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SAMtest {
    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println("Hello" + message);
    }

    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    @Test
    public void test01() {
        if (menu.stream().anyMatch(dish -> dish.isVegetarian())) {
            System.out.println("The menu is someWhat");
        }
        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 100);
        System.out.println(isHealthy);
        Optional<Dish> dish = menu.stream()
                .filter(d -> d.isVegetarian())
                .findAny();
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(count);

        List<String> collect = menu.stream()
                .map(d -> d.getName() + 666)
                .collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void test2() {

    }
}




















































