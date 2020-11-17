package word;

import word.interfaces.TextTransform;

public class Command {
    private String text;
    private TextTransform textTransform;
    private String lastCut;

    public Command(String text, TextTransform textTransform){
        this.text = text;
        this.textTransform = textTransform;
        if (textTransform instanceof CutTransform) {
            this.lastCut = ((CutTransform) textTransform).getCutText();
        }
    }

    public String getText() {
        return this.text;
    }
    public TextTransform getTextTransform() {
        return this.textTransform;
    }

    public String getLastCut() {
        return this.lastCut;
    }

    public void setLastCut(String lastCut) {
        this.lastCut = lastCut;
    }

}
