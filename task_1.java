
import java.util.HashSet;
import java.util.Scanner;

public class task_1 {

    public static void main(String[] args) {
        notebook note_1 = new notebook("Intel Core i5 6400", "HP", "Windows 10", 4, 500, "Белый");
        notebook note_2 = new notebook("Intel Core i5 7400",
                "Acer", "Windows 10", 4, 500, "Белый");
        notebook note_3 = new notebook("Intel Core i5 7400", "Acer", "Ubuntu", 4, 1000, "Черный");
        notebook note_4 = new notebook("Ryzen 5 3600",
                "Macbook", "MAC OS", 8, 320, "Серебристый");
        notebook note_5 = new notebook("Ryzen 5 5500U",
                "Asus", "Lunex", 32, 500, "Синий");
        notebook note_6 = new notebook("Intel Core i7 8700k",
                "Asus", "NoOS", 16, 750, "Белый");
        HashSet<notebook> add_notebook = new HashSet<>();
        add_notebook.add(note_1);
        add_notebook.add(note_2);
        add_notebook.add(note_3);
        add_notebook.add(note_4);
        add_notebook.add(note_5);
        add_notebook.add(note_6);
        main_menu(add_notebook);
    }

     public static void main_menu(HashSet<notebook> add_notebook) {
        System.out.println("\nДобро пожаловать в интернет-магазин ноутбуков");
        boolean flag = false;
        while (!flag) {
            System.out.println("\nГлавное меню интернет-магазина");
            System.out.println("""
                    1. Наш каталог
                    2. Сортировка каталога
                    3. Покинуть магазин""");
            System.out.print("\nВыберите необходимый пункт меню: ");
            Scanner set = new Scanner(System.in);
            String change = set.next();
            if (change.equals("1") || change.equals("2") || change.equals("3")) {
                if (change.equals("1")) {
                    for (notebook p : add_notebook) {
                        p.info();
                    }
                } else if (change.equals("2")) {
                    flag = true;
                    file_menu(add_notebook);
                } else {
                    System.out.println("\nЗавершаю работу");
                    System.out.println("\nБудем ждать Вас снова");
                    flag = true;
                }
            } else {
                System.out.println("Вы ввели не существующий пункт меню");
                System.out.println("\n Повторите попытку еще раз");
            }
        }
    }

    public static void file_menu(HashSet<notebook> add_notebook) {
        HashSet<notebook> filter = new HashSet<>();
        boolean flag = false;
        while (!flag) {
            System.out.println("\nОтсортируйте и продолжите поиск");
            System.out.println("""
                    1. Отсортировать по количеству ОЗУ
                    2. Отсортировать по объему жесткого диска
                    3. Вывести на экран c учетом сортировки
                    4. Сбросить параметры сортировки
                    5. Назад
                    """);
            System.out.print("Выберите пункт меню: ");
            Scanner set = new Scanner(System.in);
            String change = set.next();
            if (change.equals("1") || change.equals("2") || change.equals("3")
                    || change.equals("4") || change.equals("5")) {
                switch (change) {
  
                    case "1" -> ram_sort(add_notebook, filter);
                    case "2" -> hdd_sort(add_notebook, filter);
                    case "3" -> {
                        if (!filter.isEmpty()) {
                            for (notebook p : filter) {
                                p.info();
                            }
                        } else {
                            System.out.println("\nНет ноутбуков удовлетворяющих вашим условиям, повторите поиск");
                        }
                    }
                    case "4" -> {
                        filter.clear();
                        System.out.println("\nПараметры сортировки сброшены");
                    }
                    default -> {
                        flag = true;
                        main_menu(add_notebook);
                    }
                }
            } else {
                System.out.println("Вы ввели не существующий пунк меню");
                System.out.println("\nВыберите пункт меню из списка");
            }
        }
    }


    public static void ram_sort(HashSet<notebook> add_notebook, HashSet<notebook> filter) {
        Scanner set = new Scanner(System.in);
        int min_ram_new = 0;
        int max_ram_new = 0;
        boolean flag = false;
        while (!flag) {
            System.out.print("Введите минимальный объем оперативной памяти: ");
            String min_ram = set.next();
            if (isDigit(min_ram)) {
                min_ram_new = Integer.parseInt(min_ram);
                flag = true;
            } else {
                System.out.println("Вы ввели не верный символ \nВведите число от 8");
            }
        }
        flag = false;
        while (!flag) {
            System.out.print("Введите максимальный объем оперативной памяти: ");
            String max_ram = set.next();
            if (isDigit(max_ram)) {
                max_ram_new = Integer.parseInt(max_ram);
                flag = true;
            } else {
                System.out.println("Вы ввели не верный символ\nВведите число до 32");
            }
        }
        if (filter.isEmpty()) {
            for (notebook p : add_notebook) {
                if (p.ram_noot <= max_ram_new && p.ram_noot >= min_ram_new) {
                    filter.add(p);
                }
            }
        } else {
            HashSet<notebook> support_filter = new HashSet<>(filter);
            filter.clear();
            for (notebook p : support_filter) {
                if (p.ram_noot <= max_ram_new && p.ram_noot >= min_ram_new) {
                    filter.add(p);
                }
            }
        }
    }

    public static void hdd_sort(HashSet<notebook> add_notebook, HashSet<notebook> filter) {
        Scanner set = new Scanner(System.in);
        int min_hdd_new = 0;
        int max_hdd_new = 0;
        boolean flag = false;
        while (!flag) {
            System.out.print("Введите минимальный объем жесткого диска: ");
            String min_hdd = set.next();
            if (isDigit(min_hdd)) {
                min_hdd_new = Integer.parseInt(min_hdd);
                flag = true;
            } else {
                System.out.println("Вы ввели не верный символ\nВведите число от 320");
            }
        }
        flag = false;
        while (!flag) {
            System.out.print("Введите максимальный объем жесткого диска: ");
            String max_hdd = set.next();
            if (isDigit(max_hdd)) {
                max_hdd_new = Integer.parseInt(max_hdd);
                flag = true;
            } else {
                System.out.println("Вы ввели не верный символ\nВведите число до 1000");
            }
        }
        if (filter.isEmpty()) {
            for (notebook p : add_notebook) {
                if (p.hdd_noot <= max_hdd_new && p.hdd_noot >= min_hdd_new) {
                    filter.add(p);
                }
            }
        } else {
            HashSet<notebook> support_filter = new HashSet<>(filter);
            filter.clear();
            for (notebook p : support_filter) {
                if (p.hdd_noot <= max_hdd_new && p.hdd_noot >= min_hdd_new) {
                    filter.add(p);
                }
            }
        }
    }

    private static boolean isDigit(String set) throws NumberFormatException {
        try {
            Integer.parseInt(set);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}