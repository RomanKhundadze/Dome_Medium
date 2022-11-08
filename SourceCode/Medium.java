abstract public class Medium {
    private String title, prod, kommentar;
    private PlayTime playTime;
    private boolean ownMedia;

    //Konstrucktor
    public Medium(String title, String prod, PlayTime playTime, boolean ownMedia, String kommentar){
        setTitle(title);
        setProd(prod);
        setpLenght(playTime);
        setOwnMedia(ownMedia);
        setKommentar(kommentar);
    }

    //Geters
    public String getTitle() {
        return title;
    }

    public String getProd() {
        return prod;
    }

    public PlayTime getPlayTime() {
        return playTime;
    }

    public boolean getOwnMedia(){
        return ownMedia;
    }

    public String getKommentar() {
        return kommentar;
    }

    //Seters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setProd(String prod){
        prod = this.prod;
    }

    public void setpLenght(PlayTime playTime) {
        this.playTime = playTime;
    }

    public void setOwnMedia(Boolean ownMedia){
        this.ownMedia = ownMedia;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
    @Override
    public String toString() {
        return getTitle() + " " + getProd() + " " + getPlayTime() + " " + getOwnMedia() + " " + getKommentar();
    }
}