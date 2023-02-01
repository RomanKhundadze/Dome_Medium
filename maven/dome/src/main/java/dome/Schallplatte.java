package dome;

abstract public class Schallplatte extends Medium{
    private int titleCount;
    private int rotationPerMinute;

    public Schallplatte(
        String title,
        String prod, 
        PlayTime playTime, 
        boolean ownMedia, 
        String kommentar, 
        int titleCount,
        int rotationPerMinute
        ){
        super(title, prod, playTime, ownMedia, kommentar);
        
        setTitleCount(titleCount);
        setRotationPerMinute(rotationPerMinute);
    }

    public void setRotationPerMinute(int rotationPerMinute) {
        this.rotationPerMinute = rotationPerMinute;
    }

    public void setTitleCount(int titleCount) {
        this.titleCount = titleCount;
    }

    public int getTitleCount() {
        return titleCount;
    }

    public int getRotationPerMinute() {
        return rotationPerMinute;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getTitleCount() + " " + getRotationPerMinute();
    }
}
