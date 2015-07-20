package com.horcu.apps.balln.utilities;

import com.horcu.apps.balln.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ray on 7/18/15.
 */
public  class TeamHelmets {

 static Map<String, Integer> Helmets = new HashMap<String, Integer>(){
      {
          put("packers_away", R.drawable.packers_away);
          put("packers_home", R.drawable.packers_home);
          put("seahawks_away", R.drawable.seahawks_away);
          put("seahawks_home", R.drawable.seahawks_home);
          put("saints_away", R.drawable.saints_away);
          put("saints_home", R.drawable.saints_home);
          put("falcons_away", R.drawable.falcons_away);
          put("falcons_home", R.drawable.falcons_home);
          put("patriots_away", R.drawable.patriots_away);
          put("patriots_home", R.drawable.patriots_home);
          put("dolphins_away", R.drawable.dolphins_away);
          put("dolphins_home", R.drawable.dolphins_home);
          put("jaguars_away", R.drawable.jaguars_away);
          put("jaguars_home", R.drawable.jaguars_home);
          put("eagles_away", R.drawable.eagles_away);
          put("eagles_home", R.drawable.eagles_home);
          put("raiders_away", R.drawable.raiders_away);
          put("raiders_home", R.drawable.raiders_home);
          put("jets_away", R.drawable.jets_away);
          put("jets_home", R.drawable.jets_home);
          put("bills_away", R.drawable.bills_away);
          put("bills_home", R.drawable.bills_home);
          put("bears_away", R.drawable.bears_away);
          put("bears_home", R.drawable.bears_home);
          put("titans_away", R.drawable.titans_away);
          put("titans_home", R.drawable.titans_home);
          put("chiefs_away", R.drawable.chiefs_away);
          put("chiefs_home", R.drawable.chiefs_home);
          put("browns_away", R.drawable.browns_away);
          put("browns_home", R.drawable.browns_home);
          put("steelers_away", R.drawable.steelers_away);
          put("steelers_home", R.drawable.steelers_home);
          put("redskins_away", R.drawable.redskins_away);
          put("redskins_home", R.drawable.redskins_home);
          put("texans_away", R.drawable.texans_away);
          put("texans_home", R.drawable.texans_home);
          put("bengals_away", R.drawable.bengals_away);
          put("bengals_home", R.drawable.bengals_home);
          put("ravens_away", R.drawable.ravens_away);
          put("ravens_home", R.drawable.ravens_home);
          put("vikings_away", R.drawable.vikings_away);
          put("vikings_home", R.drawable.vikings_home);
          put("rams_away", R.drawable.rams_away);
          put("rams_home", R.drawable.rams_home);
          put("panthers_away", R.drawable.panthers_away);
          put("panthers_home", R.drawable.panthers_home);
          put("buccaneers_away", R.drawable.buccaneers_away);
          put("buccaneers_home", R.drawable.buccaneers_home);
          put("fortyniners_away", R.drawable.fortyniners_away);
          put("fortyniners_home", R.drawable.fortyniners_home);
          put("cowboys_away", R.drawable.cowboys_away);
          put("cowboys_home", R.drawable.cowboys_home);
          put("colts_away", R.drawable.colts_away);
          put("colts_home", R.drawable.colts_home);
          put("lions_away", R.drawable.lions_away);
          put("lions_home", R.drawable.lions_home);
          put("broncos_away", R.drawable.broncos_away);
          put("broncos_home", R.drawable.broncos_home);
          put("giants_away", R.drawable.giants_away);
          put("giants_home", R.drawable.giants_home);
          put("chargers_away", R.drawable.chargers_away);
          put("chargers_home", R.drawable.chargers_home);
          put("cardinals_away", R.drawable.cardinals_away);
          put("cardinals_home", R.drawable.cardinals_home);
      }

  };
    public static Integer getHelmet(String key)
    {
        try {
            return Helmets.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
