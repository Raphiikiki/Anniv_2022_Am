package com.example.anniv_2022_am.guiFragments.game.seedquestions;

import android.content.Context;
import android.util.Pair;

import com.example.anniv_2022_am.guiFragments.GameView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeedQuestions extends GameView {

    private static final List<Pair<String, Pair<String[], String[]>>> questions = new ArrayList<Pair<String, Pair<String[], String[]>>>() {{
        add(new Pair<>("0. Durant le parcours répondez aux questions suivantes.", new Pair<>(
                new String[]{"OK"},
                new String[0]
        )));
        add(new Pair<>("1.1 Allez directement au boss, quel est l'objet?",  new Pair<>(
                new String[]{"Synthoil"},
                new String[]{"Roid Rage", "Growth Hormones", "Experimental Treatment"}
        )));
        add(new Pair<>("1.2 Quel est l'objet d'item room?",  new Pair<>(
                new String[]{"Cancer"},
                new String[]{"Taurus", "Leo", "Sagitarius"}
        )));
        add(new Pair<>("1.3 Passez dans la curse room.",  new Pair<>(
                new String[]{"2 coeurs noir"},
                new String[]{"4 arraignés", "Brimstone", "TP Devil Deal"}
        )));
        add(new Pair<>("1.4 Changez d'étage.",  new Pair<>(
                new String[]{"OK"},
                new String[0]
        )));
        add(new Pair<>("2.1 Trouvez l'item room.",  new Pair<>(
                new String[]{"Camo Undies"},
                new String[]{"Knockout Drops", "Bird Cage", "Bird's Eye"}
        )));
        add(new Pair<>("2.2 Battez le boss.",  new Pair<>(
                new String[]{"Crack Jacks"},
                new String[]{"Placenta", "Consolation Prize", "Glass Eye"}
        )));
        add(new Pair<>("2.3 Quel est le devil dead? Prenez le.",  new Pair<>(
                new String[]{"Dark Bum"},
                new String[]{"Dead Cat", "Money = Power", "The Nail"}
        )));
        add(new Pair<>("2.4 Changez d'étage.",  new Pair<>(
                new String[]{"Ok"},
                new String[0]
        )));
        add(new Pair<>("3.1 Quel est l'item?",  new Pair<>(
                new String[]{"Continuum"},
                new String[]{"Blood Of The Martyr", "Technology 2", "Best Friend"}
        )));
        add(new Pair<>("3.2 Battez le boss.",  new Pair<>(
                new String[]{"Booster Pack"},
                new String[]{"Eye Drops", "A Bar Of Soap", "Little Gish"}
        )));
        add(new Pair<>("3.3 Utilisez le Joker et prenez l'objet.",  new Pair<>(
                new String[]{"The Book Of Belial"},
                new String[]{"The Necronomicon", "A Quarter", "Lord Of The Pit"}
        )));
        add(new Pair<>("3.4 Changez d'étage.",  new Pair<>(
                new String[]{"Ok"},
                new String[0]
        )));
        add(new Pair<>("4.1 Chercher l'item room.",  new Pair<>(
                new String[]{"Dry Baby"},
                new String[]{"Stigmata", "Ipecac", "The Bean"}
        )));
        add(new Pair<>("4.2 Terminez le boss.",  new Pair<>(
                new String[]{"Wooden Spun"},
                new String[]{"The Halo", "Butt Bombs", "A Pony"}
        )));
        add(new Pair<>("4.3 Quel transformation pouvez-vous faire. Faites la.",  new Pair<>(
                new String[]{"Conjoined"},
                new String[]{"Leviathan", "Bookworm", "Guppy"}
        )));
        add(new Pair<>("4.4 Changez d'étage.",  new Pair<>(
                new String[]{"Ok"},
                new String[0]
        )));
        add(new Pair<>("5.1 Fouiller l'item room.",  new Pair<>(
                new String[]{"Strange Attractor"},
                new String[]{"Big Fan", "Infamy", "Soy Milk"}
        )));
        add(new Pair<>("5.2 Battre l'avant dernier boss.",  new Pair<>(
                new String[]{"A Snack"},
                new String[]{"Midnight Snack", "Breakfast", "Rotten Meat"}
        )));
        add(new Pair<>("5.3 Sautez.",  new Pair<>(
                new String[]{"Ok"},
                new String[0]
        )));
        add(new Pair<>("6.1̸̯͈̅̏͋ T̷̬̄r̶͓̆o̸͕̐u̴̪͑v̴̫͐ḙ̴́r̸̟͌ ̷̝͠v̵̮͛o̵̼͗t̶̖͌r̶͔̍ë̸̲ ̸͕̍ỏ̵ͅb̸̟̍j̴̢̍e̴̤̓ẗ̷̮́.",  new Pair<>(
                new String[]{"È̴͙ ̴̤̓C̶̈͜o̶̰̊l̷̩͛y̷̻̐"},
                new String[]{"M̵̢̧̰̻͕̼̊͌͂a̶̭̦͕̲̍̂͝g̷͔̤̅́͋ȋ̵̻̞̔̓c̶̳͂͜͝ ̶̻̆̂̉M̴͉̍̈́ú̵̢͔͍̲͇͌̓̚͠s̵̖̝̮̣̆̈͜h̴͍̬̥̽͜r̵̯͖͎̘̪̬̓̋̽͠o̵̜̬̎̌̎̿̔͝ͅo̵͕͊͂͛m̸̱̥̯̜̊̾͜", "L̴̨̢͎̭͔͓̝̘̗̹̥̜̯̻̉͊̓͛͘͝͝͠ͅe̴͈̩̘̳̱̞̪̋́̈́͋̍͂͘͠v̵̗̰̘̥͇͙͙̭̬͖̫̰̫͇̒̊͂̀͛͂̋͒̆̈́͛̈́̅̆̈́̍͜͜͝ͅi̷̡̫̟̥̱̮̼̍̈͊͠a̸̯̺̯̖͙̮̽̓̅̀̃̑͗̿͂̀͋̎͘̚͠ͅţ̴̨͍̹̗̹͚̤̮̤̣̠̆̾́̓̽͋͂̄̚͜͠ͅh̸̥̬̬̓̐͒ǎ̴̧͍̠̪̞͔͈̠̟̘͉̜̱̲͇̙͌͌͂́̽̋̈́̒̚n̸̨̡̲͕̝̗̮̥̞̮̪̳͈̤̭͉̈́̂̈́̌̐͆̉͛̓̾̌́͑̅̋̐", "?̸̰͙̱͇̝̗͚̲̏͂?̶͓͑̓̂̐?̸̡͕͚̰̟̮̿͆͑?̷̹̝͖̥͆̀̃̈́́̍̄̚͝?̶̪̖͚̘͒̅́̌"}
        )));
        add(new Pair<>("6̸̩̪͉͇̩͓̥̉̀̋̆͐͆̚͠͠͠.̶̪̄̊2̸̨̛̘̥̬̙̜̯̺̝͂̂̓̃͗̆̚͜ͅ ̷̨̜͓̝͚̣̣̊̄̀̀Ḃ̷̼͙̘̰̩̀̃ą̸̱͔̐̌̃̒̓́̿̊̚͝ͅt̷̘̳͊́̓͆̋͗͛̒̉̈́̕t̸͕͕̘͆̀̏̐̏̋́̑̚ȩ̶̡͖̭͎͙͇̊̓͊̍̒̕z̸̨̨̮̥͎̭̽̊̈́̈́̃̽̇͆̕ ̷̧̢̛͎͇̹̭̟̫̜̩͚̾́̃̔͆M̵̡̹͇̤̀͝ạ̵̙̫̟̳͇͓͇̲͕̥̀̇́̔̋͐͒͠ͅm̷̼̝̳̖̻͓̈́̈́͒̅͂͋͝a̸̡̨̭̮͕̮̞̻̗̞̟͒̑͛̈́̿̃̇̕ͅn̵̡͚̓̽.̷̹̞͎͇̻͕̩̬̭̮̯̙̄̏́",  new Pair<>(
                new String[]{"EƠ̴̙̍͜k̶͓̩̂͋̌̋͌̌͛y̷̻̐"},
                new String[0]
        )));
        add(new Pair<>("?̵̧̠͍̺͓̝̔̏͂͜p̶͚͖̝͛̃ê̸͕̔̂͒̌ź̷̬̥̻̜͉̪̫̓͌̐̈́́̅͜k̸̢̋̆̐̃̓f̶̫͋͋̏́̏̂̈́͌̈̚S̵̨̛̹̰̪̦̥̝͓̰̋͌͋͋̐̒͐̚̚s̹̞͎͇̻͕̩̬̭̮̯̙̏́ Demon 666mom b̵̧͙̦̐̈͆̾͌r̶̙̈́͑̀á̷̡̡͚̖̻̖̝͌̊̑̽̌̄̀͜v̷̺̯̖̋́̀͒͛͒̒͑̐̊̎̓̅͠͠o̸̡̡̨͔̠̼̻̱̲͔͈̦̤͉͍̺͎͆̈́̃͆̔͌̐̓̐̓̓͗̄̀̚͘͘͘͜͠.̴͚͎̳̈́̐́̊̓́͗͊ͅ.̶̛̜̖̞̼̰̙̮͚͕͚̲̹̩̺̻̱̖̾̓͑͐̕ͅ.̶̧̢̢̛̬̜͔̹̪̱̖̪̠̪̯̯̺̠́̎̊̌̌̃̀̇͆̓͐͝͝͝͝",  new Pair<>(
                new String[]{"EƠ̴̙̍͜k̶͓̩̂͋̌̋͌̌͛y̷̻̐"},
                new String[0]
        )));
        add(new Pair<>("Félicitation.", new Pair<>(new String[0], new String[]{"Recommencer"})));
    }};

    public SeedQuestions(Context context) {
        super(context);
    }

    @Override
    public void init(int height, int width) {
        super.gameEngine = new SeedQuestionsEngine(height, width, questions);
    }
}
