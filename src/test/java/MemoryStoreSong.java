import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
public class MemoryStoreSong {

	 @Test
	    public void inMemoryStoreSongs(){
	        
	        RecentlyPlayedStore store=new RecentlyPlayedStore(3);

	        store.addSong("Song 1","User A");
	        store.addSong("Song 2","User A");
	        store.addSong("Song 3","User A");

	        System.out.println("Song Playlist Looks like: "+store.getRecentlyPlayedSongs("User A"));
	        Assert.assertEquals(store.getRecentlyPlayedSongs("User A"), Arrays.asList("Song 1", "Song 2", "Song 3"));

	        store.addSong("Song 4","User A");
	        System.out.println("When Song 4 is played: "+store.getRecentlyPlayedSongs("User A"));
	        Assert.assertEquals(store.getRecentlyPlayedSongs("User A"), Arrays.asList("Song 2", "Song 3", "Song 4"));

	        store.addSong("Song 2","User A");
	        System.out.println("When Song 2 is played: "+store.getRecentlyPlayedSongs("User A"));
	        Assert.assertEquals(store.getRecentlyPlayedSongs("User A"), Arrays.asList("Song 3", "Song 4", "Song 2"));

	        store.addSong("Song 1","User A");
	        System.out.println("When Song 1 is played: "+store.getRecentlyPlayedSongs("User A"));
	        Assert.assertEquals(store.getRecentlyPlayedSongs("User A"), Arrays.asList("Song 4", "Song 2", "Song 1"));
	    }
}
