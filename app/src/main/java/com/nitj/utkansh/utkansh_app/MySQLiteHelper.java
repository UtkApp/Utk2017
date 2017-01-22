package com.nitj.utkansh.utkansh_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.ContextCompat;

public class MySQLiteHelper extends SQLiteOpenHelper{

    Context cntx;
    public MySQLiteHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory,	int version)
    {
        super(context, dbName, factory, version);
        cntx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        com.nitj.utkansh.utkansh_app.EventInfo.onCreate(db);
        insertRecords(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        com.nitj.utkansh.utkansh_app.EventInfo.onUpdate(db, oldVersion, newVersion);
        insertRecords(db);
    }

    public void insertRecords(SQLiteDatabase db)
    {
        String name,society,description,time,venue = "";
        long l;
        ContentValues cv;
        /***********FAC***********/

        society="Fine Arts Club";
        int img=R.drawable.fine_arts_club,img1;

        name="CHARCOAL ART";
        description="Charcoal art is a form of dry medium art. Charcoal provides a rough texture and thousands of different strokes to your drawing.";
        time="Day 1,2 and 3";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="CANVAS PAINTING";
        description="Participants will be provided with 3 canvases . they have to paint these 3 canvases such that when put together ,they form a whole painting split in 3 parts.";
        time="Day 1,2 and 3";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="MANDALA PAINTING";
        description="A mandala is a complex abstract design that is usually circular in form. Mandalas can contain both geometric and organic forms. They can also contain recognizable images that carry meaning for the person who is creating it.\n" +
                "\n" +
                "In essence, mandalas represent the connection between our inner worlds and outer reality. Designing your own mandalas can be both inspirational and therapeutic.\n";
        time="n/a";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="TU KHEECH MERI PHOTO";
        description="There will be 1 round in the event.\n" +
                "\n" +
                "You will be provided with sheets and the required material like pencils, eraser, scissors, etc to make a creative photo prop.\n";
        time="N.A";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="HAVAA HAVAII";
        description="It will be a single round event.\n" +
                "\n" +
                "The teams will be provided with Japanese fans.\n" +
                "\n" +
                "They will be provided with decorating materials like colours, laces etc.\n" +
                "\n" +
                "Within the given time they have to decorate the fans using their own creativity\n";
        time="n/a";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="ILLUSTRATION ART";
        description="Visualize your imagination and ideas in form of expressive portrait or paintings to convey certain social issue or certain information.";
        time="n/a";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="CARVING CRAFT";
        description="Draw and carve your imagination on a piece of paper to make it more lively and expressive.";
        time="n/a";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="SPRAY IT OUT";
        description="The Participants will be provided with a story related to the theme and they need to complete the story using the graffiti technique.\n" +
                "\n" +
                "Best Three will be awarded.\n" ;

        time="n/a";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="ANDE KA FANDA";
        description="The participants will be provided with the egg trays or egg shells as per their choice.\n" +
                "\n" +
                "The need to paint the given material and decorate it\n" +
                "\n" +
                "The best three will be awarded\n";
        time="n/a";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="DESIGN-O-COMIC ";
        description="There will be 1 round in the event\n" +
                "\n" +
                "You will be provided a sheet and the required material (pencil, eraser, colors) to depict a comic story. You can create your own story or use any existing comic story.\n";
        time="Day 1,2 and 3";
        venue="n/a";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="WOOD ART";
        description="There will be 1 round in the event\n" +
                "\n" +
                "You will be provided a wooden sheet and metallic colors and you will have to paint it and show your innovation.\n";
        time="n/a";
        venue="LTC or OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

/*****************Movie Club****************/

        society="Movie Club";
        img=R.drawable.movie_club;


        name="Cineaste";
        description="Let your imagination and creativity fly and achieve new heights with this movie-making event. Here is the great opportunity to get rewarded for your passion of movie. \n" +
                "  There are several round of movie quiz during the event, audience are also invited and can win goodies in quiz round.\n";
        time="Day 1";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);



        name="Mad-Ads";
        description="";
        time="11:00 am - 1:30 pm, Day 2";
        venue="IT Park, Second Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="ROFL -Just for laugh ";
        description= "Make a funny video by watching which viewers get Rolling on Floor\n" +
                "Laughing. Include the dialogues in your video, make it funnier along with pooling in your idea in order to increase the odds of you winning the prize. i.e. 羨a gaye meri maut ka tamasha dekhne・ 腺abumoshai, zindagi badi honi chahiye, lambi nahin!・・tc.\n";
        time="Day 2";
        venue="IT Park, Second Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Final-Cut";
        description="How many times you have watched a song and felt like words don't match the video? We often plug our earphones and start thinking about al the funny choreographies and scenes that go in our mind. And If we have not seen the video before, the imagination become really brilliant. This year, Movie Club has brought an event for all the creative mind sout there, finalcut, where we are giving you a pool of songs to pick from and make a video on it. So, buckle up people, make your team, let your imagination fly and be a cinematographer of new era and grab large cash prizes.";        time="2:30 pm - 4:00 pm, Day 3";
        venue="IT Park, Second Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


/********Music Club********/

        society="Music Club";
        img = R.drawable.music_club;

        name="MEGASONIC (Battle of Bands)";
        description="Megasonic  is Band competition where Bands will compete with each other to be Best Band of Utkansh 2016 and win the ultimate prize.";
        time="Day 1";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="Swaraag";
        description="Swaraag is a singing competition where contestants will be given a platform to showcase their singing skills to be Best Singer of Utkansh 2016.";
        time="Day 3";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


/*********************Photography Club**************/

        society="Photography Club";
        img = R.drawable.photography_club;


        name="Photo-Manipulation";
        description="1.\tThis is an online Event\n" +
                "\n" +
                "2.\tAfter registration, a photo which is to be manipulated will be sent via email 1 day before UTKANSH\n";
        time="Day 1";
        venue="Online";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Photo Treasure Hunt";
        description="Photo creativity with the help of props provided. Some photographs will be provided which will depict places inside campus, at that place props will be provided to participants. Using those props teams will have to create a scene according to props & take photographs.";
        time="Day 2";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Photo Walk";
        description="Photograph of anything or anywhere inside campus (only) without any specified theme. Event will be organised online.";
        time=" Day 2";
        venue="n/a";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Dreamscapes";
        description="1.\tThis is a theme based online event.\n" +
                "\n" +
                "2.\tPhotos must be in accordance with the theme only\n" +
                "\n" +
                "3.\tEach person can send two entries but each theme can have only one entry\n";
        time="All 3 Days";
        venue="Online";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Tasveer-Photo Exhibition";
        description="Photo exhibition (proper photo frame display) will be there. Only one entry per participant is allowed.";
        time="All 3 Days";
        venue="IT Park, Ground Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


/**********************Quest**************************/

        society="Quest";
        img = R.drawable.quest;

        name="SPORTS QUIZ";
        description="Sports quiz is a quiz about sports, games, players, athletes, awards etc. If you think you are good at all these things, this quiz is a heaven for you. So, use your knowledge and logics and win this quiz.";
        time="n/a";
        venue="n/a";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="GENERAL QUIZ";
        description="General quiz will have questions from history, geography, science, movies, sports etc. If you have a knack about general knowledge, then play this quiz and win cash prizes.";
        time="n/a";
        venue="n/a";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="MELA QUIZ";
        description="This topic will have questions from Music, Entertainment, Literature and Arts. Use all your knowledge here and win this quiz.";
        time="n/a";
        venue="n/a";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


/**************************Dance Club*************************/

        society="Dance Club";
        img=R.drawable.dance_club;


        name="GROUP DANCE";
        description="If you can dance in storm, don't wait for rain to be over before it might be too late. We are seeking for connection that goes beyond words and intellectual." +
                " You can do it now, if your dance crew have the zeal for it and you are good enough to rip off the stage, then SPARK your talent right now.";
        venue="CSH";
        img1=R.drawable.dance_club2;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);


        name="SOLO FACE-OFF";
        description="Have you ever had the desire to express the hidden language of your soul," +
                " make the music visible and simply be insane? We'll provide you the level field to be fearless and limitless." +
                " Dance to the beat of your own drum; don't let anyone tell you it can't be done." +
                " The solo-face off competition, it痴 about passion for your own style of dancing, showcasing your own crazy moves.   ";
        time="Day 2";
        venue="CSH";
        img1=R.drawable.dance_club1;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);


        name="THEMATIC  DANCE COMPETITION";
        description="Let your steps be the lyrics to the music.. Let your face express every emotion..let your soul dance to the music of life.\n" +
                "With step up,you with your troop have the chance to be more than what you already are, be a revolution and put it all in one performance to be the best out of the lot!\n";
        time="Day 2";
        venue="CSH";
        img1=R.drawable.dance_club3;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);



        name="FOLK LORE";
        description="One of the main events of Utkansh. Folk Night is the event which brings participation in the form of folk dances." +
                " The folk of our regions bring us close to our roots," +
                " and give us the feeling of belongingness and identity.";
        time="Day 3";
        venue="CSH";
        img1=R.drawable.folk_lore;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);

        name="DANCING DUO";
        description="Let yourself free and come up with your partner and arm yourself with all the moves you have." +
                "  Prove it to the world that you are a real dancing doublet (irrespective of gender) and can rip off the stage in a way none else can.";
        time="Day 2 or 3";
        venue="CSH";
        img1=R.drawable.dancing_duo;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);


