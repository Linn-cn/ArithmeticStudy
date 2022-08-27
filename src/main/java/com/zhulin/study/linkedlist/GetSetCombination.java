package com.zhulin.study.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class GetSetCombination {
    public static void main(String[] args) {
        ArrayList a1 = new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};
        ArrayList a2 = new ArrayList() {{
            add("a");
            add("b");
        }};
        ArrayList a3 = new ArrayList() {{
            add("A");
            add("B");
            add("C");
        }};
        ArrayList<ArrayList> lists = new ArrayList<>();
        lists.add(a1);
        lists.add(a2);
        lists.add(a3);
        ArrayList<ArrayList> res = paiLei(lists);
        System.out.println(res);
    }

    public static ArrayList<ArrayList> paiLei(ArrayList<ArrayList> args) {
        ArrayList<ArrayList> results = new ArrayList<>();
        LinkedList<ArrayList> temps = new LinkedList<>();
        // 把第一行变成结果集
        ArrayList firstList = args.get(0);
        for (int i = 0; i < firstList.size(); i++){
            ArrayList item = new ArrayList();
            item.add(firstList.get(i));
            temps.add(item);
        }
        int currRowNum = 1;
        // 将第一行和第二行的穷举组合保存起来，然后跟第三行进行穷剧组合，以此类推得到最后的结果集
        while (currRowNum < args.size()){
            int size = temps.size();
            for (int i = 0; i < size; i++) {
                ArrayList item = temps.poll();
                ArrayList currRow = args.get(currRowNum);
                for (int j = 0; j < currRow.size(); j++) {
                    ArrayList<Object> temp = new ArrayList<>();
                    temp.addAll(item);
                    temp.add(currRow.get(j));
                    temps.offer(temp);
                }
            }
            currRowNum++;
        }
        results.addAll(temps);
        return results;
    }
}
