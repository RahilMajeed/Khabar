package com.snapp.khabar.feature_fetch_news.presentation.ui.home.fragments.home_fragment.fragments.all_news.adapters

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsModel(
    val heading : String,
    val description : String,
    val time : String,
    val imageUrl : String

): Parcelable


fun getDummyNewsList() =
    listOf(
        NewsModel(
            "School Holidays",
            "In this poem, Robert Frost uses the act of planting a seed as a metaphor for creating life and giving birth.\n" +
                    "\n" +
                    "You come to fetch me from my work to-night\n" +
                    "When supper’s on the table, and we’ll see\n" +
                    "If I can leave off burying the white\n" +
                    "Soft petals fallen from the apple tree.\n" +
                    "(Soft petals, yes, but not so barren quite,\n" +
                    "Mingled with these, smooth bean and wrinkled pea;)\n" +
                    "And go along with you ere you lose sight\n" +
                    "Of what you came for and become like me,\n" +
                    "Slave to a springtime passion for the earth.\n" +
                    "How Love burns through the Putting in the Seed\n" +
                    "On through the watching for that early birth\n" +
                    "When, just as the soil tarnishes with weed,\n" +
                    "The sturdy seedling with arched body comes\n" +
                    "Shouldering its way and shedding the earth crumbs.",
            "12 hours ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),

        NewsModel(
            "Breaking News",
            "In this poem, Robert Frost uses the act of planting a seed as a metaphor for creating life and giving birth.\n" +
                    "\n" +
                    "You come to fetch me from my work to-night\n" +
                    "When supper’s on the table, and we’ll see\n" +
                    "If I can leave off burying the white\n" +
                    "Soft petals fallen from the apple tree.\n" +
                    "(Soft petals, yes, but not so barren quite,\n" +
                    "Mingled with these, smooth bean and wrinkled pea;)\n" +
                    "And go along with you ere you lose sight\n" +
                    "Of what you came for and become like me,\n" +
                    "Slave to a springtime passion for the earth.\n" +
                    "How Love burns through the Putting in the Seed\n" +
                    "On through the watching for that early birth\n" +
                    "When, just as the soil tarnishes with weed,\n" +
                    "The sturdy seedling with arched body comes\n" +
                    "Shouldering its way and shedding the earth crumbs.",
            "1 hour ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),
        NewsModel(
            "Bank Robbery",
            "Zara Si dil mein de jagah tu\n" +
                    "zara sa apna le bana\n" +
                    "Zara sa khawbon mein saja tu\n" +
                    "Zara sa yaadhon mein basa\n" +
                    "\n" +
                    "Mein chahun tujhko\n" +
                    "Meri jaan bepaanah\n" +
                    "Fida hoon tujhpe\n" +
                    "Meri jaan bepaanaha\n" +
                    "\n" +
                    "wooow O oo O O\n" +
                    "\n" +
                    "Zara Si dil mein de jagah tu\n" +
                    "zara sa apna le bana\n" +
                    "Zara sa khawbon mein saja tu\n" +
                    "Zara sa yaadhon mein basa\n" +
                    "\n" +
                    "Mein tere mein tere\n" +
                    "Kadmon mein rakh du yeh jahan\n" +
                    "for More LyricsMasti.Com\n" +
                    "Mera ishq deewangi\n" +
                    "\n" +
                    "Hai nahi hai nahi\n" +
                    "Ashiq koi mujhsa tera\n" +
                    "Tu mere liye bandagi\n" +
                    "\n" +
                    "Mein chahun tujhko\n" +
                    "Meri jaan bepaanah\n" +
                    "Fida hoon tujhpe\n" +
                    "Meri jaan bepaanaha\n" +
                    "\n" +
                    "Zara Si dil mein de jagah tu\n" +
                    "zara sa apna le bana\n" +
                    "Zara sa khawbon mein saja tu\n" +
                    "Zara sa yaadhon mein basa\n" +
                    "\n" +
                    "Keh bhi di keh bhi de\n" +
                    "dil mein tere hai jo chupa\n" +
                    "Khwaish jo hai teri\n" +
                    "\n" +
                    "Rakh nahi rakh nahi\n" +
                    "Parda koi mujhse aye jaan\n" +
                    "Kar le tu mera yakin\n" +
                    "\n" +
                    "Mein chahun tujhko\n" +
                    "Meri jaan bepaanah\n" +
                    "Fida hoon tujhpe\n" +
                    "Meri jaan bepaanaha",
            "10 hours ago",
            "https://www.bing.com/th?id=OIP.an2f2KjkPngipwIS15Z19gHaHj&w=106&h=108&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
        ), NewsModel(
            "New Upcoming Super Cars",
            "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n"+
                    "I LOVE YOU    I LOVE YOU\n",
            "1 day ago",
            "https://www.bing.com/th?id=OIP.G8EvxQnKZ_LMVJ6OVIOxdQHaEo&w=316&h=197&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2"
        ),
        NewsModel(
            "School Holidays",
            "",
            "12 hours ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),
        NewsModel(
            "School Holidays",
            "",
            "12 hours ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),
        NewsModel(
            "School Holidays",
            "ef24t54u76uh",
            "12 hours ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),
        NewsModel(
            "School Holidays",
            "erhjtyjhstbdsdfghj",
            "12 hours ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),NewsModel(
            "Sea",
            "erhjtyjhstbdsdfghj",
            "12 hours ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),NewsModel(
            "Shore",
            "erhjtyjhstbdsdfghj",
            "12 hours ago",
            "https://th.bing.com/th/id/R.636537dc613b2dd438993cf656177647?rik=otkgp5UuQIJFBQ&riu=http%3a%2f%2fcdn.thinglink.me%2fapi%2fimage%2f347151190540156928%2f1024%2f10%2fscaletowidth%2f0%2f0%2f1%2f1%2ffalse%2ftrue%3fwait%3dtrue&ehk=dbBWB%2bILC7Qwl%2bxh4T39Q6qi8T1gl8%2b2zV1SCkY8f%2fk%3d&risl=&pid=ImgRaw&r=0"
        ),
    )

fun getDummyHeadLineList() =
    listOf(
        NewsModel(
            "Summers are going to be awesome in Sahara desert",
            "In this poem, Robert Frost uses the act of planting a seed as a metaphor for creating life and giving birth.\n" +
                    "\n" +
                    "You come to fetch me from my work to-night\n" +
                    "When supper’s on the table, and we’ll see\n" +
                    "If I can leave off burying the white\n" +
                    "Soft petals fallen from the apple tree.\n" +
                    "(Soft petals, yes, but not so barren quite,\n" +
                    "Mingled with these, smooth bean and wrinkled pea;)\n" +
                    "And go along with you ere you lose sight\n" +
                    "Of what you came for and become like me,\n" +
                    "Slave to a springtime passion for the earth.\n" +
                    "How Love burns through the Putting in the Seed\n" +
                    "On through the watching for that early birth\n" +
                    "When, just as the soil tarnishes with weed,\n" +
                    "The sturdy seedling with arched body comes\n" +
                    "Shouldering its way and shedding the earth crumbs.",
            "12 hours ago",
            "https://images.pexels.com/photos/3244513/pexels-photo-3244513.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),

        NewsModel(
            "Book you trekking tour starting from Kashmir to Meghalaya.",
            "In this poem, Robert Frost uses the act of planting a seed as a metaphor for creating life and giving birth.\n" +
                    "\n" +
                    "You come to fetch me from my work to-night\n" +
                    "When supper’s on the table, and we’ll see\n" +
                    "If I can leave off burying the white\n" +
                    "Soft petals fallen from the apple tree.\n" +
                    "(Soft petals, yes, but not so barren quite,\n" +
                    "Mingled with these, smooth bean and wrinkled pea;)\n" +
                    "And go along with you ere you lose sight\n" +
                    "Of what you came for and become like me,\n" +
                    "Slave to a springtime passion for the earth.\n" +
                    "How Love burns through the Putting in the Seed\n" +
                    "On through the watching for that early birth\n" +
                    "When, just as the soil tarnishes with weed,\n" +
                    "The sturdy seedling with arched body comes\n" +
                    "Shouldering its way and shedding the earth crumbs.",
            "1 hour ago",
            "https://images.pexels.com/photos/1761279/pexels-photo-1761279.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        NewsModel(
            "Huge power cuts prevailing throughout the country.",
            "",
            "10 hours ago",
            "https://images.pexels.com/photos/1402850/pexels-photo-1402850.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )