package mobile;

public class Kotik {
    private String color, name, voice;
    private int weight, saturation, age;

    public static int catsQuantity = 0;

    private boolean runs() {
        return action("Бегает по дому");
    }

    private boolean play() {
        return action("Играет с носком");
    }

    private boolean voice() {
        return action("Мяу-мяу-мяу");
    }

    private boolean sleep() {
        return action("Спит");
    }

    private boolean chaseMouse() {
        return action("Ловит мышь");
    }

    public Kotik(String color, String name, String voice, int weight, int saturation, int age) {
        setKotik(color, name, voice, weight, saturation, age);
        catsQuantity++;
    }

    public Kotik() {
        catsQuantity++;
    }

    public void setKotik(String color, String name, String voice, int weight, int saturation, int age) {
        this.color = color;
        this.name = name;
        this.voice = voice;
        this.weight = weight;
        this.saturation = saturation;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public String getName(){
        return name;
    }

    public String getVoice() {
        return voice;
    }

    public int getSaturation() {
        return saturation;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            int result = (int) Math.round(Math.random() * 3);
            boolean catDidAction = false;
            switch (result) {
                case 0:
                    catDidAction = runs();
                    saturation--;
                    break;
                case 1:
                    catDidAction = play();
                    saturation--;
                    break;
                case 2:
                    catDidAction = voice();
                    saturation--;
                    break;
                case 3:
                    catDidAction = sleep();
                    saturation--;
                    break;
                case 4:
                    catDidAction = chaseMouse();
                    saturation++;
                    break;
                default:
                    break;
            }
            if (!catDidAction) eat();
        }
    }

    void eat(int addSaturation) {
        saturation += addSaturation;
    }

    void eat(int addSaturation, String food) {
        eat(addSaturation);
    }

    void eat() {
        eat(5, "Катлету");
        say(getName() + " съел");
    }

    private void say(String inputMsg) {
        System.out.println(inputMsg);
    }

    private boolean action(String msg) {
        if (saturation <= 0) {
            say(getName() + " покормите котика!!!");
            return false;
        }
        say(getName() + ": " + msg);
        return true;
    }
}