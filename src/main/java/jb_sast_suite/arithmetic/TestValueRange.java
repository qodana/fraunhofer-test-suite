// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.arithmetic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestValueRange {
  public static void test(HttpServletRequest request, HttpServletResponse response, boolean condition, int x) throws IOException {
    String taint = request.getHeader("value");
    if (x < 0 || x > 10) return;

    String a = taint;

    if (x == 5) {
      response.getWriter().println(a); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
    }

    if (x == 100) {
      response.getWriter().println(a);
    }
  }
}
