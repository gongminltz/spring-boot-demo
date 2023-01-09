package org.example.gm.dynamic.jar;

/**
 * TODO
 *
 * @author gongmin
 * @date 2023/1/6 10:59
 */
public class Sum {
    public Sum() {

    }

    public int sum() {
        return sum(1, 100);
    }

    public int sum(Integer start, Integer end) {
        int total = 10;
        for (int i = start; i <= end; i++) {
            total = Add.add(total, i);
            System.out.println("total = " + total);
        }

        return total;
    }
}
