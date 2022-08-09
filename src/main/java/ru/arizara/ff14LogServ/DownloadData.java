package ru.arizara.ff14LogServ;

import org.json.JSONArray;
import ru.arizara.ff14LogServ.download.ImageLoad;
import ru.arizara.ff14LogServ.download.JSONLoad;

public class DownloadData {

    public static void main(String[] args) {
        System.out.println("JSONLoad.getJSON");
        JSONLoad.getJSON("https://ffxivcollect.com/api/orchestrions", App.ORCH_CAT);
        JSONArray mounts = JSONLoad.getJSON("https://ffxivcollect.com/api/mounts",App.MOUNT);
        JSONArray minion = JSONLoad.getJSON("https://ffxivcollect.com/api/minions",App.MINION);
        JSONArray blm = JSONLoad.getJSON("https://ffxivcollect.com/api/spells",App.BLUE_MAGE);


        System.out.println("ImageLoad.mountImage");
        ImageLoad.mountImage(mounts);
        System.out.println("ImageLoad.minionImage");
        ImageLoad.minionImage(minion);
        System.out.println("ImageLoad.blmImage");
        ImageLoad.blmImage(blm);
    }
}
