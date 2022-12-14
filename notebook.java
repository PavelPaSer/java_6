//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков.
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет
//        ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет … НЕ ВЫПОЛНИЛ СОРТИРОВКУ
//        Далее нужно запросить минимальные значения для указанных критериев -
//        сохранить параметры фильтрации можно также в Map.
//        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.



public class notebook {
    String modelNoot;
    String manufacturer;

    int ram_noot;
    int hdd_noot;
    String os_name;
    String noot_coolor;

    notebook(String new_model, String new_manufacturer,
             String new_os_name, int new_ram_noot, int new_hdd_noot, String new_coolor) {
        modelNoot = new_model;
        manufacturer = new_manufacturer;
        ram_noot = new_ram_noot;
        hdd_noot = new_hdd_noot;
        os_name = new_os_name;
        noot_coolor = new_coolor;
    }

    public void info() {
        System.out.println("\n\nПараметры:");
        System.out.printf("Фирма изготовитель: %s \n", manufacturer);
        System.out.printf("Модель: %s \n", modelNoot);
        System.out.printf("Количество оперативной памяти: %d гб \n", ram_noot);
        System.out.printf("Объем жесткого диска: %d гб \n", hdd_noot);
        System.out.printf("Операционная система %s \n", os_name);
        System.out.printf("Операционная система %s \n", noot_coolor);
    }
}