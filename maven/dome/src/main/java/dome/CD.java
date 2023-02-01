package dome;

public class CD extends Medium{
    private int titleCount;

    public CD(String title, String prod, PlayTime playTime, boolean ownMedia, String kommentar, int titleCount){
        super(title, prod, playTime, ownMedia, kommentar);
    }

    public void setTitleCount(int titleCount) {
        this.titleCount = titleCount;
    }

    public int getTitleCount() {
        return titleCount;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getTitleCount();
    }
}
