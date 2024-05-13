package Task2;

public class Cul {
    int x;
    int y;

    char op;

    Cul(int x, int y, char op) {
        this.x = x;
        this.y = y;
        this.op = op;
        exp(x, y);
        resultXAndY(x, y, op);
    }

    private static void exp(int x, int y) {
        if (x == 0 || y == 0){
            throw new RuntimeException("На ноль не делится");
        }
    }

    private void resultXAndY(int x, int y, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
            default:
                break;
        }


        System.out.println("= " + result);

    }
}