/**************************Dramatics Club*******************/

        society="Dramatics Club";
        img = R.drawable.dramatics_club;

        name="Rangmanch(Stage Play)";
        description="A stage space has two rules: \n" +
                "(1) Anything can happen and (2) Something must happen.\"\n" +
                "- Peter Brook \n";
        time="Day 1";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);



        name="Mono-Act";
        description="Make them laugh, make them cry, and back to laughter. What do people go to the theatre for?" ;
        time="Day 1";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="AD-DUM";
        description="A stage space has two rules: \n" +
                "(1) Anything can happen and (2) Something must happen.\"\n" +
                "- Peter Brook \n" +
                "The stage awaits for the real life magicians, the followers of art to create magic. \n";
        time="n/a";
        venue="n/a";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Halla Bol (Street Play)";
        description="If you were born with the ability to change someone痴 perspective or emotions, never waste that gift. It is one of the most powerful gifts God can give葉he ability to influence."
                +"-Shannon L. Alder"+
                "Come forward; let the streets be your stage and the common man -your audience."+
                "Come forward; be the change";

        time="Day 2";
        venue="In front of ECE building";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","ECE Building");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);




/**********************Literary and Debating Club**************************/


        society="Literary and Debating Club";
        img=R.drawable.literary_and_debating_club;


        name="TURN THE COAT";
        description="A turncoat is a person who shifts allegiance from one loyalty or ideal to another, betraying or deserting an original cause by switching to the opposing side or party.\n" +
                "So to win the event, u have to be the best turncoat!\n";
        time="n/a";
        venue="IT Park";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="WE WEENSY TALES\n";
        description="Fairy tales. Fiction and Non-Fiction. Fables. Adventure. Success. Funny. History. Mysteries. Science. Sports. Scary and all kinds of stories. We are sure there would have been several stories and books that would have flashed in front of you. LADC presents to you Wee Weensy tales to bring all sorts of fantastic writers to create a tweet sized tale that delivers your thought effectively to the audience.";
        time="Day 1";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="La Persona";
        description="La persona, organized by literary and debating club, is the most interesting mega event of Utkansh. The event, which includes various rounds of meticulously designed activities to judge various aspects of the participants' personality viz confidence, team-spirit, conscientiousness and talent ensures an extremely wonderful experience. The winners will honoured with the titles of Mr and Miss Utkansh.";
        time="Day 1" +  "Day 2"+ "Day 3";
        venue="IT Park or CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Special");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Youth Parliament";
        description="For good ideas and true innovation, you need human interaction, conflict, argument, debate.\"\n" +
                "LADC presents it's mega event for Utkansh'17 where we celebrate our diversities, debate the differences, enlighten ourselves and provide solutions to the current problems that the world is facing in this British Parliamentary debate style event, YOUTH PARLIAMENT.\n";
        time="Day 1 and Day 2 ";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Special");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="I am a Grammarian";
        description="According to Urbandictionary.com, Grammar is something that's never used anymore, because people nowadays are stupid・ Do you think you have it in you to prove this newly generalized definition wrong? Do you think you are the next-gen Grammar Nazi?\n" +
                "LADC presents I'm a Grammarian, an event that gives you an opportunity to show off your grammar skills.\n";
        time="Day 1,2 and 3";
        venue="IT Park or Ground Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="POESIA";
        description="Do you find yourself mesmerized by the works of Wordsworth, Shakespeare, Browning and the likes? Do rhyme schemes and couplets come as naturally to you as blinking? Are you always on the lookout for opportunities to showcase your poetic genius? Then here's your chance...\n" +
                "LADC presents Poesia, an on-the-spot poem writing and recital competition.\n" +
                "\n" +
                "A picture will be shown to the participants upon which they will have to write a self-composed poem at-the-spot.\n";

        time="Day 3";
        venue="IT Park, Ground Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);



