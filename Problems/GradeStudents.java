// url : "https://www.hackerrank.com/challenges/grading/problem"

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    // Write your code here
        for(int i = 0;i < grades.size();i++){
            if(grades.get(i) > 37){
                if(grades.get(i) % 5 > 2){
                    grades.set(i,grades.get(i)+(5 - grades.get(i) % 5));
                }
            }
        }
        return grades;
    }

}
