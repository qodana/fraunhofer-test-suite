// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.lists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class TestArrayItemReassignment {
  public static void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    String a = taint;
    String b = "safe";

    ArrayList<String> arr = new ArrayList<>();
    arr.add(a);
    arr.add(b);
    arr.add(a);
    arr.add(b);
    arr.set(1, arr.get(0));
    arr.set(2, arr.get(3));

    response.getWriter().println(arr.get(1));  //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
    response.getWriter().println(arr.get(2));
  }
}
