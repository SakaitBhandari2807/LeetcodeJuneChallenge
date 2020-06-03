import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution3 {
    public int twoCitySchedCost(int[][] costs) {
        ArrayList<Expenditure> expenditures = new ArrayList<>();

        for(int i=0;i<costs.length;i++){
            expenditures.add(new Expenditure(costs[i][0],costs[i][1]));
        }

        Collections.sort(expenditures, new Comparator<Expenditure>() {
            @Override
            public int compare(Expenditure o1, Expenditure o2) {
//                int result = o1.cityA - o2.cityA;
//                if(result == 0){
//                    int rs = o2.cityB - o1.cityB;
//                    if(rs == 0) return result;
//                    else return rs;
//                }
//                else return result;
                return o2.diff - o1.diff;
            }
        });
        int sum = 0,counter_a=costs.length/2,counter_b=costs.length/2;
//        for (Expenditure e:expenditures
//             ) {
//            System.out.println(e.cityA+" "+e.cityB);
//        }

        int index = 0;
        for (int i = 0; i < expenditures.size(); i++) {
            if(counter_a == 0 || counter_b == 0) {index = i;break;}
            Expenditure exp = expenditures.get(i);
            int min = Math.min(exp.cityA,exp.cityB);
            if(min == exp.cityA ) {sum += exp.cityA;counter_a--;}
            else if(min == exp.cityB ) {sum += exp.cityB;counter_b--;}

        }
//        System.out.println("Break "+index+" "+sum);
        for(int i = index ;i<expenditures.size();i++){
            Expenditure e = expenditures.get(i);
            if(counter_a == 0){
                sum += e.cityB;
                counter_b-- ;
            }
            else if(counter_b == 0){
                sum += e.cityA;
                counter_a--;
            }
        }
        return sum;
    }
    public static void main(String args[]){
        Solution3 sol = new Solution3();
        System.out.println(sol.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
        System.out.println(sol.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
        System.out.println(sol.twoCitySchedCost(new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754},{513,337},{499,873},{337,387},{647,917},{76,417}}));
    }
}
class Expenditure{
    int cityA,cityB,diff;

    Expenditure(int city1,int city2){
        this.cityA = city1;
        this.cityB = city2;
        this.diff = Math.abs(city1 - city2);
    }

}
