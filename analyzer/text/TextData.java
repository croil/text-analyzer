package text;

public record TextData(
        String file,
        Info sentences,
        Info words,
        Info numbers,
        Info money,
        Info date) {
}
