package word;

import word.interfaces.TextTransform;

public class CutTransform implements TextTransform {

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {

        text.replace(startIndex, endIndex, "");
    }
}
