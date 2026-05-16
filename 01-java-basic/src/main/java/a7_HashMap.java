import java.util.*;

public class a7_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // 1. 增/改 (put)
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Pear", 20);
        map.put("Apple", 15); // Key 重复时，会覆盖旧的 Value
        map.putIfAbsent("Banana", 30); // 如果 Banana 已经有值了，这行代码什么也不做
        System.out.println(map);

        // 2. 查 (get)
        Integer price = map.get("Apple"); // 15
        // 如果找不到，返回默认值 (非常实用)
        Integer orangePrice = map.getOrDefault("Orange", 0);

        // 3. 删 (remove)
        map.remove("Banana");

        // 4. 遍历 (最推荐的 entrySet 方式)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " 价格为: " + entry.getValue());
        }

        map.forEach((k, v) -> {
            System.out.println(k + " 价格为: " + v);
        });

        // 5. 转换: map -> list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // HashMap 与 Properties (配置文件)
        Properties props = new Properties();
        props.putAll(map); // 将 Map 中的配置存入 Properties 对象

        // 注意三个很重要的方法 1.compute, 2.computeIfAbsent(不存在才初始化), 3.computeIfPresent(存在才修改)
        // 其中compute可以替代 computeIfAbsent, computeIfPresent, 但是还是不推荐什么场景都使用compute
        // 因为:① 语义明确（Readable）② 性能避坑（Performance）
        // 千万不要在 computeIfAbsent 的内部函数里再去修改这个 Map。会导致 ConcurrentModificationException

        HashMap<String, List<String>> category = new HashMap<>();

        List<String> ve = category.computeIfAbsent("蔬菜", k -> new ArrayList<>());
        ve.add("西红柿");

        // 如果没有 "水果" 这个 Key，就自动创建一个 ArrayList，然后把 "苹果" 加进去
        category.computeIfAbsent("水果", k -> new ArrayList<>()).add("苹果");
        category.computeIfAbsent("水果", k -> new ArrayList<>()).add("梨子");
        System.out.println(category);

        // category.computeIfPresent("水果", (k, v) -> {
        //     System.out.println(k);
        //     System.out.println(v);
        //     return new ArrayList<>();
        // });
        System.out.println(category);

        for (String key : category.keySet()) {
            System.out.println(key);

            category.compute(key, (k, v) -> {
                if ("水果".equals(k)) {
                    v.add("加一个水果");
                    return v;
                }
                return v;
            });
        }
        System.out.println(category);
    }
}
