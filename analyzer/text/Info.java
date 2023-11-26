package text;

public record Info(int occurrence,
                   int variants,
                   String minValue,
                   String maxValue,
                   String minString,
                   String maxString,
                   String average) {
    public Info() {
        this(0, 0, null, null, "", "", "");
    }
}
