import java.util.ArrayList;
public class Playlist {
	private String name = new String();
	public ArrayList<Song> list_song;
	public Playlist (String name)
	{
		this.name = name;
		list_song = new ArrayList<Song>();
	}
	
	public boolean addSong(Song song)
	{
		for(Song sn : list_song)
		{
			if(sn.getTitle() == song.getTitle())
			{
				System.out.println(song+" already in the playlist.");
				return false;
			}
		}
		list_song.add(song);
		return true;	
	}
	
	public boolean addSongAtIndex(Song song, int index)
	{
		if(index>=list_song.size())
		{
			System.out.println("Invalid Index");
			return false;
		}
		for(Song sn : list_song)
		{
			if(sn.getTitle() == song.getTitle())
			{
				System.out.println("Invalid Index");
				return false;
			}
		}
		list_song.add(index, song);
		return true;
	}
	
	public boolean removeSongByIndex(int index)
	{
		if(index>=list_song.size())
		{
			System.out.println("Invalid Index");
			return false;
		}		
		if(list_song.get(index)==null)
		{
			System.out.print("Invalid Index");
			return false;
		}
		list_song.remove(index);
		return true;
	}
	
	public Song removeSongByTitle(String title) 
	{
		for(Song sn : list_song)
		{
			if(sn.getTitle()==title)
			{
				list_song.remove(sn);
				return sn;
			}
		}
		System.out.println("Not found");
		return null;
	}
	
	public double getPlaylistDuration()
	{
		double total = 0.0;
		for(Song sn : list_song)
		{
			total += sn.getDurationSec();
		}
		total = total*0.6;
		return total;
	}
	public ArrayList<Song> getTooSongs (double minute)
	{
		ArrayList<Song> n_list = list_song;
		for(Song sn : list_song)
		{
			if(sn.getDuration()>minute)
			{
				n_list.add(sn);
			}
		}
		return n_list;
	}
	public void showPlaylist()
	{
		System.out.println(name);
		for(int i=0; i<list_song.size(); i++)
		{
			System.out.println("["+i+"] "+ list_song.get(i).getTitle() + "("+ list_song.get(i).getDuration()+")");
		}
	}
	public void moveUp(int position)
	{
		Song midSong = list_song.get(position);
		list_song.remove(position);
		list_song.add(position-1, midSong);
	}
	public void moveDown(int position)
	{
		Song midSong = list_song.get(position);
		list_song.remove(position);
		list_song.add(position+1, midSong);
	}
}
