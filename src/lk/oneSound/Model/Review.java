package lk.oneSound.Model;





public class Review {
    private int reviewId;
    private int artistId;
    private String songName;
    private String category;
    private float duration;

    public Review() {
    }

    public Review(int reviewId, int artistId, String songName, String category, float duration) {
        this.reviewId = reviewId;
        this.artistId = artistId;
        this.songName = songName;
        this.category = category;
        this.duration = duration;
    }

    public int getreviewId() {
        return reviewId;
    }

 

    public int getArtistId() {
        return artistId;
    }



    public String getsongName() {
        return songName;
    }



    public String getCategory() {
        return category;
    }


    public float getDuration() {
        return duration;
    }

   
}

