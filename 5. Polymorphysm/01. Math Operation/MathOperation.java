public class MathOperation {
    public MathOperation() {
    }
    public int add(int f, int s){
        return f + s;
    }
    public int add(int f, int s, int t){
        return add(add(f, s), t);
    }
    public int add(int f, int s, int t, int fo){
        return add(add(f, s, t), fo);
    }
}
