package interviewPractice.hashTables;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class GroupingDishes {
public static void main(String[] args) {
        String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
        groupingDishes(dishes);
    }

    static String[][] groupingDishes(String[][] dishes) {
        Map<String, TreeSet<String>> ingredientMap = new TreeMap<String,TreeSet<String>>();

        for(int i=0; i<dishes.length; i++){
            for(int j=1; j<dishes[i].length; j++){
                TreeSet<String> ingredentList = ingredientMap.get(dishes[i][j]);
                if(ingredentList == null){
                    ingredentList = new TreeSet<String>();
                    ingredientMap.put(dishes[i][j], ingredentList);
                }
                ingredentList.add(dishes[i][0]);
            }
        }

        String[][] results = new String[ingredientMap.size()][];
        int row = 0;
        for(String key : ingredientMap.keySet()){
            TreeSet<String> ingredentList = ingredientMap.get(key);
            if(ingredentList.size() > 1){
                results[row][0] = key;
                for(int k=0; k<ingredentList.size(); k++){
                    Object[] resultArr = ingredentList.toArray();
                    results[row][k+1] =  (String)resultArr[k];
                }
            }
            row++;
        }
        return results;
    }
}

