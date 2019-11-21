import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class favoriteGenre {
    public static Map<String,List<String>> op = new HashMap<>();

    public static void main(String[] args) {

        HashMap<String,List<String>> ub = new HashMap<>();
        List<String> booklist1 = new ArrayList<>();
        List<String> booklist2 = new ArrayList<>();
        booklist1.add("Harry Potter");
        booklist1.add("Sherlock Holmes");
        booklist1.add("2 states");
        ub.put("Sachin",booklist1);
        booklist2.add("Half girlfriend");
        booklist2.add("Stephen King");
        booklist2.add("Dracula");
        booklist2.add("Romeo & juliet");
        ub.put("Anurag",booklist2);

        HashMap<String,List<String>> g = new HashMap<>();
        List<String> genreList1 = new ArrayList<>();
        List<String> genreList2 = new ArrayList<>();
        List<String> genreList3 = new ArrayList<>();
        genreList1.add("Harry Potter");
        genreList1.add("Sherlock Holmes");
        genreList2.add("2 states");
        genreList2.add("Eat Pray Love");
        genreList2.add("Half girlfriend");
        genreList2.add("Romeo & juliet");
        genreList3.add("Stephen King");
        genreList3.add("Dracula");
        g.put("Mystery",genreList1);
        g.put("Romance",genreList2);
        g.put("Horror",genreList3);

        op = favoritegenre(ub, g);
        for(Map.Entry<String, List<String>> map: op.entrySet()){
            System.out.println("" + map.getKey() + map.getValue());
        }
    }


    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, String> songstogenre = new HashMap<>();

        for(String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for(String song : songs) {
                songstogenre.put(song, genre);
            }
        }

//        for(Map.Entry<String, String> m: songstogenre.entrySet()){
//            System.out.println("" + m.getKey() + "   "+ m.getValue());
//        }

        Map<String, Integer> count; // song, count for each user create this map
        int max;
        for(String user: userMap.keySet()){
            count = new HashMap<>();
            max = 0;
            res.put(user, new ArrayList<>());
            List<String> songs = userMap.get(user);
            for(String song: songs){
                String genre = songstogenre.get(song);
                int c = count.getOrDefault(genre, 0) + 1;
                count.put(genre, c);
                max = Math.max(max, c);
            }

            for(String key: count.keySet()){
                if(count.get(key) == max)
                    res.get(user).add(key);
            }

        }
        return res;
    }
}

//class Solution{
//
//    public static Map<String, List<String>> findGenre(Map<String, List<String>> userList, Map<String, List<String>> genreList{
//        HashMap<String, List<String>> result = new HashMap<>();
//        for(Map.Entry<String, List<String>> entry: userList.entrySet()){
//            String user = entry.getKey();
//            List<String> userSongs = entry.getValue();
//            HashMap<String, Integer> map = new HashMap<>();
//
//            for(String userSong: userSongs){
//
//                for(Map.Entry<String, List<String>> entry: genreList.entrySet()){
//                    String genre = entry.getKey();
//                    List<String> genreSongs = entry.getValue();
//
//                    if(genreSongs.contains(userSong)){
//                        map.put(genre, map.getOrDefault(genre,0)+1);
//                    }
//                }
//            }
//            int max_val = 0;
//            List<String> user_genres = new ArrayList<>();
//            for(Map.Entry<String, Integer> entry: map.entrySet()){
//                if(entry.getValue >= max_val){
//                    max_val = entry.getValue();
//                    user_genres.add(entry.getKey());
//                }
//            }
//            result.put(user, user_genres);
//        }
//        return result;
//    }
//}