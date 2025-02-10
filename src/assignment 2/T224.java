public class T224 {
    public static void main(String[] args) {
        String navigator = "Джон";
        String pilot = "Пол";
        String secondPilot = "Джордж";
        String flightEngineer = "Ринго";
        createCrew(navigator, pilot, secondPilot, flightEngineer);
    }
    public static void createCrew(String navigator, String pilot, String secondPilot, String flightENgineer){
        System.out.println("Экипаж:");
        System.out.println("Навигатор: " + navigator);
        System.out.println("Пилот: " + pilot);
        System.out.println("Второй пилот: " + secondPilot);
        System.out.println("Бортинженер: " + flightENgineer);
    }
}