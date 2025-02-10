public class T223 {
    public static void main(String[] args) {
        String name = "Ольга";
        String surname = "Киприяновна";
        String meal = "Пельмени";
        printPersonInfo(name, surname, meal);
    }

    public static void printPersonInfo(String firstName, String lastName, String
            favouriteDish){
        System.out.println("Краткое досье:");
        System.out.println("Имя: " + firstName);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Любимое блюдо: " + favouriteDish);
    }

}