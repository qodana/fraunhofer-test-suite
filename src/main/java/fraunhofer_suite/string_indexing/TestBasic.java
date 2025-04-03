// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.string_indexing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestBasic {
  public static void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");

    String guess = "ABC";
    char switchTarget = guess.charAt(1);  // = 'B'

    switch (switchTarget) {
      case 'A':
        response.getWriter().println(taint);
        break;
      case 'B':
        response.getWriter().println(taint);  //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
        break;
      case 'C':
      case 'D':
        response.getWriter().println(taint);
        break;
      default:
        break;
    }
  }
}