public class Music extends Activities{
    String artistName;
    String trackName;

    Music (String artistName, String trackName, String time){
        this.artistName = artistName;
        this.trackName = trackName;
        this.time = convertToSecond(time);
        price = 0;

    }

    @Override
    public String toString() {
        return "Music{" +
                "artistName='" + artistName + '\'' +
                ", trackName='" + trackName + '\'' +
                '}';
    }
}
