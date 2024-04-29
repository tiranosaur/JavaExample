package org.example.gof.structural;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

// Вместо создания большого количества похожих объектов, объекты используются повторно.
public class Flyweigh {
    public static void main(String[] args) {
        Point point1 = PointFlyweight.getPoint(1, 2);
        Point point2 = PointFlyweight.getPoint(3, 4);
        Point point3 = PointFlyweight.getPoint(1, 2);

        System.out.println(point1 == point2); //false
        System.out.println(point1 == point3); //true
    }
}

@UtilityClass
class PointFlyweight {
    private static Map<String, Point> pointCache = new HashMap<>();

    public static Point getPoint(int x, int y) {
        String key = x + "," + y;
        if (!pointCache.containsKey(key)) {
            pointCache.put(key, new Point(x, y));
        }
        return pointCache.get(key);
    }
}

@Data
@AllArgsConstructor
class Point {
    private int x;
    private int y;

    public void draw() {
        System.out.println("drawing (" + x + ", " + y + ")");
    }
}