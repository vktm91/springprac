package com.example.javaprac.baekJoon.hanghae;

public class Test01 {

  public String solution(String m, String[] musicinfos) {
    String answer = "";
    int maxPlayTime = 0;

    m = convert(m);

    for (String musicnfo : musicinfos) {
      String[] info = musicnfo.split(",");
      String title = info[2];
      String music = convert(info[3]);

      String[] start = info[0].split(":");
      String[] end = info[1].split(":");
      int hour = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60;
      int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
      int playTime = hour + minute;

      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < playTime; i++) {
        sb.append(music.charAt(i % music.length()));
      }

      if (sb.toString().contains(m)) {
        if (maxPlayTime < sb.toString().length()) {
          maxPlayTime = sb.toString().length();
          answer = title;
        }
      }
    }
    System.out.println(answer);
    return answer;
  }

  private String convert(String m) {
    m = m.replaceAll("C#", "c");
    m = m.replaceAll("D#", "d");
    m = m.replaceAll("F#", "f");
    m = m.replaceAll("G#", "g");
    m = m.replaceAll("A#", "a");
    return m;
  }

}
