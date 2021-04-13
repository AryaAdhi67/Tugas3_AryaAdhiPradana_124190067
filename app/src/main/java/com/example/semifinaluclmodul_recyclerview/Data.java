package com.example.semifinaluclmodul_recyclerview;

import java.util.ArrayList;

public class Data {
    private static  String[] title = new String[]{"Manchester United", "Real Madrid",
                                     "Chelsea", "Barcelona",};
    private static int[] thumbnail = new int[]{R.drawable.mu,R.drawable.madrid,
                                     R.drawable.chelsea, R.drawable.barcelona};

    public static ArrayList<Model> getListData(){
        Model model = null;
        ArrayList<Model> list = new ArrayList<>();
        for (int i = 0; i < title.length; i++){
            model = new Model();
            model.setLambangTeam(thumbnail[i]);
            model.setNamaTeam(title[i]);
            list.add(model);
        }
        return list;
    }

    public static String getTitle(int posisi) {
        return title[posisi];
    }

    public static int getThumbnail(int posisi) {
        return thumbnail[posisi];
    }

}
