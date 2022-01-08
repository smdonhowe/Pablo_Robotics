public class App {
    public static void main(String[] args) throws Exception {
        boolean value = readValue(5, 7);
    }

    static public boolean readValue(int value1, int value2) {
        if(value1 == value2) {
            return true;
        }
        return false;
    }
}
