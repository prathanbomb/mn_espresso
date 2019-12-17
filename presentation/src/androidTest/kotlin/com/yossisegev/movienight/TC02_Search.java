package com.yossisegev.movienight;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TC02_Search {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void Search(){
        try{
            ViewInteraction bottomNavigationItemView = onView(allOf(withId(R.id.action_search),
                    withContentDescription("Search"),isDisplayed()));
            bottomNavigationItemView.perform(click());

        String [] words = {"Avengers : Endgame","Avengers : Endgame 3333","Endgame"};
            for(int i=0;i<words.length;i++){
                ViewInteraction SearchEditText  = onView(withId(R.id.search_movies_edit_text));
                    SearchEditText.perform(typeTextIntoFocusedView(words[i]));
                    System.out.println(words[i]);

                Thread.sleep(3000);
                    SearchEditText.perform(clearText());

                    pressBack();
                    Thread.sleep(1000);

            }
//              *** .JSON
//            JSONParser parser = new JSONParser();
//            FileReader fileReader = new FileReader("E:\\Download\\MovieNight_JSON.json");
//            try {
//                Object obj = parser.parse(new FileReader("E:\\Download\\MovieNight.json"));
//
//                JSONArray jsonObjects = (JSONArray) obj;
//                for (Object o : jsonObjects) {
//                    if (o instanceof JSONObject) {
//                        JSONObject jsonObject = (JSONObject) o;
//                        String name = (String) jsonObject.get("Name");
//                        System.out.println(name);
//                    }
//                }
//            }catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (ParseException e){
//                e.printStackTrace();
//            }

//            *** .XLSX
//            File excelFile = new File("E:\\Download\\MovieNight.xlsx");
//            FileInputStream fis = new FileInputStream(excelFile);
//            WORKBOOK workbook = new XSSFWORK();

            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
