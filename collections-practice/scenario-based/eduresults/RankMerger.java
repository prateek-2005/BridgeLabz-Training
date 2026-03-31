package eduresults;
import java.util.*;
class RankMerger {
    public static List<Student> mergeAllLists(List<List<Student>> districts) {
        List<Student> result = new ArrayList<>();
        for (List<Student> district : districts) {
            result = mergeTwoLists(result, district);
        }
        return result;
    }
    private static List<Student> mergeTwoLists(List<Student> a, List<Student> b) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i).getMarks() > b.get(j).getMarks()) {
                merged.add(a.get(i++));
            }
            else if (a.get(i).getMarks() < b.get(j).getMarks()) {
                merged.add(b.get(j++));
            }
            else {
                merged.add(a.get(i++));
            }
        }
        while (i < a.size()) merged.add(a.get(i++));
        while (j < b.size()) merged.add(b.get(j++));
        return merged;
    }
}
