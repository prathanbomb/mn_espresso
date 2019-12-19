package com.yossisegev.movienight;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TC02_Search {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void Search() {
        try {
            ViewInteraction bottomNavigationItemView = onView(allOf(withId(R.id.action_search),
                    withContentDescription("Search"), isDisplayed()));
            bottomNavigationItemView.perform(click());

            String[] words = {"Avengers : Endgame", "Avengers : Endgame 3333", "Endgame"};
            for (int i = 0; i < words.length; i++) {
                ViewInteraction SearchEditText = onView(withId(R.id.search_movies_edit_text));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
