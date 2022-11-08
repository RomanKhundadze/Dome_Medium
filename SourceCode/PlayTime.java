public class PlayTime {
    private int stunde;
    private byte minute;
    private byte secunde;
    private long gesamtSpielzeitSecunden;
    
    public PlayTime(int stunde, int minute, int secunde){
        //Reihenfolge Beibealten: Stunde Minute Sekunde
        setStunde(stunde);
        setMinute((byte) minute);
        setSecunde((byte) secunde);
        setGesamtSpielzeitSecunden(stunde, minute, secunde);
    }

    public void setStunde(int stunde) { 
        filter(stunde);
        this.stunde = stunde;
    }

    public void setMinute(byte minute) {
        filter(minute, 60);
        this.minute = minute;
    }

    public void setSecunde(byte secunde) {
        filter(secunde, 60);
        this.secunde = secunde;
    }

    private void setGesamtSpielzeitSecunden(int stunde, int minute, int secunde) {
        this.gesamtSpielzeitSecunden = (stunde/3600)+(minute/60)+secunde;
    }

    public int getStunde() {
        return stunde;
    }

    public byte getMinute() {
        return minute;
    }

    public byte getSecunde() {
        return secunde;
    }

    public long getGesamtSpielzeitSecunden() {
        return gesamtSpielzeitSecunden;
    }

    private void filter(int check, int max){
        filter(check);

        if(check > max){
            throw new IllegalArgumentException(String.format("Minute/Secunde dürfen nicht größer als %f",max));
        }
    }

    private void filter(int check){    
        if(check < 0){
            throw new IllegalArgumentException("PlayTime nutzt keine Negativen Werte!");
        }
    }

    @Override
    public String toString() {
        return getStunde() + ":" + getMinute() + ":" + getSecunde();
    }
}
