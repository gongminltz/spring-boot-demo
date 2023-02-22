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
        int total = 0;
        for (int i = start; i <= end; i++) {
            total = Add.add(total, i);
            System.out.println("total = " + total);
        }

        return total;
    }

    /**
     * 计算连续多个整数的和
     *
     * @param param, [start],[end]
     * @return 和
     */
    public String start(String param) {
        String[] params = param.split(",");
        int start = Integer.parseInt(params[0]);
        int end = Integer.parseInt(params[1]);

        return String.valueOf(sum(start, end));
    }
}
