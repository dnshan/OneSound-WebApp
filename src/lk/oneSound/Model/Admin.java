package lk.oneSound.Model;

public class Admin {

	private int artistid;
	private String songname ;
	private String duration;
	private String category;
	

	public Admin(int artistid, String songname , String duration, String category) {

		this.artistid = artistid;
		this.songname = songname;
		this.duration = duration;
		this.category = category;
		
	}

	public int getartistid() {
		return artistid;
	}

	public String getsongname() {
		return songname;
	}

	public String getduration() {
		return duration;
	}

	public String getcategory() {
		return category;
	}


}


