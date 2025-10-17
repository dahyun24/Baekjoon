import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map<String, List<int[]>> genreSongs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>())
                      .add(new int[]{i, plays[i]});
        }

        for (List<int[]> list : genreSongs.values()) {
            list.sort((a, b) -> {
                if (b[1] == a[1]) return a[0] - b[0]; // 재생 수 같으면 index 낮은 순
                return b[1] - a[1]; // 재생 수 높은 순
            });
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            for (int i = 0; i < songs.size() && i < 2; i++) {
                result.add(songs.get(i)[0]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
