import java.util.*;
public class RecentlyPlayedStore {
	private int capacity;

    private int currentSize;

    private Map<String, ArrayList<Song>> songs;

    private Deque<Song> recentSongs;

    public RecentlyPlayedStore(int initialCapacity){
        capacity=initialCapacity;
        currentSize=0;
        songs=new HashMap<>();
        recentSongs=new LinkedList<>();
    }

    /**
     * User adding songs to the recently played song list
     */
    public void addSong(String name, String user){
        if (!songs.containsKey(user)){
            songs.put(user, new ArrayList<Song>());
        }
        evictLeastRecentlyPlayed();

        Song song=new Song(name, user);

        songs.get(user).add(song);
        recentSongs.addFirst(song);
        currentSize++;
    }

    /**
     * This function returns the songs by removing the least recently played songs
     */
    private void evictLeastRecentlyPlayed(){
        if(currentSize>=capacity){
            Song leastRecentlyPlayed =recentSongs.removeLast();
            songs.get(leastRecentlyPlayed.getUser()).remove(leastRecentlyPlayed);
            if(songs.get(leastRecentlyPlayed.getUser()).isEmpty()){
                songs.remove(leastRecentlyPlayed.getUser());
            }
            currentSize--;
        }
    }

    /**
     * This function returns recently played songs
     */
    public List<String> getRecentlyPlayedSongs(String user){
        if(songs.containsKey(user)){
            ArrayList<Song> userSongs = songs.get(user);
            ArrayList<String> recentlyPlayedSongs=new ArrayList<>();
            for(Song song:userSongs){
                recentlyPlayedSongs.add(song.getName());
            }
            return recentlyPlayedSongs;
        }else {
            return new ArrayList<>();
        }
    }


}
