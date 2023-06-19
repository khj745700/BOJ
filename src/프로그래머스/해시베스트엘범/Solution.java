package 프로그래머스.해시베스트엘범;


import java.util.HashMap;
import java.util.Map;

class Album implements Comparable<Album>{
    String genre;
    Integer plays;

    public Album(String genre, int plays){
        this.genre = genre;
        this.plays = plays;
    }


    @Override
    public int compareTo(Album album) {
        return plays - album.plays;
    }
}

public class Solution {
    Map<String, Integer> totalPlays = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {

        //일단 토탈 플레이즈에 모두 저장
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }

    }
}
