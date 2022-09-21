package game.droids.statsInfo;

public class StatsInfoOfHeros{
    public static String stats1v1() {
        return "Статистика:\n" +
                "Тип дроїда:\t|Здоров'я:\t|Шкода:\t|Точність:\t|Шанс критичного удару:\t|Критична шкода:\t|Лікування:\n" +
                "Солдат\t\t|100\t|30\t\t\t|70\t\t\t|20%\t\t\t|45\t\t\t\t|-\n" +
                "Танк\t\t|200\t|10\t\t\t|80\t\t\t|30%\t\t\t|30\t\t\t\t|-\n" +
                "Снайпер\t\t|70\t\t|45\t\t\t|90\t\t\t|35%\t\t\t|60\t\t\t\t|-\n" +
                "Лікар\t\t|100\t\t|10\t\t\t|70\t\t\t|25%\t\t\t|30\t\t\t\t|30\n\n" +
                "1v1 Ультимативні здібності:\n" +
                "Солдат: Збільшує точність до 100 і шанс критичного удару до 50% і знижує точність супротивника до 50\n" +
                "Танк: Збільшує HP до 150% поточного HP (може перевищувати 200)\n" +
                "Снайпер: Завдає 30 одиниць шкоди противнику та зцілює 30 HP\n" +
                "Лікар: Лікує до максимального здоров'я\n";
    }

    public static String stats3v3() {
        return "Статистика:\n" +
                "Тип дроїда:\t|Здоров'я:\t|Шкода:\t|Точність:\t|Шанс критичного удару:\t|Критична шкода:\t|Лікування:\n" +
                "Солдат\t\t|100\t|30\t\t\t|70\t\t\t|20%\t\t\t|45\t\t\t\t|-\n" +
                "Танк\t\t|200\t|10\t\t\t|80\t\t\t|30%\t\t\t|30\t\t\t\t|-\n" +
                "Снайпер\t\t|70\t\t|45\t\t\t|90\t\t\t|35%\t\t\t|60\t\t\t\t|-\n" +
                "Лікар\t\t|60\t\t|10\t\t\t|70\t\t\t|25%\t\t\t|30\t\t\t\t|30\n\n" +
                "3v3 Ультимативні здібності:\n" +
                "Солдат: Збільшує точність до 100% і подвоює шанс нанесення критичного удару собі та всім союзникам\n" +
                "Танк: Збільшує HP до 150% поточного HP собі та всім союзникам\n" +
                "Снайпер: Завдає 100 шкоди обраному супернику\n" +
                "Лікар: Лікує обраного союзника на 100 HP (може оживити мертвих союзників)\n";
    }
}