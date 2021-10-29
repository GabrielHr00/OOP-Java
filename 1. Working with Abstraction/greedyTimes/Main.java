package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static long gold = 0;
    static long stones = 0;
    static long money = 0;
    static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long input = Long.parseLong(scanner.nextLine());
        String[] treasure = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bagOfGoods = new LinkedHashMap<>();

        for (int i = 0; i < treasure.length; i += 2) {
            String name = treasure[i];
            count = Long.parseLong(treasure[i + 1]);

            String goodFromTheBag = getGoodFromTheBag(name);


            if (goodFromTheBag.equals("")) {
                continue;
            } else if (checkInRange(input, bagOfGoods, count)) {
                continue;
            }

            switch (goodFromTheBag) {
                case "Gem":
                    if (!bagOfGoods.containsKey(goodFromTheBag)) {
                        if (bagOfGoods.containsKey("Gold")) {
                            if (count > bagOfGoods.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagOfGoods.get(goodFromTheBag).values().stream().mapToLong(e -> e).sum() + count > bagOfGoods.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bagOfGoods.containsKey(goodFromTheBag)) {
                        if (bagOfGoods.containsKey("Gem")) {
                            if (count > bagOfGoods.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagOfGoods.get(goodFromTheBag).values().stream().mapToLong(e -> e).sum() + count > bagOfGoods.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            puIfNotThere(bagOfGoods, name, goodFromTheBag);

            bagOfGoods.get(goodFromTheBag).put(name, bagOfGoods.get(goodFromTheBag).get(name) + count);
            increaseResources(goodFromTheBag);
        }

        printValues(bagOfGoods);
    }

    private static void printValues(Map<String, LinkedHashMap<String, Long>> bagOfGoods) {
        for (var x : bagOfGoods.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));
            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    private static void increaseResources(String goodFromTheBag) {
        if (goodFromTheBag.equals("Gold")) {
            gold += count;
        } else if (goodFromTheBag.equals("Gem")) {
            stones += count;
        } else if (goodFromTheBag.equals("Cash")) {
            money += count;
        }
    }

    private static void puIfNotThere(Map<String, LinkedHashMap<String, Long>> bagOfGoods, String name, String goodFromTheBag) {
        if (!bagOfGoods.containsKey(goodFromTheBag)) {
            bagOfGoods.put(goodFromTheBag, new LinkedHashMap<>());
        }

        if (!bagOfGoods.get(goodFromTheBag).containsKey(name)) {
            bagOfGoods.get(goodFromTheBag).put(name, 0L);
        }
    }

    private static boolean checkInRange(long input, Map<String, LinkedHashMap<String, Long>> bagOfGoods, long count) {
        long temp = bagOfGoods.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
        temp += count;
        return input < temp;
    }

    private static String getGoodFromTheBag(String name) {
        String goodies = "";
        if (name.length() == 3) {
            goodies = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            goodies = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            goodies = "Gold";
        }
        return goodies;
    }
}