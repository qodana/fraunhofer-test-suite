// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.arithmetic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestFloatOverflow {
  public static void test(HttpServletRequest request, HttpServletResponse response, boolean condition) throws IOException {
    String taint = request.getHeader("value");

    if (Double.MAX_VALUE + 1 == Double.MAX_VALUE) {
      response.getWriter().println(taint); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
    } else {
      response.getWriter().println(taint);
    }
  }
}