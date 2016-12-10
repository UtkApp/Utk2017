package com.nitj.utkansh.utkansh_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper{

    public MySQLiteHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory,	int version)
    {
        super(context, dbName, factory, version);
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

        society="Fine Arts Club";


        name="Mobile Cover Designing";
        description="In this event, participants have to design their own mobile cover.";
        time="10:00 am - 12:00 pm, Day 1";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);



        name="Dream Catcher";
        description="As the name suggests 'Dream Catcher' catches bad dreams. Dream catchers are one of the most fascinating traditions of Native Americans. The traditional dream catcher was intended to protect the sleeping individual from negative dreams, while letting positive dreams through. The positive dreams would slip through the hole in the center of the dream catcher, and glide down the feathers to the sleeping person below. The negative dreams would get caught up in the web, and expire when the first rays of the sun struck them.\n" +
                "How the Dream Catcher is made:\n" +
                "Using a hoop of willow, and decorating it with findings, bits and pieces of everyday life, (feathers, arrow heads, beads, etc) the dream catcher is believed to have the power to catch all of a person's dreams, trapping the bad ones, and letting only the good dreams pass through the dream catcher.\n";
        time="2:00 pm - 5:00 pm, Day 1";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);


        name="Graffiti";
        description="COME!..THINK!.CREATE\n" +
                "One of the only event of its kind is back again! Yes! It's GRAFFITI time! It's time to splash your imagination and paint your own wall!!";
        time="9:30 am - 12:30 pm, Day 2";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);

        name="Cartoon Sketching";
        description="A fun event where you can relive the memories of your childhood by depicting your idea, your story, your fantasies or anything through a cartoon sketch.";
        time="10:00 am - 12:00 pm, Day 2";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);





        name="Glass Painting";
        description="Decorating glass pieces with glass paints and glitter.\n";
        time="2:00 pm - 5:00 pm, Day 2";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);




        name="Button Art";
        description="Making creative patterns with buttons";
        time="2:00 pm - 5:00 pm, Day 2";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);



        name="Pop-Up Card Making";
        description="Pop-up greeting cards are a great twist on the ordinary greeting card. They are enormously fun (and easy!) to create, and the recipient of your card will be delighted. Now it's time to get creative and to make a pop up card of your own.";
        time="9:30 am - 12:30 pm, Day 3";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);






        name="Canvas Painting";
        description="In this event, participants have to paint a particular area of the college on the canvas.";
        time="All 3 Days";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);


        name="3D Sketching";
        description="Make 3D drawings that appear to jump right off the page through a combination of shading techniques borrowed from airbrushing, flawless perspective, and a few insider techniques (multiple sheets of paper to create more complex images).";
        time="All 3 Days";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);




        society="Movie Club";



        name="Cineaste";
        description="Cineaste is a short film-making competition, the ultimate platform that each artist deserves. Amaze your viewers with your perspective, aesthetic sense, emotion or simple ingenuity of idea. So ignite the director, cinematographer, the sound specialist, the editor or simply an art connoisseur inside you waiting to leap out.";
        time="9:00 am - 11:30 am, Day 1";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);



        name="Mad Ads";
        description="Advertisement making competition for a given theme. MAD Ads is an event for all those who have the ability to cast a spell on viewers. If you have the power of presentation, then welcome to MAD ads, which challenges your imagination to think smart and think new.";
        time="11:00 am - 1:30 pm, Day 2";
        venue="IT Park, Second Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        l = db.insert("EventInfo", null, cv);


        name="Distorcia";
        description="Have you seen Spiderman in Bhojpuri?? Have you seen 'Gaana Wala Song' version of 'Ishq wala love' song from the movie Student of the year?? Are you creative enough to dub a movie clip in your own voice and own dialogues? What are you waiting for then?? Dub a movie clip in your own dialogues and own Voice with creative, innovative and funny ideas and participate the most creative event of Movie Club.";
        time="2:30 pm - 4:00 pm, Day 2";
        venue="IT Park, Second Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        l = db.insert("EventInfo", null, cv);


        name="Shoot at Sight";
        description="Clip of the Fest! The UTKANSH'16 streets, dazzling in bright colors and shimmering lights, full of some of the wackiest characters and wildest personalities, is the perfect setting for a video too! All you need to do is pick your cameras and shoot the Best moments of 'Utkansh' and compile them in a single video.";
        time="2:30 pm - 4:00 pm, Day 3";
        venue="IT Park, Second Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        l = db.insert("EventInfo", null, cv);


        society="Music Club";


        name="Swarag";
        description="The most popular of the musical competitions of UTKANSH, continues to elevate its level. Be it a sweet mesmerizing ghazal or a scintillating bright qawwali; be it folk or filmi; you can showcase your song on our platform. So, unleash the singer within you. Come and gauge your talent with some of the gifted children of mother India.";
        time="12:00 pm - 2:00 pm, Day 3";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);


        society="Photography Club";


        name="Photo-Manipulation";
        description="Participants should make a creative poster, which must consist a camera, lens or anything related to photography. Creative posters will be appreciated.";
        time="2:00 pm - 4:00 pm, Day 1";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);


        name="Photo Treasure Hunt";
        description="Photo creativity with the help of props provided. Some photographs will be provided which will depict places inside campus, at that place props will be provided to participants. Using those props teams will have to create a scene according to props & take photographs.";
        time="11:30 am - 1:30 pm, Day 2";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);


        name="In Campus";
        description="Photograph of anything or anywhere inside campus (only) without any specified theme. Event will be organised online.";
        time=" Day 2";
        venue="Online";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        l = db.insert("EventInfo", null, cv);


        name="Dreamscapes";
        description="One theme (Black & White) is the only theme allowed. One entry per theme will be allowed from an individual. Event will be organised online.";
        time="All 3 Days";
        venue="N/A";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","NIT Jalandhar");
        l = db.insert("EventInfo", null, cv);


        name="Tasveer-Photo Exhibition";
        description="Photo exhibition (proper photo frame display) will be there. Entries will be closed one day before Utkansh. No entries will be entertained after the deadline. Only one entry per participant is allowed.";
        time="All 3 Days";
        venue="IT Park, Ground Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        l = db.insert("EventInfo", null, cv);


        society="Yoga Club";


        name=" Yoga Competition";
        description="The art of Yoga helps in controlling an individual's mind, body, and soul. Tone muscle and cultivate self love with this YOGA flow! Participants would be given at least 2 asana to perform. Judgement will be done on the basis of perfection and the way the participants approaches various Asanas.";
        time="9:30 am - 11:00 am, Day 1\n" + "9:00 am - 10:30 am, Day 2";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);


        society="Dance Club";



        name="Shut Up N Dance";
        description="Cut the Crap...JUST Do IT...Dude!! Can't do it alone? Feeling too shy?? Then better catch a dance partner or form your own dance group.  A group dance competition in which the team comprises of 4 to 15 members who can perform complete western dance/Bollywood dance/Salsa/Tango/Cha-Cha but folk dance is not allowed.";
        time="2:30 pm - 5:00 pm, Day 1";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);


        name="Face Off(Solo)";
        description="Dance, when you're broken open. Dance, if you've torn the bandage off. Dance in the middle of the fighting. Dance in your blood. Dance when you're perfectly free.\n" +
                "Dance to express. This year, we present to you a unique pedestal to showcase your ingenuity and pit yourself against the titans of dance. There will be two rounds.\n" +
                "The individual will be given 3-4 minutes to perform";
        time="10:00 am - 1:00 pm, Day 2";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);


        name="Razzmatazz";
        description="It is said that dancing is like dreaming with your feet. Dancing gives you those moments when you let yourself loose and let the passion from your soul away your body with the rhythm. Utkansh'16 brings together the best dancers under one roof!!Razzmatazz is a choreography competition in which the participant team has to depict a story or theme through synchronized choreography and music.";
        time="1:00 pm - 4:00 pm, Day 2";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);



        name="Folk Nite";
        description="Anything called Folk Art reflects domination! Get ready to witness a ride through all the emotions during Folk Dance at Utkansh'16. The folk dance competition comprises of performances on non-bollywood pure folk songs in a team of maximum 16 members.  Strictly no classical dance steps are allowed.  No fusion of two or more songs is allowed.";
        time="2:00 pm - 5:00 pm, Day 3";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);


        society="Dramatics Club";


        name="Rangmanch(Stage Play)";
        description="An actor's dream to bring the character that he has imagined to do is fulfilled by this form of art, we invite all theatre lovers to live the character they wished to through this medium. Time slot for the play: 25 minutes min and 45 minutes max (from entry to exit). The soft copy of script should be sent to the organizing team before 2nd March to bawretheatrenitj@gmail.com, on the basis of which organizers will select the teams for final event.";
        time="11:30 am - 2:30 pm, Day 1";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);



        name="Mono-Act";
        description="An actor's dream to bring the character that he has imagined to do is fulfilled by this form of art, we invite all theatre lovers to live the character they wished to through this medium. Time slot for the play: 25 minutes min and 45 minutes max (from entry to exit). The soft copy of script should be sent to the organizing team before 2nd March to bawretheatrenitj@gmail.com, on the basis of which organizers will select the teams for final event.";
        time="4:00 pm - 5:30 pm, Day 1";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);


        name="Halla Bol (Street Play)";
        description="With this event we invite young enthusiastic theatre lovers of this DESI ENTERTAINMENT FORM to open up and express their ideas of liberalism and let their voices reach to the ears of system.  The team can have maximum 20 members and the duration of the performance should be minimum 25 minutes and maximum 35 minutes.  The soft copy of script for the Street Play should be sent to the organizers before March 3rd, 2016 to bawretheatrenitj@gmail.com. The final participants will be selected on the basis of the script.";
        time="2:30 pm - 5:30 pm,Day 2";
        venue="In front of ECE building";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","ECE Building");
        l = db.insert("EventInfo", null, cv);





        society="Literary and Debating Club";


        name="Aapka Neta Kaisa Ho?";
        description="Do you want to be the rising leader of the country??\n" +
                "Come! Be the part of the event this Utkansh to fulfill your dreams as LADS provides you the best platform to prove others that you can hold the audience with your words.  Participants will be shortlisted on the basis of a form filled by them containing a political situation. This form will be made available as and when you register for the event. In the next round, every participant will be given a topic on the spot on which he/she has to speak for 2-2.5 minutes. \n" ;
        time="1:30 am - 4:30 pm, Day 1";
        venue="IT Park Ground Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        l = db.insert("EventInfo", null, cv);


        name="Wee Weensy Tales";
        description="There would have been several stories and books that would have flashed in front of you. Lads presents to you WEE WEENSY TALES to bring all sorts of fantastic writers to create a tweet sized tale that delivers your thought effectively to the audience.  A word will be given to all the participants on which each of them will have to submit a tale of 4 to 5 sentences in a maximum of 30 minutes" ;
        time="2:00 pm - 4:00 pm, Day 1";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("soci" +
                "ety" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
        l = db.insert("EventInfo", null, cv);


        name="La Persona";
        description="LAD club on this UTKANSH presents LA PERSONA that entitles the winners of the event as Mr. and Ms.Utkansh . The event will be conducted on all 3 days of the fest having one round each day. The rounds will be on the spot and will test the confidence, personality, team work and overall skills of the participants. Each round will be knockout. ";
        time="Round 1: 10:00 am - 11:30 am , Day 1" + "\n" +  "Round 2: 10:00 am - 1:00 pm , Day 2\n" + "Round 3: 9:30 am - 12:00 pm , Day 3";
        venue="Day 1 : IT Park \n" + "Day 2 : IT Park\n" + "Day 3 : CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Special");
        l = db.insert("EventInfo", null, cv);


        name="Youth Parliament";
        description="In this one of a kind debating event, the speaker must consecutively propose and oppose the same motion to the best of his/her capabilities. This event challenges the mettle of a true debator, by testing his ability to defend a motion, and then, at the drop of a hat, bash it to death\n" +
                "Round 1: Group Discussion (Elimination round) \n" +
                "\n" +
                "Round 2: Parliamentary Debate \n";
        time="Round 1: 02:30 pm - 5:30 pm , Day 1\n" + "Round 2: 2:00 pm - 5:00 pm, Day 2 ";
        venue="Day 1 : SC-06 1\n" + "Day 2 : LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Special");
        l = db.insert("EventInfo", null, cv);


        name="I am a Grammarian";
        description="LAD club presents you an opportunity to structurally find an ability to express yourself and be more aware of how it works. There shall be preliminary and final rounds. The preliminary round will be written aptitude based on vacbulary and grammar. The final round is a three laps event comprising 5 teams with 4 members each.";
        time="Round 1: 2:00 pm - 5:00 pm, Day 2\n" + "Round 2: 02:00 am - 5:00 pm, Day 3";
        venue="IT Park, Ground Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        l = db.insert("EventInfo", null, cv);


        name="Poetry";
        description="This UTKANSH, let go of reality and escape to a surreal world. A picture will be shown to the participants upon which they will have to write a self-composed poem at-the-spot." +
                "\n" ;
        time="9:30 am - 12:00 pm, Day 3";
        venue="IT Park, Ground Floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");
        l = db.insert("EventInfo", null, cv);



        society="Rajbhasa Samiti";


        name="Filmy Sangram";
        description="Test your knowledge about Hindi movies in a team of 2-3. This competition will consist of four rounds. Questions would be related to dialogues and riddles of hindi movies.";
        time="10:00 am - 12:00 pm, Day 1";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");

        l = db.insert("EventInfo", null, cv);


        name="Bharat Darshan";
        description="This competition will consist of 3 rounds and you can participate in a team of 2";
        time="2:00 pm - 5:00 pm, Day 1";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");

        l = db.insert("EventInfo", null, cv);


        name="Jasoosi nighahe";
        description="Do you think you have those detective like capabilities of James Bond or Sherlock Holmes? Then we have something for your group of 2-3 people. Exciting rounds awaiting";
        time="10:00 am - 1:00 pm, Day 2";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");

        l = db.insert("EventInfo", null, cv);


        name="Kavya kala";
        description="It is a solo competition. First round consists of sel composed poem recitation. Second round will test your word formation skills. Third round to be revealed during contest.(Performances are allowed in Hindi only)";
        time="2:00 pm - 5:00 pm, Day 2";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");

        l = db.insert("EventInfo", null, cv);





        name="Pragyansh";
        description="An exciting mix of testing your mental abilities and hindi vocabulary. Group contest where in the first round you will form some English words from given letters and translate them to Hindi. Orther rounds to be revealed later.";
        time="10:00 am - 1:00 pm, Day 3";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");

        l = db.insert("EventInfo", null, cv);


        name="Vaad Vivad ";
        description="First round will consist of debate over a given subject. Second debate round will conduct a debate on an issue topic. In third round, each partipant would be required to speak for 1 minute on a given problem";
        time="2:00 pm - 5:00 pm, Day 3";
        venue="IT Park, First floor";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","IT Park");

        l = db.insert("EventInfo", null,cv);


        society = "Others";
        description="";


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
        l = db.insert("EventInfo", null, cv);

        name="Roadies";
        time="12:30 pm - 4:00 pm, Day 1\n"+"11:00 am - 4:00 pm, Day 2";
        venue="In front of OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);

        name="Beg Borrow Steal";
        time="11:00 am - 1:00 pm, Day 1\n"+"11:00 am - 1:00 pm, Day 2";
        venue="In front of OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);

        name="Street Soccer";
        time="9:00 am - 5:00 pm, All 3 days";
        venue="Near Main Ground";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Main Ground");
        l = db.insert("EventInfo", null, cv);

        name="Turban Tying";
        time="11:00 am - 12:30 pm, Day 2";
        venue="LTC";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","LTC");
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
        l = db.insert("EventInfo", null, cv);

        name="Prom Eve";
        time="4:00 pm - 6:00 pm";
        venue="Community Center";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","Community Center");
        l = db.insert("EventInfo", null, cv);


        society="Attractions";


        name="Grand Opening Ceremony";
        time="6:00 pm - 9:00 pm, Day 0";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);


        name="Hasya Kavi Sammelan";
        time="5:30 pm - 8:30 pm, Day 1";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
        l = db.insert("EventInfo", null, cv);


        name="Mega Sonic - Battle Of Bands";
        time="7:30 pm - 11:00 pm, Day 1";
        venue="OAT";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","OAT");
        l = db.insert("EventInfo", null, cv);



        name="Panache - Fashion Show";
        time="5:30 pm - 8:30 pm, Day 2";
        venue="CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
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
        l = db.insert("EventInfo", null, cv);


        name="Gatka";
        time="3:00 pm - 4:00 pm, Day 3";
        venue="Outside CSH";
        cv = new ContentValues();
        cv.put("name" , name);
        cv.put("society" , society);
        cv.put("description" , description);
        cv.put("time" , time);
        cv.put("venue" , venue);
        cv.put("location","CSH");
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
        l = db.insert("EventInfo", null, cv);




        name="Closing Ceremony";
        time="5:30 pm - 8:00 pm, Day 3";
        venue="CSH";
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