/******************Rajbhasa Samiti**********************/

        society="Rajbhasa Samiti";
        img=R.drawable.rajbhasa_samiti;


        name="FILMY SANGRAM";
        description="Test your knowledge about Hindi movies in a team of 2-3. This competition will consist of four rounds. Questions would be related to dialogues and riddles of hindi movies.";
        time="Day 1";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);

        l = db.insert("EventInfo", null, cv);


        name="FIR BHI DIL HAI HINDUSTAANI";
        description="This competition will consist of 3 rounds and you can participate in a team of 2";
        time="Day 1";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);

        l = db.insert("EventInfo", null, cv);


        name="JASOOSI NIGAHE";
        description="Do you think you have those detective like capabilities of James Bond or Sherlock Holmes? Then we have something for your group of 2-3 people. Exciting rounds awaiting";
        time="Day 2";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);

        l = db.insert("EventInfo", null, cv);


        name="KAVYA RACHNA";
        description="It is a solo competition. First round consists of sel composed poem recitation. Second round will test your word formation skills. Third round to be revealed during contest.(Performances are allowed in Hindi only)";
        time="Day 2";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);

        l = db.insert("EventInfo", null, cv);





        name="PRAGYANSH";
        description="An exciting mix of testing your mental abilities and hindi vocabulary. Group contest where in the first round you will form some English words from given letters and translate them to Hindi. Orther rounds to be revealed later.";
        time="Day 3";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);

        l = db.insert("EventInfo", null, cv);


        name="VAAD VIVAAD";
        description="First round will consist of debate over a given subject. Second debate round will conduct a debate on an issue topic. In third round, each partipant would be required to speak for 1 minute on a given problem";
        time="Day 3";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);

        l = db.insert("EventInfo", null,cv);


        society = "Others";
        description="";
        img=R.drawable.attractions;


        name="Campus Connect";
        venue="NIT Jalandhar";
        time="All Day";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="Roadies";
        time="Day 1 and Day 2";
        venue="In front of OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="Beg Borrow Steal";
        time="Day 1 and Day 2";
        venue="In front of OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);

        name="Street Soccer";
        time="All 3 days";
        venue="Near Main Ground";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Main Ground");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);



        name="All Day DJ";
        time="All Day";
        venue="NIT Jalandhar";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);



        society="Attractions";


        name="Grand Opening Ceremony";
        time="6:00 pm - 9:00 pm, Day 0";
        venue="CSH";
        img1=R.drawable.others ;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);


        name="Hasya Kavi Sammelan";
        time="Day 1";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Mega Sonic - Battle Of Bands";
        time="7:30 pm - 11:00 pm, Day 1";
        venue="OAT";
        img1=R.drawable.megasonic;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);



        name="Panache - Fashion Show";
        time="5:30 pm - 8:30 pm, Day 2";
        venue="CSH";
        img1=R.drawable.panache ;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        //cv.put("img",img1);
        l = db.insert("EventInfo", null, cv);



        name="Sufi Night";
        time="8:30 pm - 10:30 pm, Day 2";
        venue="Main Ground";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Main Ground");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Art Exhibitions";
        venue="IT Park , Ground Floor";
        cv = new ContentValues();
        time="All 3 Days";
        venue="IT Park";
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);



        name="Star Night";
        time="8:00 pm - 11:00 pm, Day 3";
        venue="Main Ground";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Main Ground");
        //cv.put("img",img);
        l = db.insert("EventInfo", null, cv);


        name="Closing Ceremony";
        time="5:30 pm - 8:00 pm, Day 3";
        venue="CSH";
        img1=R.drawable.others;
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);

    }

}

