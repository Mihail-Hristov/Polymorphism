package word;

import word.interfaces.TextTransform;

public class CutTransform implements TextTransform {
    private String cutText;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        cutText = text.substring(startIndex, endIndex);
        text.replace(startIndex, endIndex, "");
    }

    public String getCutText() {
        return this.cutText;
    }
}
