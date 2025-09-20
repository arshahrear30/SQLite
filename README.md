# SQLite offline Database

Data base php দিয়ে 
SQlite database Android এর built in নিজস্ব database offline work করে..built in library/plugin টা হচ্ছে SQLightOpenHelper
এই database অনেক light weight and server less..and no internet need .
মনে আছে ? Mysql database run করার জন্য server প্রয়োজন হত । hosting ,AWS-amazon web services,localhost xampp দিয়ে ।
Mysql server এর ক্ষেএে আমরা phpMyadmin use করতে পারতাম যা সব দেখা যাইতো সহজে কিভাবে box এ input দিবো...কিন্তু sqllite এর ক্ষেএে খালি চোখে কিছু দেখা যাবে না কারণ এটা Android a built-in already আছে 


------15
Android studio তে new project খুললাম

------16
package name এর উপর Mouse Right Button > New >> Java class >> class>> Name দাও >>enter  
Name দিলাম : DatabaseHelper । 
এখন extends যুক্ত করবো 
Red Bulb click>>Implements method >>ok
Again we can see Red Bulb .
Red Bulb click>>Create constractor matching super >>ok

 public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //context হলো যেই class এ কাজ করা হয় ঐ class এর environment যেমন : DatabaseHelper
    //String name এখানে name টা হলো database name
    //int version হলো database এর version


  এখন শুধু Context রেখে বাকী তিনটা বাদ দিয়ে দিবো name , factory , version । 
  super এ কিছু update করবো factory প্রয়োজন পড়ে না তাই null use করব ।  name কে "DB_name" দিলাম । version মন মত ধরলাম । 1 ধরলাম । 

সবগুলোকে উপরে variable ধরে করবো তাহলে আরো সুন্দর হয় । 


final static : Java-তে সাধারণত constant define করার জন্য ব্যবহার হয় ..একবার মান assign করলে সেটি আর পরিবর্তন করা যাবে না (final এর জন্য)

    public final static String DB_NAME="DB_name";
    public final static int DB_VERSION=1;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

------20
Right side Setting এর পাশে Search button এ search করো : Device Explorer (USB দিয়ে Device এর সাথে connect থাকে যাতে । >>data>>data>>তোমার pakage name টা খোঁজ>>databases >> এখানে তোমার database file পাই যাইবা 
