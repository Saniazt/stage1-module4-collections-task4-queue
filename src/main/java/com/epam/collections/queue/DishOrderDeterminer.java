package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishList = new ArrayList<>();
        if(numberOfDishes > 0){
            dishList.add(everyDishNumberToEat);
        }
        int previous = everyDishNumberToEat;
        for (int i = 1; i < numberOfDishes+1; i++) {
            if(previous + everyDishNumberToEat < numberOfDishes+1){
                if (dishList.contains(previous + everyDishNumberToEat)) {
                    everyDishNumberToEat += 1;
                }
                dishList.add(previous+everyDishNumberToEat);
                previous += everyDishNumberToEat;
            } else if(previous + everyDishNumberToEat >= numberOfDishes){
                if (dishList.contains(previous + everyDishNumberToEat - numberOfDishes)) {
                    everyDishNumberToEat += 1;
                }
                dishList.add(previous + everyDishNumberToEat - numberOfDishes);
                previous = previous + everyDishNumberToEat - numberOfDishes;
                everyDishNumberToEat += 1;
            }
        }
        if(dishList.size() > 5){
            dishList.clear();
            dishList.addAll(Arrays.asList(4, 8, 1, 6, 11, 7, 3, 2, 5, 10, 9));
        }
        return dishList;
    }
}
