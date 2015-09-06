package com.horcu.apps.balln.ui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ViewAnimator;


import com.amulyakhare.textdrawable.TextDrawable;
import com.horcu.apps.balln.R;
import com.horcu.apps.balln.models.game.AwayTeam;
import com.horcu.apps.balln.models.game.Game;
import com.horcu.apps.balln.models.game.HomeTeam;
import com.horcu.apps.balln.models.game.Offense;
import com.horcu.apps.balln.models.game.Player;
import com.horcu.apps.balln.models.game.PlayerPosition;
import com.horcu.apps.balln.models.game.Position;
import com.horcu.apps.balln.models.game.TeamColors;
import com.horcu.apps.balln.ui.activities.PlayerChooserActivity;
import com.horcu.apps.balln.utilities.TeamHelmets;
import com.horcu.apps.balln.utilities.decorUtil;

import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Select;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class GameActivityFragment extends Fragment {

    public GameActivityFragment() {
    }

    int count = 0;
    public static final int REQUEST_CHOOSE_PLAYER = 0x1234;


    com.horcu.apps.balln.widget.floatinglabel.itemchooser.FloatingLabelItemChooser<Player> playerChooser;


    public static GameActivityFragment newInstance() {
        return new GameActivityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_game, container, false);
        try {
            Intent intent = getActivity().getIntent();
            final Game game = intent.getParcelableExtra("game");
            Long ateamId = game.getAwayTeamId();
            Long hteamId = game.getHomeTeamId();

            AwayTeam ateam = new Select().from(AwayTeam.class).where(Condition.column("id").eq(ateamId)).querySingle();
            Offense ateamOffense = new Select().from(Offense.class).where(Condition.column("id").eq(ateam.getOffenseId())).querySingle();
            String ateamPlayerPositionId = ateamOffense.getPlayerPositionId();
            List<PlayerPosition> ateamPlayerPositions = new Select().from(PlayerPosition.class).where(Condition.column("playerPositionId").eq(ateamPlayerPositionId)).queryList();

            HomeTeam hteam = new Select().from(HomeTeam.class).where(Condition.column("id").eq(hteamId)).querySingle();
            Offense hteamOffense = new Select().from(Offense.class).where(Condition.column("id").eq(hteam.getOffenseId())).querySingle();
            String hteamPlayerPositionId = hteamOffense.getPlayerPositionId();
            List<PlayerPosition> hteamPlayerPositions = new Select().from(PlayerPosition.class).where(Condition.column("playerPositionId").eq(hteamPlayerPositionId)).queryList();

            String awayLogo = ateam.getLogo();
            String homeLogo = hteam.getLogo();

            Drawable d =  getActivity().getResources().getDrawable(TeamHelmets.getHelmet(awayLogo));
            Drawable d1 =  getActivity().getResources().getDrawable(TeamHelmets.getHelmet(homeLogo));


            final ViewAnimator viewAnimator = (ViewAnimator)root.findViewById(R.id.mathups_animator);

            final View awayBar = root.findViewById(R.id.top_bar_spacer_away);
            TeamColors tcol1 = new Select().from(TeamColors.class).where(Condition.column("id").eq(ateam.getTeamColorsId())).querySingle();
            TeamColors tcol2 = new Select().from(TeamColors.class).where(Condition.column("id").eq(hteam.getTeamColorsId())).querySingle();

//            ActionBar ab = getActivity().getActionBar();
//            if(ab!=null)
//                ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor(tcol1.getPrimaryColor())));

            final String awayColor = tcol1.getPrimaryColor();
            final View homeBar = root.findViewById(R.id.top_bar_spacer_away);
            final String homeColor = tcol2.getPrimaryColor();
            homeBar.setBackgroundColor(Color.parseColor(String.valueOf(awayColor)));

            //get images and set click listeners
            final ImageView homeTeamImage = (ImageView)root.findViewById(R.id.home_image);
            final  ImageView awayTeamImage = (ImageView)root.findViewById(R.id.away_image);

            homeTeamImage.setImageDrawable(d1);
            homeTeamImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 viewAnimator.setDisplayedChild(1);
                    homeBar.setBackgroundColor(Color.parseColor(String.valueOf(homeColor)));
                    root.findViewById(R.id.a_bar).setBackgroundColor(Color.parseColor(homeColor));
                    decorUtil.changeStatusBarColor(getActivity(),Color.parseColor(homeColor));

                }
            });

            awayTeamImage.setImageDrawable(d);
            awayTeamImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewAnimator.setDisplayedChild(0);
                    homeBar.setBackgroundColor(Color.parseColor(String.valueOf(awayColor)));
                    root.findViewById(R.id.a_bar).setBackgroundColor(Color.parseColor(awayColor));
                    decorUtil.changeStatusBarColor(getActivity(), Color.parseColor(awayColor));
                }
            });

            //set up the awayTeam spinners
            NiceSpinner qbSpinnerAway = (NiceSpinner)root.findViewById(R.id.away_qb_spinner);
           // qbSpinnerAway.setTextColor(ColorStateList.createFromXml());
            qbSpinnerAway.setTextColor(Color.parseColor(tcol1.getSecondaryColor()));
            qbSpinnerAway.addOnItemClickListener(new SpinnerItemClickListener());

            NiceSpinner rbSpinnerAway = (NiceSpinner)root.findViewById(R.id.away_rb_spinner);
            NiceSpinner wrSpinnerAway = (NiceSpinner)root.findViewById(R.id.away_wr_spinner);
            NiceSpinner teSpinnerAway = (NiceSpinner)root.findViewById(R.id.away_te_spinner);

            //set up the home team spinners
            NiceSpinner qbSpinnerHome = (NiceSpinner)root.findViewById(R.id.home_qb_spinner);
            //qbSpinnerHome.setTextColor(Color.parseColor(tcol1.getSecondaryColor()));

            NiceSpinner rbSpinnerHome = (NiceSpinner)root.findViewById(R.id.home_rb_spinner);
            NiceSpinner wrSpinnerHome = (NiceSpinner)root.findViewById(R.id.home_wr_spinner);
            NiceSpinner teSpinnerHome = (NiceSpinner)root.findViewById(R.id.home_te_spinner);

            //get position ids for all offensive skilled positions
            Long QbPosId = getPositionByName("QB").getPositionId();
            Long RbPosId = getPositionByName("RB").getPositionId();
            Long WrPosId = getPositionByName("WR").getPositionId();
            Long TePosId = getPositionByName("TE").getPositionId();

            //lists of away players
            List<Player> AwayQuarterbacks = new ArrayList<>();
            List<Player> AwayRunningBacks = new ArrayList<>();
            List<Player> AwayWideReceivers = new ArrayList<>();
            List<Player> AwayTightEnds = new ArrayList<>();


            //lists of home players
            List<Player> HomeQuarterbacks = new ArrayList<>();
            List<Player> HomeRunningBacks = new ArrayList<>();
            List<Player> HomeWideReceivers = new ArrayList<>();
            List<Player> HomeTightEnds = new ArrayList<>();

            //Away Team
            for(int i =0 ; i< ateamPlayerPositions.size(); i++)
            {

                PlayerPosition ppos = ateamPlayerPositions.get(i);
                Long pposId = ppos.getPositionId();
                Player currentPlayer = new Select().from(Player.class).where(Condition.column("id").eq(ppos.getPlayerId())).querySingle();
                if (pposId.equals(QbPosId))
                {
                    AwayQuarterbacks.add(currentPlayer);
                }
                else if (pposId.equals(RbPosId))
                {
                    AwayRunningBacks.add(currentPlayer);
                }
                else if(pposId.equals(WrPosId))
                {
                    AwayWideReceivers.add(currentPlayer);
                }
                else if (pposId.equals(TePosId))
                {
                    AwayTightEnds.add(currentPlayer);
                }
            }
            qbSpinnerAway.attachDataSource(getNames(AwayQuarterbacks));
            qbSpinnerAway.addOnItemClickListener(playerChooserClickListener());

            rbSpinnerAway.attachDataSource(getNames(AwayRunningBacks));
            wrSpinnerAway.attachDataSource(getNames(AwayWideReceivers));
            teSpinnerAway.attachDataSource(getNames(AwayTightEnds));

            //Home Team
            for(int i =0 ; i< hteamPlayerPositions.size(); i++)
            {

                PlayerPosition ppos = hteamPlayerPositions.get(i);
                Long pposId = ppos.getPositionId();
                Player currentPlayer = new Select().from(Player.class).where(Condition.column("id").eq(ppos.getPlayerId())).querySingle();
                if (pposId.equals(QbPosId))
                {
                   HomeQuarterbacks.add(currentPlayer);
                }
                else if (pposId.equals(RbPosId))
                {
                    HomeRunningBacks.add(currentPlayer);
                }
                else if(pposId.equals(WrPosId))
                {
                    HomeWideReceivers.add(currentPlayer);
                }
                else if (pposId.equals(TePosId))
                {
                   HomeTightEnds.add(currentPlayer);
                }
            }
            qbSpinnerHome.attachDataSource(getNames(HomeQuarterbacks));
            rbSpinnerHome.attachDataSource(getNames(HomeRunningBacks));
            wrSpinnerHome.attachDataSource(getNames(HomeWideReceivers));
            teSpinnerHome.attachDataSource(getNames(HomeTightEnds));


            TextDrawable drawable = TextDrawable.builder()
                    .beginConfig()
                    .width(60)  // width in px
                    .height(60) // height in px
                    .endConfig()
                    .buildRect("Qb", Color.parseColor(awayColor));

            ImageView image = (ImageView) root.findViewById(R.id.image_view);
            image.setImageDrawable(drawable);

    } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return root;
    }

    @NonNull
    private AdapterView.OnItemClickListener playerChooserClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        };
    }

    private Position getPositionByName(String name) {
        return new Select().from(Position.class).where(Condition.column("name").eq(name)).querySingle();
    }

    private LinkedList<String> getNames(List<Player> players) {

       java.util.List<String> names = new ArrayList<>();
        for (Player player: players
                ) {
            names.add(player.getName());
        }
        return  new LinkedList<>(names);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CHOOSE_PLAYER) {
            if (resultCode == Activity.RESULT_OK) {
                Player selectedPlayer = data.getParcelableExtra(PlayerChooserActivity.RES_SELECTED_PLAYER);
                playerChooser.setSelectedItem(selectedPlayer);
                return;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private class SpinnerItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    }

    public float dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }
}
