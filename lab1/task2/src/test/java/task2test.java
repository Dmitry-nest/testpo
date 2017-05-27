import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class task2test {

    private void assertMinPath(String graph,
                               Integer length, String path) {
        task2 pf = maketask2(graph);
        if (length != null)
            assertEquals((int) length, pf.getLength());
        if (path != null)
            assertEquals(path, pf.getPath().toString());
    }

    private task2 maketask2(String graph) {
        task2 pf = new task2();
        Pattern edgePattern =
                Pattern.compile("(\\D+)(\\d+)(\\D+)");
        String[] edges = graph.split(",");
        for (String edge : edges) {
            Matcher matcher = edgePattern.matcher(edge);
            if (matcher.matches()) {
                String start = matcher.group(1);
                int length = Integer.parseInt(matcher.group(2));
                String end = matcher.group(3);
                pf.addEdge(start, end, length);
            }
        }
        pf.findPath("A", "Z");
        return pf;
    }

    @Test
    public void NullGraphTest() throws Exception {assertMinPath("", 0, "[]");}

    @Test
    public void OneNodeTest() throws Exception {assertMinPath("A", 0, "[]");}

    @Test
    public void NoStartNoFinishTest() throws Exception {assertMinPath("B1C", 0, "[]");}

    @Test
    public void NoFinishTest() throws Exception {assertMinPath("A1C", 0, "[]");}

    @Test
    public void NoStartTest() throws Exception{assertMinPath("B1Z", 0, "[]");}

    @Test
    public void OneEdgeTest() throws Exception {assertMinPath("A1Z", 1, "[A, Z]");}

    @Test
    public void TwoEdgesTest1() throws Exception {assertMinPath("A1B,B1Z", 2, "[A, B, Z]");}

    @Test
    public void TwoEdgesTest2() throws Exception{assertMinPath("B1Z,A1B", 2, "[A, B, Z]");}

    @Test
    public void TwoEdgesTest3() throws Exception{assertMinPath("A1X,Y1Z", 0, "[]");}

    @Test
    public void ThreeEdgesTest1() throws Exception {assertMinPath("A2B,B3C,C4Z", 9, "[A, B, C, Z]");}

    @Test
    public void ThreeEdgesTest2() throws Exception { assertMinPath("B3C,C4Z,A2B", 9, "[A, B, C, Z]");}

    @Test
    public void OnlyOnePathTest1() throws Exception {assertMinPath("A1B,B2C,C3Z,B4D,D6E", 6, "[A, B, C, Z]");}

    @Test
    public void OnlyOnePathTest2() throws Exception {assertMinPath("A1B,B2C,C3D,C3Z", 6, "[A, B, C, Z]");}

    @Test
    public void ParallelPathsSmallGraphTest() throws Exception {assertMinPath("A1B,B2Z,A1Z", 1, "[A, Z]");}

    @Test
    public void ParallelPathsBigGraphTest() throws Exception {assertMinPath("A1B,A1C,A2D,C5E,B8E,C1F,D3F,F2G,G3Z,E2G",
            7,"[A, C, F, G, Z]");}
}
